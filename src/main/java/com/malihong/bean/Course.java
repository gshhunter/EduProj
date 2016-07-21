package com.malihong.bean;

import java.util.List;
import java.util.Map;

public class Course {
	public String name;
	public int duration; 	//semesters???
	public String intakes; 	//中文说明
	public int tuition;		//AUD
	public int entryDegree;	//same as that in request table
	List<String> fields;
	Map<String,Integer> gaokao;
}
