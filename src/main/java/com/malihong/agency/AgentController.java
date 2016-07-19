package com.malihong.agency;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malihong.bean.BeAgentBean;
import com.malihong.entity.Account;
import com.malihong.service.AccountService;
import com.malihong.service.CookieHelper;
import com.malihong.util.Base64Encript;
import com.malihong.util.CountryList;

@Controller
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/toBeAgent", method=RequestMethod.GET)
	public String toBeAgent(Model model, HttpServletRequest request, HttpServletResponse response) {
		
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
		Map<String, String> countryList = CountryList.getCountryList(Locale.CHINESE);
		
		model.addAttribute("beAgentBean", new BeAgentBean());
		model.addAttribute("countryList", countryList);
		return "be_agent";
	}
	
	@RequestMapping(value="/beAgent", method=RequestMethod.POST)
	public String beAgent(@ModelAttribute("beAgentBean") BeAgentBean beAgentBean, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		//个人信息
		String firstname = beAgentBean.getFirstname();
		String surname = beAgentBean.getSurname();
		String address = beAgentBean.getAddress();
		
		return "";
	}
	
}
