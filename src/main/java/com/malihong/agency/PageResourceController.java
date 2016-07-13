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
public class PageResourceController {
	private static final Logger logger = LoggerFactory.getLogger(PageResourceController.class);

	@Autowired
	private StudentRequestService reqService;
	
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
	
	//学生创建request页面
	@RequestMapping(value = "/req", method = RequestMethod.GET)
	public String applyRequestPage() throws JsonProcessingException {
		return "applyrequest";
	}
}
