package com.malihong.agency;

import java.io.IOException;
import java.net.URLDecoder;
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
import com.malihong.entity.Request;
import com.malihong.service.StudentRequestService;

@Controller
@RequestMapping(value = "/apply")
public class PayThenApplyController {

	private static final Logger logger = LoggerFactory.getLogger(PayThenApplyController.class);

	@Autowired
	private StudentRequestService reqService;

	// 验证邀请码
	@RequestMapping(value = "/api/codevalidation", method = RequestMethod.GET)
	public @ResponseBody List<Request> getCodeValidation(@RequestParam(value="code",required=true) String code,@RequestParam(value="planid",required=true) int pid){
		ObjectMapper mapper = new ObjectMapper();
		//TODO
		return null;
	}
	
	// 返回plan所对应的中介的联系方式
	@RequestMapping(value = "/api/agentcommunication", method = RequestMethod.GET)
	public @ResponseBody List<Request> getAgentCommunication(@RequestParam(value="planid",required=true) int pid){
		ObjectMapper mapper = new ObjectMapper();
		//TODO
		//checks status(payment)
		//return agent communication
		return null;
	}
	
	// 返回plan所对应的中介的联系方式
	@RequestMapping(value = "/api/finalizeorder", method = RequestMethod.GET)
	public @ResponseBody List<Request> finalizeOrder(@RequestParam(value="planid",required=true) int pid){
		ObjectMapper mapper = new ObjectMapper();
		//TODO
		//update plan
		//update request
		//update order
		//与中介结算服务费
		return null;
	}
	
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
