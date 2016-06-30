package com.malihong.agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.malihong.entity.Request;
import com.malihong.service.StudentRequestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping(value = "/req")
public class StudentRequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentRequestController.class);

	
	@Autowired
	private StudentRequestService reqService;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST,produces = "application/json")
	public String newRequest(@RequestBody Request r){
		logger.info(r.toString());
		//this.reqService.save(r);
		return "fortest";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody Shop newtest(){
		logger.info("get!");
		Shop shop=new Shop();
		shop.name="sss";
		shop.staffName=new String[]{"mkyong1", "mkyong2"};
		//this.reqService.save(r);
		return shop;
	}
	
	public class Shop {

		String name;
		String staffName[];
		
	}
}
