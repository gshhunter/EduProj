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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malihong.bean.LoginCookieUtil;
import com.malihong.bean.MailServer;
import com.malihong.entity.Account;
import com.malihong.entity.Agency;
import com.malihong.entity.Order;
import com.malihong.entity.Plan;
import com.malihong.entity.PromotionCode;
import com.malihong.entity.Request;
import com.malihong.service.AccountService;
import com.malihong.service.AgencyService;
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
	@Autowired
	private AgencyService agencyService;
	
	// 验证邀请码
	// Updated in v2
	@RequestMapping(value = "/api/v1/codevalidation", method = RequestMethod.POST)
	public @ResponseBody String getCodeValidation(HttpServletRequest request,@RequestBody String r){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();		
		
		Integer accountId=LoginCookieUtil.getAccountIdByCookie(request);
		if(accountId==null){
			root.put("status", 1); //未登录
			return root.toString();
		}	
		String code;
		int type;
		try {
			r = URLDecoder.decode(r, "UTF-8");
			HashMap userinfo=mapper.readValue(r, HashMap.class);
			code=(String)userinfo.get("code");
			type=(Integer)userinfo.get("type");
		} catch (Exception e) {
			root.put("status", 2); //request解析失败
			root.put("info", e.getMessage());
			logger.info(e.getMessage());
			return root.toString();
		}

		//验证邀请码
		//System.out.println(code);
		//System.out.println(String.valueOf(type));
		PromotionCode pc=this.codeService.validateCode(type, code);
		if(pc==null){
			root.put("status", 3);
			root.put("info", "bad code:(");
			return root.toString();
		}

		//create order, [update request status,] update code status
		Order order=new Order();
		order.setCreateTime(new Date());
		order.setStatus(2);
		order.setIdVendor(0);
		order.setIdPurchaser(accountId);
		order.setType(type);
		this.orderService.add(order);
		
		pc.setStatus(1);
		this.codeService.upadte(pc);	
		
		root.put("status", 0);
		return root.toString();
	}
	
	// 返回中介List （8个）
	// reviewed in v2
	@RequestMapping(value = "/api/v1/agencylist", method = RequestMethod.GET)
	public @ResponseBody String getAgencyList(HttpServletRequest request){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root=mapper.createObjectNode();		

		Integer accountId=LoginCookieUtil.getAccountIdByCookie(request);
		if(accountId==null){
			root.put("status", 1); //未登录
			root.put("info", "please log in");
			return root.toString();
		}
		if(!this.orderService.isPaid(accountId, 1)){
			root.put("status", 2);
			root.put("info", "unpaid");
			return root.toString();
		}
		JsonNode node= mapper.convertValue(this.agencyService.getAgencyList(8), JsonNode.class);
		root.put("status", 0);
		root.put("agency", node);
		return root.toString();
	}

}
