package com.malihong.agency;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malihong.bean.EmailLoginBean;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;
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
	public String toEmailLogin(Model model) {
		
		model.addAttribute("emailLoginBean", new EmailLoginBean());
		
		return "email_login";
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
}
