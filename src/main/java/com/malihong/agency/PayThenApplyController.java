package com.malihong.agency;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.malihong.bean.LoginCookieUtil;
import com.malihong.bean.MailServer;
import com.malihong.entity.Account;
import com.malihong.entity.Order;
import com.malihong.entity.Plan;
import com.malihong.entity.PromotionCode;
import com.malihong.entity.Request;
import com.malihong.service.AccountService;
import com.malihong.service.OrderService;
import com.malihong.service.PlanService;
import com.malihong.service.PromotionCodeService;
import com.malihong.service.StudentRequestService;

@Controller
public class PayThenApplyController {

	private static final Logger logger = LoggerFactory.getLogger(PayThenApplyController.class);

	@Autowired
	private PromotionCodeService codeService;
	@Autowired
	private PlanService planService;
	@Autowired
	private StudentRequestService reqService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AccountService accountService;
	// 验证邀请码
	@RequestMapping(value = "/api/v1/codevalidation", method = RequestMethod.POST)
	public @ResponseBody String getCodeValidation(HttpServletRequest request,@RequestBody String r){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		Integer accountId=LoginCookieUtil.getAccountIdByCookie(request);
		if(accountId==null){
			root.put("status", 1); //未登录
			return root.toString();
		}	
		String code;
		int type, rid;
		try {
			r = URLDecoder.decode(r, "UTF-8");
			HashMap userinfo=mapper.readValue(r, HashMap.class);
			code=(String)userinfo.get("code");
			type=(Integer)userinfo.get("type");
			rid=(Integer)userinfo.get("requestId");
		} catch (Exception e) {
			root.put("status", 2); //request解析失败
			root.put("info", e.getMessage());
			logger.info(e.getMessage());
			return root.toString();
		}
		Request req=this.reqService.findRequestById(rid);
		if(req==null){
			root.put("status", 4); //request不存在
			root.put("info", "no such request");
			return root.toString();
		}
		//验证邀请码
		//System.out.println(code);
		//System.out.println(String.valueOf(rid));
		//System.out.println(String.valueOf(type));
		PromotionCode pc=this.codeService.validateCode(type, code);
		if(pc==null){
			root.put("status", 3);
			root.put("info", "bad code:(");
			return root.toString();
		}
		//寻找中介, 开发使用id： 
		//random selection
		int aid=this.planService.findAgentForNewRequest();
		root.put("agentId", aid);
		//创建plan ->planId
		Plan plan =new Plan();
		plan.setCreatedTime(new Date());
		plan.setStatus(4);
		plan.setIdRequest(rid);
		plan.setIdStudent(accountId);
		plan.setIdAgency(aid);
		this.planService.add(plan);
		int pid=plan.getIdPlan();
		//create order, update request status, update code status
		Order order=new Order();
		order.setCreateTime(new Date());
		order.setStatus(2);
		order.setIdPlan(plan.getIdPlan());
		order.setIdAgency(plan.getIdAgency());
		order.setIdStudent(plan.getIdStudent());
		this.orderService.add(order);
		
		req.setIsCancel(2);
		this.reqService.update(req);
		
		pc.setStatus(1);
		this.codeService.upadte(pc);		
		//向中介发送邮件，提醒尽快联系学生
		String email, title, content;
		Account agent=this.accountService.findUserById(aid);
		email=agent.getEmail();
		title="有新的留学申请需要处理";
		content=agent.getFirstname()+"， 你好！<br><br>";
		content+="我们推荐了一个新的留学申请给你，请尽快登陆网站处理。<br><br>还没想好名字的网站团队 留";
		ExecutorService executorService = Executors.newCachedThreadPool();  
        Future<String> future = executorService.submit(new MailServer(email,title,content));
		return root.toString();
	}
	
	// 返回plan所对应的中介的联系方式->改为向中介发送邮件，提示学生已付款，尽快联系学生
	// TODO
	// untapped in v1
	@RequestMapping(value = "/api/v1/agentcommunication", method = RequestMethod.GET)
	public @ResponseBody List<Request> getAgentCommunication(@RequestParam(value="planid",required=true) int pid){
		ObjectMapper mapper = new ObjectMapper();
		//checks status(payment)
		//return agent communication
		return null;
	}
	
	// 学生确认完结此order
	// TODO
	// untapped in v1
	@RequestMapping(value = "/api/v1/finalizeorder", method = RequestMethod.GET)
	public @ResponseBody List<Request> finalizeOrder(@RequestParam(value="planid",required=true) int pid){
		ObjectMapper mapper = new ObjectMapper();
		//update plan
		//update request
		//update order
		//与中介结算服务费
		return null;
	}
	
	/********************************PAGES**********************************************/
	// untapped in v1
	// TODO
	//价格清单页面
	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public String pricePage() throws JsonProcessingException {
		return "applyrequest";
	}
	
	//输入邀请码页面
	@RequestMapping(value = "/entercode", method = RequestMethod.GET)
	public String promotionCodePage() throws JsonProcessingException {
		return "applyrequest";
	}
	
	//付款后给出中介联系方式页面
	@RequestMapping(value = "/agentcommunication", method = RequestMethod.GET)
	public String agentCommunicationPage() throws JsonProcessingException {
		return "applyrequest";
	}
	
	//学生确认收到offer，完成交易页面
	@RequestMapping(value = "/finalizeorder", method = RequestMethod.GET)
	public String finalizeOrderPage() throws JsonProcessingException {
		return "applyrequest";
	}
}
