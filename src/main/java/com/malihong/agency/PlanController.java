package com.malihong.agency;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malihong.bean.GaokaoInfo;
import com.malihong.bean.StaticBean;
import com.malihong.entity.Account;
import com.malihong.entity.Plan;
import com.malihong.entity.Request;
import com.malihong.service.AccountService;
import com.malihong.service.PlanService;
import com.malihong.service.StudentRequestService;
import com.malihong.util.CookieUtil;

@Controller
public class PlanController {

	@Autowired
	private PlanService planService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private StudentRequestService requestService;
	
	@RequestMapping(value="/api/v1/getPlan", method=RequestMethod.GET)
	public @ResponseBody String getPlan(@RequestParam(value="pid", required=true) Integer pid , HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		return "";
	}
	
	@RequestMapping(value="/plan/toCaseDetail.do", method=RequestMethod.GET)
	public String toCaseDetail(@RequestParam(value="pid", required=true) Integer pid , HttpServletRequest request, HttpServletResponse response, Model model) {
		Plan plan = planService.findPlanById(pid);
		model.addAttribute("plan", plan);
		String loginEmail = CookieUtil.getEmailByCookie(request, response);
		model.addAttribute("loginEmail", loginEmail);
		
		if (plan == null) {
			return "casedetail-noplan";
		} else {
			int status = plan.getStatus();
			int studentid = plan.getIdStudent();
			int requestid = plan.getIdRequest();
			
			Account account = accountService.findUserById(studentid);
			Request req = requestService.findRequestById(requestid);
			
			String degree = StaticBean.chineseDegree.get(req.getCurrentDegree());
			String province = GaokaoInfo.chineseLocation.get(req.getGaokaoLocation());
			String requestMajor = StaticBean.chineseMajor.get(req.getInterestMajor1());
			req.setGaokaoLocation(province);
			req.setInterestMajor1(requestMajor);
			
			model.addAttribute("degree", degree);
			model.addAttribute("account", account);
			model.addAttribute("request", req);
			
			if (status == 1) {
				return "casedetail-ing";
			} 
			
			if (status == 2) {
				return "casedetail-done";
			}
			
			return "casedetail-noplan";
		}
		
		
	}
	
	@RequestMapping(value="/plan/toVisaRefNumber.do", method=RequestMethod.GET)
	public String toVisaRefNumber(Model model) {

		return "add_visa_ref";
	}
	
	@RequestMapping(value="/api/v1/saveTRN", method=RequestMethod.GET)
	public @ResponseBody String saveTRN(@RequestParam(value="pid", required=true) Integer pid, @RequestParam(value="trn", required=true) String trn , HttpServletRequest request, HttpServletResponse response, Model model){
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = mapper.createObjectNode();
		root.put("status", 0);
		
		Plan plan = planService.findPlanById(pid);
		model.addAttribute("plan", plan);
		
		if (plan == null) {
			root.put("status", -1);
			return root.toString();
		} else {
			int status = plan.getStatus();
			int studentid = plan.getIdStudent();
			int requestid = plan.getIdRequest();
			
			Account account = accountService.findUserById(studentid);
			Request req = requestService.findRequestById(requestid);
			
			String degree = StaticBean.chineseDegree.get(req.getCurrentDegree());
			String province = GaokaoInfo.chineseLocation.get(req.getGaokaoLocation());
			String requestMajor = StaticBean.chineseMajor.get(req.getInterestMajor1());
			req.setGaokaoLocation(province);
			req.setInterestMajor1(requestMajor);
			
			model.addAttribute("degree", degree);
			model.addAttribute("account", account);
			model.addAttribute("request", req);
			
			if (status == 1) {
				plan.setStatus(2);
				plan.setTrn(trn);
				planService.update(plan);
				root.put("status", 1);
				return root.toString();
			} 
			
			if (status == 2) {
				root.put("status", 2);
				return root.toString();
			} 
				return root.toString();
		}
	}
}
