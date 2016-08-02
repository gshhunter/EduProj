package com.malihong.agency;

import java.io.IOException;
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
import com.malihong.bean.EditProfile;
import com.malihong.bean.EmailBean;
import com.malihong.bean.EmailLoginBean;
import com.malihong.bean.MailServer;
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
		model.addAttribute("account", new Account());
		return "email_register";
	}
	
	@RequestMapping(value="/toCellphoneRegister", method=RequestMethod.GET)
	public String toCellphoneRegister(Locale locale, Model model) {
		logger.info("Welcome cellphone register! The client locale is {}.", locale);
		return "cellphone_register";
	}
	
	@RequestMapping(value="/registerEmail", method=RequestMethod.POST)
	public String registerEmail(@Valid Account account, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "email_register";
		} else {
			String email = account.getEmail();
			String password = account.getPassword();
			String passwordmd5 = MD5Encript.crypt(password);
			
			Profile p = new Profile();
			Identification ident = new Identification();
			
			boolean isEmailExist = this.accountService.checkAccountByEmail(email);
			if (isEmailExist) {
				result.rejectValue("email", "该电子邮件已经存在", "该电子邮件已经存在");
				return "email_register";
			}
			
			account.setPassword(passwordmd5);
			accountService.addNewUser(account, p, ident);
			
			logger.info("Email: " + email + " Password: " + password + " MD5: " + passwordmd5);
			
			return "register_success";
		}
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
	
	@RequestMapping(value="/toViewProfile", method=RequestMethod.GET)
	public String toStudentProfile(Model model) {
		
		return "student_profile";
	}
	
	@RequestMapping(value="/toEditProfile", method=RequestMethod.GET)
	public String toEditProfile(Model model) {
		model.addAttribute("editProfile", new EditProfile());
		return "edit_profile";
	}
	
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
		up.setGender(p.getGender());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(up);
		logger.info("View Profile: " + json);
		
		return json.toString();

	}
	
	@RequestMapping(value="/editProfile", method=RequestMethod.POST)
	public @ResponseBody String editProfile(@RequestBody String r, HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		UserProfile up = new UserProfile();
		ObjectNode root=mapper.createObjectNode();	

		//从Cookie获取账号Id
		int accountId = getAccountIdByCookie(request, response);
		
		try {
			up = mapper.readValue(r, UserProfile.class);
			up.setId(accountId);
		} catch (Exception e) {
			return "";
		}
		
		return "";
	}
	
	//从Cookie获取用户账号Id
	public int getAccountIdByCookie(HttpServletRequest request, HttpServletResponse response) {
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		String mingwen = Base64Encript.decode(miwen);
		String[] array = mingwen.split("&");
		int accountId = Integer.parseInt(array[0]);
		return accountId;
	}
	
	//从Cookie获取用户邮箱
	public String getEmailByCookie(HttpServletRequest request, HttpServletResponse response) {
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		String mingwen = Base64Encript.decode(miwen);
		String[] array = mingwen.split("&");
		String email = array[1];
		return email;
	}
}
