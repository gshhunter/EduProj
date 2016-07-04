package com.malihong.agency;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		//Testing Account addUser function
//			Account account = new Account();
//			account.setEmail("asdadadada");
//			account.setUsername("Shuhao");
//			
//			Profile profile = new Profile();
//			profile.setPostcode(1234);
//			
//			Identification ident = new Identification();
//			ident.setQq("12345678");
//			ident.setIsQq(1);
//			
//			accountService.addNewUser(account, profile, ident);
			
		//Testing Account addUser function - end
			
		//Testing Account addUser function
//			Account account1 = accountService.findUserById(3);
//			Profile p = account1.getProfile();
//			p.setCountry("Dayang");
//			accountService.update(account1);
		//Testing Account addUser function - end
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
}
