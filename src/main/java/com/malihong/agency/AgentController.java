package com.malihong.agency;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malihong.bean.BeAgentBean;
import com.malihong.util.CountryList;

@Controller
@RequestMapping("/agent")
public class AgentController {

	@RequestMapping(value="/toBeAgent", method=RequestMethod.GET)
	public String toBeAgent(Model model) {
		Map<String, String> countryList = CountryList.getCountryList(Locale.CHINESE);
		
		model.addAttribute("beAgentBean", new BeAgentBean());
		model.addAttribute("countryList", countryList);
		return "be_agent";
	}
	
	@RequestMapping(value="/beAgent", method=RequestMethod.POST)
	public String beAgent(@ModelAttribute("beAgentBean") BeAgentBean beAgentBean, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		return "";
	}
	
//	protected Map referenceData(HttpServletRequest request) throws Exception {
//		Map referenceData = new HashMap();
//		Map<String,String> country = new LinkedHashMap<String,String>();
//
//		referenceData.put("countryList", country);
//		return referenceData;
//	}
}
