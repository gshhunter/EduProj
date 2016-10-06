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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malihong.bean.LoginCookieUtil;
import com.malihong.bean.MailServer;
import com.malihong.bean.RedisServerPool;
import com.malihong.entity.Account;
import com.malihong.entity.Option;
import com.malihong.entity.Plan;
import com.malihong.entity.Request;
import com.malihong.service.AccountService;
import com.malihong.service.CookieHelper;
import com.malihong.service.OptionService;
import com.malihong.service.PlanService;
import com.malihong.service.PromotionCodeService;
import com.malihong.service.StudentRequestService;
import com.malihong.util.Base64Encript;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class StudentRequestController {

	private static final Logger logger = LoggerFactory.getLogger(StudentRequestController.class);

	@Autowired
	private StudentRequestService reqService;
	@Autowired
	private PlanService planService;
	@Autowired
	private OptionService optionService;
	@Autowired
	private PromotionCodeService codeService;
	@Autowired
	private AccountService accountService;

	// 学生创建新的request
	// v1 complete: 2016/08/26
	@RequestMapping(value = "/api/v1/newrequest", method = RequestMethod.POST)
	public @ResponseBody String newRequest(HttpServletRequest request,@RequestBody String r) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		Integer accountId=LoginCookieUtil.getAccountIdByCookie(request);
		if(accountId==null){
			root.put("status", 1); //未登录
			return root.toString();
		}
		
		r = URLDecoder.decode(r, "UTF-8");
		Request re = new Request();		
		try {
			re = mapper.readValue(r, Request.class);
		} catch (Exception e) {
			root.put("status", 2); //request解析失败
			root.put("info", e.getMessage());
			logger.info(e.getMessage());
			return root.toString();
		}
		
		if(re.getInterestCity()==null||re.getCurrentDegree()==0||re.getInterestMajor1()==null){
			root.put("status", 3); //request解析失败
			root.put("info", "非法数据请求");
			return root.toString();
		}
//		if(re.getIdAccount()==0){
//			root.put("status", 4); //未知用户
//			return root.toString();
//		}
			re.setIdAccount(accountId);
			re.setCreatedTime(new Date());		
			//re.setCurrentDegree(2);
			re.setGaokaoYear(2016);
			//re.setInterestCity("MelBySys");
			re.setGaokaoLocation("untapped");
			re.setGaokaoResult(0);
			this.reqService.save(re);
			
			root.put("requestId", re.getIdRequest());
			return root.toString();
	}
	
	//
	@RequestMapping(value = "/api/v1/systemplan", method = RequestMethod.GET)
	public @ResponseBody String getPlanByRequestId(@RequestParam(value="rid",required=true) Integer rid){
		Request re=this.reqService.findRequestById(rid);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		if(re==null){
			root.put("status", 1); //未找到对应的request
			return root.toString();
		}
		Object[] objs=this.planService.generateOptionsByRequest(re);
		if((Integer)objs[0]==1){
			JsonNode node= mapper.convertValue(objs[2], JsonNode.class);
			root.put("options", node);
		}
		root.put("result", (Integer)objs[0]);
		root.put("info", (String)objs[1]);
		return root.toString();
	}

	// 中介查看待回应的requests（中介未回应，未过期，isCancel状态正常）
	// untapped in v1
	@RequestMapping(value = "/api/v1/getactiverequestlist", method = RequestMethod.GET)
	public @ResponseBody List<Request> getActiveRequestList(@RequestParam(value="page",required=false) Integer page){
		logger.info("get");
		ObjectMapper mapper = new ObjectMapper();
		int agentID=67890;
		List<Request> list=this.reqService.findUnresponsedActiveRequestsByAgentID(agentID);
		logger.info("get list");
		return list;
	}

	// 中介为request创建plan
	// v2
	@RequestMapping(value = "/api/v1/newplan", method = RequestMethod.POST)
	public @ResponseBody String newPlan(HttpServletRequest request,@RequestBody String r) throws JsonParseException, JsonMappingException, IOException {
		r = URLDecoder.decode(r, "UTF-8");		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();
		Plan planFromAgent=new Plan();
		Integer agentID=LoginCookieUtil.getAccountIdByCookie(request);
		if(agentID==null){
			root.put("status", 1); //未登录
			root.put("info", "no login");
			return root.toString();
		}
		try {
			planFromAgent = mapper.readValue(r, Plan.class);
		} catch (Exception e) {
			root.put("status", 2); //data error
			root.put("info", e.getMessage());
			return root.toString();
		}
		Plan plan= this.planService.findByRequestIdAndAgencyId(planFromAgent.getIdRequest(),agentID);
		if(plan==null){
			root.put("status", 3); //no plan
			root.put("info", "request id does not match agent id");
			return root.toString();
		}
		plan.setStatus(5);
		this.planService.update(plan);

		List<Option> options=planFromAgent.getOptions();
		logger.info(String.valueOf(plan.getIdPlan()));
		for(Option option:options){
			option.setIdPlan(plan.getIdPlan());
			System.out.println(option.getAdvice());
			this.optionService.add(option);
		}
		root.put("status", 0);
		root.put("planId", plan.getIdPlan());
		return root.toString();
	}

	// 学生查看正在进行中的request
	// untapped in v1
	@RequestMapping(value = "/api/v1/getactiverquest", method = RequestMethod.GET)
	public @ResponseBody Request getActiveRequest() throws JsonParseException, JsonMappingException, IOException {
		int accountId=12345;
		Request r=this.reqService.findValidRequestByUserId(accountId);
		return r;
	}

	// 学生查看与request对应的plans
	// untapped in v1
	@RequestMapping(value = "/api/v1/getplanlist", method = RequestMethod.GET)
	public @ResponseBody List<Plan> getPlanList(@RequestParam(value="requestid") int requestId) throws JsonParseException, JsonMappingException, IOException {
		logger.info("get");
		List<Plan> list =this.planService.findPlansByRequestId(requestId);
		return list;
	}
	
	// 检查登陆, 返回用户基本信息
	// v1 complete: 2016/08/26
	@RequestMapping(value = "/api/v1/userinfo", method = RequestMethod.GET)
	public @ResponseBody String getUserInfo(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();	
		Integer id=LoginCookieUtil.getAccountIdByCookie(request);
		if(id==null){
			root.put("login", "false");
			root.put("err", "unlogged");
			return root.toString();
		}else{
			root.put("login", "true");
			root.put("id", id);
			root.put("email", LoginCookieUtil.getEmailByCookie(request));
			return root.toString();
		}

	}

	// 验证登录
	// v1 complete: 2016/08/26
	@RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
	public @ResponseBody String login(HttpServletResponse response,@RequestBody String r){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();
		String email,password;		
		try {
			r = URLDecoder.decode(r, "UTF-8");
			HashMap userinfo=mapper.readValue(r, HashMap.class);
			email=(String)userinfo.get("email");
			password=(String)userinfo.get("password");
		} catch (Exception e) {
			root.put("status", 3); //request解析失败
			root.put("info", e.getMessage());
			logger.info(e.getMessage());
			return root.toString();
		}
		Account a = this.accountService.findUserByEmail(email);
		if(a==null){
			root.put("status", 1); //无此用户
			root.put("info", "no such user");
			return root.toString();
		}else if(!a.getPassword().equals(password)){
			root.put("status", 2); //密码错误
			root.put("info", "incorrect password");
			return root.toString();
		}else{
			root.put("status", 0);
			root.put("info", "log in");
			Date currentDate = new Date();
			long time = currentDate.getTime();
			String mingwen = a.getIdAccount() + "&" + email + "&" + time;
			String miwen = Base64Encript.encode(mingwen);
			CookieHelper.saveCookie("EDUJSESSION", miwen, true, response);
			return root.toString();
		}
	}
	
	//For Test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String newtest(HttpServletRequest request,@RequestParam(value="id") int id) throws JsonProcessingException, UnsupportedEncodingException {
		logger.info("test!");
		Integer acc=LoginCookieUtil.getAccountIdByCookie(request);
		logger.info(String.valueOf(acc));
		logger.info(String.valueOf(id));
        //ExecutorService executorService = Executors.newCachedThreadPool();  
        //Future<String> future = executorService.submit(new MailServer("lingkai.xu@gmail.com","中文","<h1>测试</h1>"));  

        //从连接池获得一个连接
		//Jedis jedis = RedisServerPool.getResource();
		//set数据
		//jedis.set("akey", "this is value");
		//根据key来get数据
		//System.out.println("Redis:" + jedis.get("akey"));
		//使用后把资源归还连接池
		//RedisServerPool.returnResource(jedis);
		List<Request> reqs = new ArrayList<Request>();
		Request req=new Request();
		req.setIdAccount(123);
		reqs.add(req);
		req.setIdAccount(123456);
		reqs.add(req);
		ObjectMapper mapper = new ObjectMapper();

		ObjectNode root=mapper.createObjectNode();		
		root.put("status", acc);
		//String json=mapper.writeValueAsString(reqs);
		//JsonNode node = mapper.convertValue(reqs, JsonNode.class);

		//root.put("options", node);
		return root.toString();
	}
}
