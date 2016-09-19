package com.malihong.agency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malihong.bean.CollegeBean;
import com.malihong.entity.Account;
import com.malihong.entity.College;
import com.malihong.service.AccountService;
import com.malihong.service.CollegeService;
import com.malihong.service.CookieHelper;
import com.malihong.util.Base64Encript;
import com.malihong.util.RandomNumber;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AccountService accountService;
	@Autowired
	private CollegeService collegeService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {

		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		
		if (null == miwen) {
			
		} else {
			String mingwen = Base64Encript.decode(miwen);
			if (mingwen.contains("&")) {
				String[] parts = mingwen.split("&");
				String uid = parts[0];
				Account account = accountService.findUserById(Integer.parseInt(uid));
				if (null != account) {
					model.addAttribute("loginUser", account);
				}
			}
		}
		
		return "home";
	}
	
	
	@RequestMapping(value = "/api/v1/getCollegeMap", method = RequestMethod.POST)
	public @ResponseBody HashMap<Integer, String> getCollegeMap(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		return CollegeBean.totalCollegeName;
	}
	
	@RequestMapping(value = "/api/v1/getColleges", method = RequestMethod.POST)
	public @ResponseBody List<College> getColleges(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		List<College> list = collegeService.findCollegesByType(1);
		
		return list;
	}
}
