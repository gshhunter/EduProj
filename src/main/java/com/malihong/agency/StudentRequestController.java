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
import com.malihong.entity.Request;
import com.malihong.service.StudentRequestService;

import java.io.IOException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/req")
public class StudentRequestController {

	private static final Logger logger = LoggerFactory.getLogger(StudentRequestController.class);

	@Autowired
	private StudentRequestService reqService;

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

		return "requestcomplete";
	}
}
