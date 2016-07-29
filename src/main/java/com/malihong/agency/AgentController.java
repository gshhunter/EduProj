package com.malihong.agency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malihong.bean.BeAgentBean;
import com.malihong.entity.Account;
import com.malihong.entity.Profile;
import com.malihong.service.AccountService;
import com.malihong.service.CookieHelper;
import com.malihong.util.Base64Encript;
import com.malihong.util.CountryList;

@Controller
@RequestMapping("/agent")
public class AgentController {

	private static final Logger logger = LoggerFactory.getLogger(AgentController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/toBeAgent", method=RequestMethod.GET)
	public String toBeAgent(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		
		if (null == miwen) {
			return "email_login";
		} else {
			String mingwen = Base64Encript.decode(miwen);
			if (mingwen.contains("&")) {
				String[] parts = mingwen.split("&");
				String uid = parts[0];
				Account account = accountService.findUserById(Integer.parseInt(uid));
				if (null != account) {
					model.addAttribute("loginUser", account);
					model.addAttribute("login_email", parts[1]);
					if (account.getType() == 2) {
						return "agent_apply";
					}
				}
			}
		}
		Map<String, String> countryList = CountryList.getCountryList(Locale.CHINESE);
		
		model.addAttribute("beAgentBean", new BeAgentBean());
		model.addAttribute("countryList", countryList);
		return "be_agent";
	}
	
	@RequestMapping(value="/beAgent", method=RequestMethod.GET)
	public String beAgent(@ModelAttribute("beAgentBean") BeAgentBean beAgentBean, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		
		if (null == miwen) {
			logger.info("------- miwen is null -------");
			return "error";
		} else {
			String mingwen = Base64Encript.decode(miwen);
			String[] parts = mingwen.split("&");
			String uid = parts[0];
			Account account = accountService.findUserById(Integer.parseInt(uid));
			
			//Applying agent：已经申请，还没有审核通过
			if (account.getType() == 2) {
				return "agent_apply";
			}

			//agent：已审核通过的agent
			if (account.getType() == 3) {
				
			}
			
			//无效用户，跳转错误页面
			if (account.getType() == 1) {
				
			}
			
			model.addAttribute("loginUser", account);
			model.addAttribute("login_email", account.getEmail());
			
			//个人信息
			String firstname = beAgentBean.getFirstname();
			String surname = beAgentBean.getSurname();
			String address = beAgentBean.getAddress();
			String birthday = beAgentBean.getBirthday();
			String postcode = beAgentBean.getPostcode();
			String city = beAgentBean.getCity();
			String country = beAgentBean.getCountry();
			String state = beAgentBean.getState();
			
			//国家选项
			Map<String, String> countryList = CountryList.getCountryList(Locale.CHINESE);
			model.addAttribute("countryList", countryList);
			
			//页面验证
			if (null == surname || "".equals(surname.trim())) {
				result.rejectValue("surname", "请输入您的真实姓", "请输入您的真实姓");
				return "be_agent";
			}
			
			logger.info("Surname: " + surname);
			
			if (null == firstname || "".equals(firstname.trim())) {
				result.rejectValue("firstname", "请输入您的真实名", "请输入您的真实名");
				return "be_agent";
			}
			
			if (null == birthday || "".equals(birthday)) {
				result.rejectValue("birthday", "请选择您的出生日期", "请选择您的出生日期");
				return "be_agent";
			}
			
			if (null == address || "".equals(address.trim())) {
				result.rejectValue("address", "请输入您的街道地址", "请输入您的街道地址");
				return "be_agent";
			}
			
			if (null == postcode || "".equals(postcode.trim())) {
				result.rejectValue("postcode", "请输入邮政编码", "请输入邮政编码");
				return "be_agent";
			}
			
			if (null == city || "".equals(city.trim())) {
				result.rejectValue("city", "请填写所在城市", "请填写所在城市");
				return "be_agent";
			}
			
			if (null == state || "".equals(state.trim())) {
				result.rejectValue("state", "请填写所在城市", "请填写所在城市");
				return "be_agent";
			}
			
			if (null == country || "NONE".equals(country.trim())) {
				result.rejectValue("country", "请填写所在国家", "请填写所在国家");
				return "be_agent";
			}
			
			Profile p = account.getProfile();
			
			//Change
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(birthday);
			p.setBirthday(date);
			p.setCityName(city);
			p.setCountry(country);
			p.setHomeAddress(address);
			p.setPostcode(Integer.parseInt(postcode));
			p.setState(state);
			p.setFirstname(firstname);
			p.setSurname(surname);
			
			logger.info("--------------------");
			logger.info("country：" + country);
			logger.info("--------------------");
			account.setProfile(p);
			//2: applying
			account.setType(2);
			accountService.update(account);
			
			return "agent_apply";
		}
	}
}
