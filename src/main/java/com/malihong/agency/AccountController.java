package com.malihong.agency;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malihong.bean.ChangePwd;
import com.malihong.bean.EditProfile;
import com.malihong.bean.EmailBean;
import com.malihong.bean.EmailLoginBean;
import com.malihong.bean.MailServer;
import com.malihong.bean.RegisterAccount;
import com.malihong.bean.ResetPasswordBean;
import com.malihong.bean.UserProfile;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;
import com.malihong.entity.ResetPwd;
import com.malihong.service.AccountService;
import com.malihong.service.CookieHelper;
import com.malihong.util.Base64Encript;
import com.malihong.util.CountryList;
import com.malihong.util.MD5Encript;
import com.malihong.validation.ValidationUtil;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/toEmailLogin", method=RequestMethod.GET)
	public String toEmailLogin(Model model, HttpServletRequest request) {
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		if (null != miwen) {
			
			return "home";
		} else {
			model.addAttribute("emailLoginBean", new EmailLoginBean());
			return "email_login";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		CookieHelper.deleteCookieValue("EDUJSESSION", request, response);
		model.addAttribute("userLogin", null);
		return "home";
	}
	
	/**
	 * 登录邮箱账号
	 * @param emailLoginBean
	 * @param result
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/loginEmail", method=RequestMethod.POST)
	public String loginEmail(@ModelAttribute("emailLoginBean") EmailLoginBean emailLoginBean, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String email = emailLoginBean.getEmail();
		String password = emailLoginBean.getPassword();
		boolean remember_me = emailLoginBean.isRemember_me();
		
		logger.info("----------form info---------");
		logger.info("Email: " + email);
		logger.info("Password: " + password);
		logger.info("Remember me: " + remember_me);
		
		if (email == null || "".equals(email.trim())) {
			result.rejectValue("email", "电子邮件不能为空，请重新输入", "电子邮件不能为空，请重新输入");
			return "email_login";
		}
		
		if (!ValidationUtil.isEmail(email)) {
			result.rejectValue("email", "不符合电子邮件格式，请重新输入", "不符合电子邮件格式，请重新输入");
			return "email_login";
		}
		
		if (password == null || "".equals(password)) {
			result.rejectValue("password", "密码不能为空，请重新输入", "密码不能为空，请重新输入");
			return "email_login";
		}
		
		if (!ValidationUtil.isPassword(password)) {
			result.rejectValue("password", "密码只能是6-32位的字母数字和下划线，开头必须为字母，请重新输入", "密码只能是6-32位的字符数字和下划线，开头必须为字母，请重新输入");
			return "email_login";
		}
		
		Account account = accountService.findUserByEmail(email);
		
		if (null == account) {
			result.rejectValue("email", "该电子邮箱还未注册，请前往注册页面", "该电子邮箱还未注册，请前往注册页面");
			return "email_login";
		} else {
			if (!account.getPassword().equals(MD5Encript.crypt(password))) {
				result.rejectValue("email", "您的电子邮箱或密码错误，请重新输入", "您的电子邮箱或密码错误，请重新输入");
				return "email_login";
			} else {
				Date currentDate = new Date();
				long time = currentDate.getTime();
				String mingwen = account.getIdAccount() + "&" + email + "&" + time;
				String miwen = Base64Encript.encode(mingwen);
				//新建并保存Cookie
				CookieHelper.saveCookie("EDUJSESSION", miwen, remember_me, response);
				model.addAttribute("loginUser", account);
			}
		}
		
		return "home";
	}
	
	@RequestMapping(value="/toEmailRegister", method=RequestMethod.GET)
	public String toEmailRegister(ModelMap model) {
		model.addAttribute("account", new RegisterAccount());
		return "email_register";
	}
	
	@RequestMapping(value="/toCellphoneRegister", method=RequestMethod.GET)
	public String toCellphoneRegister(Locale locale, Model model) {
		logger.info("Welcome cellphone register! The client locale is {}.", locale);
		return "cellphone_register";
	}
	
	/**
	 * 注册邮箱
	 * @param account
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registerEmail", method=RequestMethod.POST)
	public String registerEmail(@ModelAttribute("account") RegisterAccount account, BindingResult result, ModelMap model) {

		String email = account.getEmail();
		String password = account.getPassword();
		String firstname = account.getFirstname();
		String lastname = account.getLastname();
		String passwordmd5 = MD5Encript.crypt(password);
		
		Account a = new Account();
		Profile p = new Profile();
		Identification ident = new Identification();
		
		if (!ValidationUtil.isEmail(email)) {
			result.rejectValue("email", "请输入正确的电子邮箱", "请输入正确的电子邮箱");
			return "email_register";
		}
		
		if (!ValidationUtil.isPassword(password)) {
			result.rejectValue("password", "请输入6-24位密码，密码只能包含大小写字母、数字和下划线", "请输入6-24位密码，密码只能包含大小写字母、数字和下划线");
			return "email_register";
		}
		
		if (firstname == null || "".equals(firstname.trim())) {
			result.rejectValue("firstname", "请输入你的名称", "请输入你的名称");
			return "email_register";
		}
		
		if (lastname == null || "".equals(lastname.trim())) {
			result.rejectValue("lastname", "请输入你的姓氏", "请输入你的姓氏");
			return "email_register";
		}
		
		boolean isEmailExist = this.accountService.checkAccountByEmail(email);
		if (isEmailExist) {
			result.rejectValue("email", "该电子邮件已经存在", "该电子邮件已经存在");
			return "email_register";
		}
		
		a.setEmail(email);
		a.setPassword(passwordmd5);
		a.setLastname(lastname);
		a.setFirstname(firstname);
		accountService.addNewUser(a, p, ident);
		
		logger.info("Email: " + email + " Password: " + password + " MD5: " + passwordmd5);
		return "register_success";
	}
	
	@RequestMapping(value="/forgetPwd", method=RequestMethod.GET)
	public String toForgetPassword(ModelMap model) {
		model.addAttribute("emailBean", new EmailBean());
		return "forget_pwd";
	}
	
	@RequestMapping(value="/toChangePwd", method=RequestMethod.POST)
	public String toChangePwd(@ModelAttribute("emailBean") EmailBean emailBean, BindingResult result, ModelMap model) {
		String email = emailBean.getEmail();
		String code = emailBean.getCode();
		
		if (null == email || "".equals(email.trim())) {
			result.rejectValue("email", "请输入正确的电子邮件", "请输入正确的电子邮件");
			return "forget_pwd";
		}
		
		if (!ValidationUtil.isEmail(email)) {
			result.rejectValue("email", "请输入正确的电子邮件", "请输入正确的电子邮件");
			return "forget_pwd";
		}
		
		if (null == code || "".equals(code.trim())) {
			result.rejectValue("code", "请输入您的验证码", "请输入您的验证码");
			return "forget_pwd";
		}
		return "change_pwd";
	}
	
	@RequestMapping(value="/reset_password", method=RequestMethod.GET)
	public String toResetPwd(@RequestParam(value="sid", required=false) String sid , @RequestParam(value="email", required=false) String email, ModelMap model, HttpServletResponse response) {
		if (sid == null || "".equals(sid.trim()) || email ==null || "".equals(email.trim())) {
			return "error_mail";
		}
		
		List<ResetPwd> list = accountService.findResetListByEmail(email);
		if (list == null) {
			return "error_mail";
		}
		
		//明文格式：<email>&<uuid_key>&<expire>
		for (ResetPwd reset : list) {
			String md5 = MD5Encript.crypt(reset.getEmail() + "&" + reset.getCode() + "&" + reset.getSendTime());
			if (md5.equals(sid.trim())) {
				CookieHelper.saveCookie("EDUEMAIL", email, false, response);
				model.addAttribute("resetPasswordBean", new ResetPasswordBean());
				return "reset_pwd";
			}
		}
		return "error_mail";
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public String resetPassword(Model model, @ModelAttribute("resetPasswordBean") ResetPasswordBean resetPasswordBean, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		
		String email = getResetEmail(request, response);
		String newPass = resetPasswordBean.getNew_pass();
		String confirmPass = resetPasswordBean.getConfirm_pass();
		
		if (newPass == null || "".equals(newPass.trim())) {
			result.rejectValue("new_pass", "请输入您的新密码", "请输入您的新密码");
			return "reset_pwd";
		}
		
		if (confirmPass == null || "".equals(confirmPass.trim())) {
			result.rejectValue("confirm_pwd", "请输入您的确认密码", "请输入您的确认密码");
			return "reset_pwd";
		}
		
		if (!ValidationUtil.isPassword(newPass)) {
			result.rejectValue("new_pass", "请输入正确的密码格式", "请输入正确的密码格式");
			return "reset_pwd";
		}
		
		if (!confirmPass.equals(newPass)) {
			result.rejectValue("confirm_pwd", "两次输入密码不一致", "两次输入密码不一致");
			return "reset_pwd";
		}
		
		Account account = accountService.findUserByEmail(email);
		account.setPassword(MD5Encript.crypt(newPass));
		accountService.update(account);
		
		return "home";
	}
	
	//获取重置用户的邮箱
	public String getResetEmail(HttpServletRequest request, HttpServletResponse response) {
		String miwen = CookieHelper.getCookieValue("EDUEMAIL", request);

		return miwen;
	}
	
	/**
	 * 发送密码重置邮件的API
	 * @param reset
	 * @param email
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/api/sendResetMail", method=RequestMethod.GET)
	public @ResponseBody String sendResetMail (@ModelAttribute("reset") ResetPwd reset, @RequestParam(value="email", required=true) String email) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = mapper.createObjectNode();
		root.put("status", 0);
		
		if (null == email || "".equals(email.trim())) {
			root.put("status", 0);
			return root.toString();
		}
		
		if (!ValidationUtil.isEmail(email)) {
			root.put("status", 0);
			return root.toString();
		} else {
			boolean isExist = accountService.checkAccountByEmail(email);
			if (!isExist) {
				root.put("status", -1);
				logger.info("不存在： " + email);
				logger.info(root.toString());
				return root.toString();
			} else {
				
				String key = UUID.randomUUID().toString();
				long expire = new Date().getTime() + 60*60;
				
				//明文格式：<email>&<uuid_key>&<expire>
				String mingcode = email + "&" + key + "&" + expire;
				String micode = MD5Encript.crypt(mingcode);
				String url = "http://localhost:8080/agency/account/reset_password?sid=" + micode + "&email=" + email;
				
				reset.setCode(key);
				reset.setEmail(email);
				reset.setSendTime(expire);
				
				accountService.addResetCode(reset);
				
				//发送邮件接口
				ExecutorService executorService = Executors.newCachedThreadPool();  
		        Future<String> future = executorService.submit(new MailServer(email,"密码重置","<h1>" + url + "</h1>"));
		        
				root.put("status", 1);
				return root.toString();
			}
		}
	}
	
	/**
	 * 去密码重置页面
	 * @param vid
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/verify_email", method=RequestMethod.GET)
	public String toResetPwd(@RequestParam(value="vid", required=true) String vid, HttpServletRequest request, HttpServletResponse response, Model model){
		if (vid == null || "".equals(vid.trim()) ) {
			return "error_mail";
		}
		
		int accountId = getAccountIdByCookie(request, response);
		Account account = accountService.findUserById(accountId);
		String email = account.getEmail();
		
		String mingwen = accountId + "&" + email;
		String miwen = MD5Encript.crypt(mingwen);
		
		if (!vid.equals(miwen)) {
			return "error_mail";
		}
		
		Identification ident = account.getIdentification();
		ident.setEmail(email);
		ident.setIsEmail(1);
		account.setIdentification(ident);
		accountService.update(account);
		
		return "trust_verification";
	}
	
	/**
	 * 发送邮箱账号验证邮件
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/api/sendVerificationMail", method=RequestMethod.GET)
	public @ResponseBody String sendVerificationMail(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = mapper.createObjectNode();
		root.put("status", 0);
		
		String cookieEmail = getEmailByCookie(request, response);
		if (cookieEmail == null || "".equals(cookieEmail.trim())) {
			root.put("status", 0);
			return root.toString();
		}
		
		boolean isExist = accountService.checkAccountByEmail(cookieEmail);
		
		if (!isExist) {
			root.put("status", -1);
			logger.info("不存在： " + cookieEmail);
			logger.info(root.toString());
			return root.toString();
		}
		
		int accountId = getAccountIdByCookie(request, response);
		
		String mingwen = accountId + "&" + cookieEmail;
		String miwen = MD5Encript.crypt(mingwen);
		
		String url = "http://localhost:8080/agency/account/verify_email?vid=" + miwen;
		
		//发送邮件接口
		ExecutorService executorService = Executors.newCachedThreadPool();  
        Future<String> future = executorService.submit(new MailServer(cookieEmail,"邮箱账号验证","<h1>" + url + "</h1>"));
        logger.info("邮箱账号验证邮件发送成功");
        root.put("status", 1);
		return root.toString();
	}
	
	/**
	 * 跳转至ViewProfile页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toViewProfile", method=RequestMethod.GET)
	public String toStudentProfile(Model model) {
		
		return "student_profile";
	}
	
	/**
	 * 跳转至EditProfile页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toEditProfile", method=RequestMethod.GET)
	public String toEditProfile(Model model) {
		model.addAttribute("editProfile", new EditProfile());
		return "edit_profile";
	}
	
	/**
	 * 获取用户的Profile的API
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value="/api/getProfile", method=RequestMethod.POST)
	public @ResponseBody String getProfile(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		String mingwen = Base64Encript.decode(miwen);
		String[] array = mingwen.split("&");
		String email = array[1];
		
		Account account = accountService.findUserByEmail(email);
		Profile p = account.getProfile();
		Identification ident = account.getIdentification();
		
		String chinese_name = null;
		if (p.getCountry() != null) {
			Map<String, String> map = CountryList.getCountryList(Locale.CHINESE);
			chinese_name = map.get(p.getCountry());
		}
		
		UserProfile up  = new UserProfile();
		up.setId(account.getIdAccount());
		up.setEmail(account.getEmail());
		up.setCellphone(account.getCellphone());
		up.setCountry(chinese_name);
		up.setEng_country(p.getCountry());
		up.setState(p.getState());
		up.setCity(p.getCityName());
		up.setAddress(p.getHomeAddress());
		up.setPostcode(p.getPostcode());
		up.setFirstname(account.getFirstname());
		up.setLastname(account.getLastname());
		up.setUserType(account.getType());
		up.setRegTime(account.getRegTime());
		up.setIsEmail(ident.getIsEmail());
		up.setIsCellphone(ident.getIsCellphone());
		up.setIsPassport(ident.getIsPassport());
		up.setIsWeibo(ident.getIsWeibo());
		up.setIsWechat(ident.getIsWechat());
		up.setIsQq(ident.getIsQq());
		up.setWeibo(ident.getWeibo());
		up.setWechat(ident.getWechat());
		up.setQq(ident.getQq());
		up.setGender(p.getGender());
		up.setBirthday(p.getBirthday());
		up.setDescription(p.getDescription());
		up.setPrivacy_setting(account.getPrivacy_setting());
		up.setSecurity_setting(account.getSecurity_setting());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(up);
		logger.info("View Profile: " + json);
		
		return json.toString();
	}
	
	@RequestMapping(value="/api/saveProfile", method=RequestMethod.POST)
	public @ResponseBody String saveProfile(@RequestBody String r, HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();
		root.put("status", 1);
		
		//获取登录用户账户
		int accountId = getAccountIdByCookie(request, response);
		Account account = accountService.findUserById(accountId);
		Profile p = account.getProfile();
		Identification ident = account.getIdentification();
		
		//把传参转化为UserProfile对象
		try {
			UserProfile up = mapper.readValue(r, UserProfile.class);
			account.setFirstname(up.getFirstname());
			account.setLastname(up.getLastname());
			account.setCellphone(up.getCellphone());
			p.setBirthday(up.getBirthday());
			p.setCountry(up.getCountry());
			p.setGender(up.getGender());
			p.setHomeAddress(up.getAddress());
			p.setPostcode(up.getPostcode());
			p.setDescription(up.getDescription());
			logger.info("-------------------: " + up.getDescription());
			account.setProfile(p);
			accountService.update(account);
		} catch (Exception ex) {
			root.put("status", -1);
		}
		return root.toString();
	}
	
	@RequestMapping(value="/api/setPrivacy", method=RequestMethod.GET)
	public @ResponseBody String setPrivacy(@RequestParam(value="pid", required=true) String pid, HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();
		
		if(pid == null || "".equals(pid.trim())) {
			logger.info("-------------pid should not be null");
			root.put("status", -1);
			return root.toString();
		}
		
		String email = getEmailByCookie(request, response);
		
		if (!accountService.checkAccountByEmail(email)) {
			root.put("status", -2);
			return root.toString();
		}
		
		Account account = accountService.findUserByEmail(email);
		
		try {
			int pcode = Integer.parseInt(pid);
			
			if (pcode == 0) {
				account.setPrivacy_setting(0);
				accountService.update(account);
				root.put("status", 1);
			} else if (pcode == 1) {
				account.setPrivacy_setting(1);
				accountService.update(account);
				root.put("status", 1);
			} else {
				root.put("status", -3);
			}
		} catch (NumberFormatException e) {
			logger.info("-------------pid is not a number");
			root.put("status", -4);
			return root.toString();
		}

		return root.toString();
	}
	
	@RequestMapping(value="/toVerification", method=RequestMethod.GET)
	public String toVerification(Model model) {
		return "trust_verification";
	}
	
	@RequestMapping(value="/toPrivacySetting", method=RequestMethod.GET)
	public String toPrivacySetting(Model model) {
		return "privacy_setting";
	}
	
	@RequestMapping(value="/toSecuritySetting", method=RequestMethod.GET)
	public String toSecuritySetting(Model model) {
		return "security_setting";
	}
	
	@RequestMapping(value="/api/changePassword", method=RequestMethod.POST)
	public @ResponseBody String changePassword(@RequestBody String r, HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = mapper.createObjectNode();
	    root.put("status", 0);
	    
		String cookieEmail = getEmailByCookie(request, response);
		
		//用户不是登陆状态,返回错误页面
	    if (cookieEmail == null || "".equals(cookieEmail.trim())) {
	    	root.put("status", -2);
	    	return root.toString();
	    }
	    
	    //不存在这个Email
	    if (!accountService.checkAccountByEmail(cookieEmail)) {
	    	root.put("status", -3);
	    	return root.toString();
	    }
	    
	    Account account = accountService.findUserByEmail(cookieEmail);
	   
		try {
			ChangePwd cp = mapper.readValue(r, ChangePwd.class);
			
			String oldpwd = cp.getOldpwd();
			String newpwd = cp.getNewpwd();
			String againpwd = cp.getAgainpwd();
			logger.info("---------------------- " + oldpwd);
			//后台校验 不可为null
			if (oldpwd == null || "".equals(oldpwd.trim()) || newpwd == null || "".equals(newpwd.trim()) || againpwd == null || "".equals(againpwd.trim())) {
				root.put("status", -1);
				return root.toString();
			}
			
			//判断旧密码是否正确
			String md5pass = MD5Encript.crypt(oldpwd);
			if (!md5pass.equals(account.getPassword())) {
				root.put("status", -4);
				return root.toString();
			}
			
			//两次输入密码不相同
			if (!newpwd.equals(againpwd)) {
				root.put("status", -5);
				return root.toString();
			}
			
			account.setPassword(MD5Encript.crypt(newpwd));
			accountService.update(account);
			root.put("status", 1);
			
		} catch (Exception e) {
			root.put("status", -1);
			return root.toString();
		}
		
		return root.toString();
	}
	
	//从Cookie获取用户账号Id
	public static int getAccountIdByCookie(HttpServletRequest request, HttpServletResponse response) {
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		String mingwen = Base64Encript.decode(miwen);
		String[] array = mingwen.split("&");
		int accountId = Integer.parseInt(array[0]);
		return accountId;
	}
	
	//从Cookie获取用户邮箱
	public static String getEmailByCookie(HttpServletRequest request, HttpServletResponse response) {
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		String mingwen = Base64Encript.decode(miwen);
		String[] array = mingwen.split("&");
		String email = array[1];
		return email;
	}
}
