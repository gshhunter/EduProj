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
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.malihong.entity.Option;
import com.malihong.entity.Plan;
import com.malihong.entity.Request;
import com.malihong.service.OptionService;
import com.malihong.service.PlanService;
import com.malihong.service.StudentRequestService;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
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
	private OptionService optionService;
	
	
	//开发：学生ID：12345； 中介ID：67890
	// 学生创建新的request
	@RequestMapping(value = "/api/newrequest", method = RequestMethod.POST)
	public @ResponseBody String newRequest(@RequestBody String r) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		Request re = new Request();		
		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		//TODO
		int accountId=12345;
		try {
			re = mapper.readValue(r, Request.class);
			re.setIdAccount(accountId);
			re.setCreatedTime(new Date());
			this.reqService.save(re);
		} catch (Exception e) {
			//应该把一场状态进一步细分
			root.put("status", 1);
		}
		logger.info(root.toString());
		return root.toString();
	}

	// 中介查看待回应的requests（中介未回应，未过期，isCancel状态正常）
	@RequestMapping(value = "/api/getactiverequestlist", method = RequestMethod.GET)
	public @ResponseBody List<Request> getActiveRequestList(@RequestParam(value="page",required=false) Integer page){
		logger.info("get");
		ObjectMapper mapper = new ObjectMapper();
		//TODO
		int agentID=67890;
		List<Request> list=this.reqService.findUnresponsedActiveRequestsByAgentID(agentID);
		logger.info("get list");
		return list;
	}

	// 中介为request创建plan
	@RequestMapping(value = "/api/newplan", method = RequestMethod.POST)
	public @ResponseBody String newPlan(@RequestBody String r) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");		
		ObjectMapper mapper = new ObjectMapper();
		Plan plan= new Plan();
		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		//TODO
		int agentID=67890;
		try {
			plan = mapper.readValue(r, Plan.class);
			plan.setCreatedTime(new Date());
			plan.setIdAgency(agentID);
			//
			List<Option> options=plan.getOptions();
			plan.setOptions(null);
			this.planService.add(plan);
			logger.info(String.valueOf(plan.getIdPlan()));
			for(Option option:options){
				option.setIdPlan(plan.getIdPlan());
				this.optionService.add(option);
			}

			
			Request req=new Request();
			req.setIsCancel(1);
			req.setIdRequest(plan.getIdRequest());
			this.reqService.update(req);
		} catch (Exception e) {
			root.put("status", 1);
		}
		return root.toString();
	}

	// 学生查看正在进行中的request
	@RequestMapping(value = "/api/getactiverquest", method = RequestMethod.GET)
	public @ResponseBody Request getActiveRequest() throws JsonParseException, JsonMappingException, IOException {
		//TODO
		int accountId=12345;
		Request r=this.reqService.findValidRequestByUserId(accountId);
		return r;
	}

	// 学生查看与request对应的plans
	@RequestMapping(value = "/api/getplanlist", method = RequestMethod.GET)
	public @ResponseBody List<Plan> getPlanList(@RequestParam(value="requestid") int requestId) throws JsonParseException, JsonMappingException, IOException {
		List<Plan> list =this.planService.findPlansByRequestId(requestId);
		return list;
	}

	//学生创建request页面
	@RequestMapping(value = "/req", method = RequestMethod.GET)
	public String applyRequestPage() throws JsonProcessingException {
		return "applyrequest";
	}

	//学生创建request成功页面
	@RequestMapping(value = "/reqcom", method = RequestMethod.GET)
	public String requestCompletePage() throws JsonProcessingException {
		return "requestcomplete";
	}
	
	//中介查看待回应requests页面
	
	//中介创建plan页面
	
	//学生查看request页面（可能包括收到的plans）
	
	
	//For Test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody Plan newtest() throws JsonProcessingException {
		logger.info("test!");
		Option o = new Option();
		Option o2 = new Option();
		o.setUniversity("Moanash");
		o.setStatus(10);
		o2.setUniversity("NU");
		Plan p = new Plan();
		List<Option> os = new ArrayList<Option>();
		os.add(o);
		os.add(o2);
		p.setOptions(os);
		p.setIdAgency(12345);
		p.setIdStudent(12345);
		p.setIdRequest(123);
		p.setStatus(3);
		//this.planService.add(p);

		/*
		 * Account a=new Account(); Profile pro=new Profile(); Identification
		 * iden=new Identification(); iden.setCellphone("1234567890");
		 * pro.setCityName("Mel"); //a.setProfile(pro); a.setLastname("test");
		 * a.setEmail("qqq@qqq.com"); this.aService.addNewUser(a, pro, iden);
		 */
		return p;
	}
}
