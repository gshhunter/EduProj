package com.malihong.agency;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;
import com.malihong.service.AccountService;
import com.malihong.util.MD5Encript;

@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
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
