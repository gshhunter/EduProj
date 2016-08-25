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
import com.malihong.bean.GaokaoInfo;
import com.malihong.bean.StaticBean;
import com.malihong.entity.Account;
import com.malihong.entity.Plan;
import com.malihong.entity.Request;
import com.malihong.service.AccountService;
import com.malihong.service.PlanService;
import com.malihong.service.StudentRequestService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private StudentRequestService requestService;
	
	@RequestMapping(value="/api/getPlan", method=RequestMethod.GET)
	public @ResponseBody String getPlan(@RequestParam(value="pid", required=true) Integer pid , HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		return "";
	}
	
	@RequestMapping(value="/toCaseDetail", method=RequestMethod.GET)
	public String toCaseDetail(@RequestParam(value="pid", required=true) Integer pid , HttpServletRequest request, HttpServletResponse response, Model model) {
		Plan plan = planService.findPlanById(pid);
		model.addAttribute("plan", plan);
		
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
}
