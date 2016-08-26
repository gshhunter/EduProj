package com.malihong.agency;

import java.util.Date;
import java.util.List;

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
import com.malihong.entity.Order;
import com.malihong.entity.Plan;
import com.malihong.entity.PromotionCode;
import com.malihong.entity.Request;
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
	
	// 验证邀请码
	@RequestMapping(value = "/api/v1/codevalidation", method = RequestMethod.POST)
	public @ResponseBody String getCodeValidation(@RequestParam(value="code",required=true) String code,@RequestParam(value="planid",required=true) int pid,@RequestParam(value="type",required=true) int type){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();		
		root.put("status", 0);
		
		PromotionCode pc=this.codeService.validateCode(type, code);
		if(pc==null){
			root.put("status", 1);
		}else{
			pc.setStatus(1);
			Plan plan=this.planService.findPlanById(pid);
			if(plan==null){
				root.put("status", 2);
			}else{
				plan.setStatus(1);
				Request req=this.reqService.findRequestById(plan.getIdRequest());
				if(req==null){
					root.put("status", 3);
				}else{
					//update plan status, request status, create order, update code status
					this.planService.update(plan);

					req.setIsCancel(2);
					this.reqService.update(req);
					
					Order order=new Order();
					order.setCreateTime(new Date());
					order.setStatus(2);
					order.setIdPlan(plan.getIdPlan());
					order.setIdAgency(plan.getIdAgency());
					order.setIdStudent(plan.getIdStudent());
					this.orderService.add(order);
					
					this.codeService.upadte(pc);
					
					//想中介发送邮件，提醒尽快联系学生
				}
			}
		}
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
