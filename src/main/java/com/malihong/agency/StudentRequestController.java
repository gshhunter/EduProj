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
import com.malihong.entity.University;
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
	public @ResponseBody String newRequest(@RequestBody String r) throws JsonParseException, JsonMappingException, IOException{
		logger.info(r);
		String r2=URLDecoder.decode(r, "UTF-8");
		logger.info(r2);

		ObjectMapper mapper = new ObjectMapper();
		Request re=new Request();
		re=mapper.readValue(r2, Request.class);

		re.setIdAccount(12345);
		this.reqService.save(re);
		String s = mapper.writeValueAsString(re);
		logger.info(s);
		return "seccu";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Shop newtest(@RequestParam String aaa) throws JsonProcessingException{
		logger.info("get!");
		Shop shop=new Shop();
		shop.name=aaa;
		shop.staffName=new String[]{"mkyong1", "mkyong2"};

		return shop;
	}
	
	public class Shop {

		public Shop(){
			
		};
		public String name;
		public String staffName[];
		
	}
}
