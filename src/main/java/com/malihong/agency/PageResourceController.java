package com.malihong.agency;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malihong.entity.BachelorCourse;
import com.malihong.entity.College;
import com.malihong.entity.DiplomaCourse;
import com.malihong.entity.FoundationCourse;
import com.malihong.entity.Request;
import com.malihong.service.CollegeService;
import com.malihong.service.StudentRequestService;

@Controller
@RequestMapping(value = "/api/v1")
public class PageResourceController {
	private static final Logger logger = LoggerFactory.getLogger(PageResourceController.class);

	@Autowired
	private StudentRequestService reqService;
	@Autowired
	private CollegeService collegeService;
	
	//University list
	//college list
	@RequestMapping(value = "/collegelistbytype", method = RequestMethod.GET)
	public @ResponseBody List<College> getUniList(@RequestParam(value="type",required=true) Integer type){
//		class uni{
//			public int id;
//			public String name;
//			public uni(int id, String name){
//				this.id=id;
//				this.name=name;
//			}
//		}
//		ObjectMapper mapper = new ObjectMapper();
//		ObjectNode root=mapper.createObjectNode();
//		List<College> list =this.collegeService.findCollegesByType(1);
//		JsonNode node= mapper.convertValue(list, JsonNode.class);
//		root.put("result", node);
		return this.collegeService.findCollegesByType(type);
	}
	
	//Bachelor list by university id
	//Bachelor info
	@RequestMapping(value = "bachelorlistbyuniversity", method = RequestMethod.GET)
	public @ResponseBody List<BachelorCourse> getBachelorList(@RequestParam(value="uid",required=true) Integer uid){
		return this.collegeService.findBachelorCourseByUniversityId(uid);
	}
	
	//diploma list by college id
	//diploma info 
	@RequestMapping(value = "diplomalistbycollege", method = RequestMethod.GET)
	public @ResponseBody List<DiplomaCourse> getDiplomaList(@RequestParam(value="cid",required=true) Integer cid){
		return this.collegeService.findDiplomaCourseByCollegeId(cid);
	}
	
	//foundation by college id
	//foundation info
	@RequestMapping(value = "foundationlistbycollege", method = RequestMethod.GET)
	public @ResponseBody List<FoundationCourse> getFoundationList(@RequestParam(value="cid",required=true) Integer cid){
		return this.collegeService.findFoundationCourseByCollegeId(cid);
	}
}
