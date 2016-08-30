package com.malihong.bean;

import java.util.HashMap;

public class StaticBean {

	public static HashMap<Integer, String> chineseDegree = new HashMap<Integer, String>(){
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(0, "高中在读");
			put(1, "高中毕业，没参加高考");
			put(2, "高中毕业，有高考成绩");
			put(3, "大学在读");
		}
	};
	
	
	public static HashMap<String, String> chineseMajor = new HashMap<String, String>(){
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Business", "商科");
			put("IT", "IT");
			put("Engineering", "工程");
			put("Education", "教育");
			put("Design", "设计");
			put("Arts", "人文");
			put("Science", "科学");
			put("Law", "法律");
			put("Medicine", "医学");
		}
	};
}
