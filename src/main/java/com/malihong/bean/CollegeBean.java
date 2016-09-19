package com.malihong.bean;

import java.util.HashMap;

public class CollegeBean {

	public static HashMap<Integer, String> totalCollegeName = new HashMap<Integer, String>(32){
		{
			put(2, "Monash University");
			put(4, "Hogwarts University");
			put(6, "Melbourne University");
			put(7, "Deakin University");
			put(8, "Victoria University");
		}
	};
}
