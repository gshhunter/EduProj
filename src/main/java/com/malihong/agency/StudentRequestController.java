package com.malihong.agency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Option;
import com.malihong.entity.Plan;
import com.malihong.entity.Profile;
import com.malihong.entity.Request;
import com.malihong.service.AccountService;
import com.malihong.service.PlanService;
import com.malihong.service.StudentRequestService;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/req")
public class StudentRequestController {

	private static final Logger logger = LoggerFactory.getLogger(StudentRequestController.class);

	@Autowired
	private StudentRequestService reqService;
	@Autowired
	private PlanService planService;
	@Autowired
	private AccountService aService;


	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public @ResponseBody String newRequest(@RequestBody String r) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		Request re = new Request();
		try{
		re = mapper.readValue(r, Request.class);

		re.setIdAccount(12345);
		
		this.reqService.save(re);
		}catch(Exception e){
			return null;
		}
		String s = mapper.writeValueAsString(re);
		logger.info(s);
		return s;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String applyRequestPage() throws JsonProcessingException {
		logger.info("get!");

		return "applyrequest";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String newtest() throws JsonProcessingException {
		logger.info("test!");
		Option o =new Option();
		Option o2 =new Option();
		o.setUniversity("Moanash");
		o.setStatus(10);
		o2.setUniversity("NU");
		Plan p=new Plan();
		List<Option> os = new ArrayList<Option>();
		os.add(o);
		os.add(o2);
		p.setOptions(os);
		p.setIdAgency(12345);
		p.setIdStudent(12345);
		p.setIdRequest(123);
		p.setStatus(3);
		this.planService.add(p);
		
		/*Account a=new Account();
		Profile pro=new Profile();
		Identification iden=new Identification();
		iden.setCellphone("1234567890");
		pro.setCityName("Mel");
		//a.setProfile(pro);
		a.setLastname("test");
		a.setEmail("qqq@qqq.com");
		this.aService.addNewUser(a, pro, iden);*/
		return "requestcomplete";
	}
}
