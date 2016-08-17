package com.malihong.bean;

import java.util.HashMap;

public class GaokaoInfo {

	public static HashMap<String, Integer>totalScoreByLocation=new HashMap<String, Integer>(32){
		{
			put("Anhui",750);			//安徽
			put("Beijing",750);			//北京
			put("Chongqing",750);		//重庆
			put("Fujian",750);			//福建
			put("Gansu",750);			//甘肃
			put("Guangxi",750);			//广西
			put("Guangdong",750);		//广东
			put("Guizhou",750);			//贵州
			put("Hainan",900);			//海南
			put("Hebei",750);			//河北
			put("Heilongjiang",750);	//黑龙江
			put("Henan",750);			//河南
			put("Hubei",750);			//湖北
			put("Hunan",750);			//湖南
			put("Inner Mongolia",750);	//内蒙古
			put("Jiangsu",480);			//江苏
			put("Jiangxi",750);			//江西
			put("Jilin",750);			//吉林
			put("Liaoning",750);		//辽宁
			put("Ningxia",750);			//宁夏
			put("Qinghai",750);			//青海
			put("Shandong",750);		//山东
			put("Shanghai",600);		//上海
			put("Shanxi",750);			//山西
			put("Shaanxi",750);			//陕西
			put("Sichuan",750);			//四川
			put("Tianjin",750);			//天津
			put("Tibet",750);			//西藏
			put("Xinjiang",750);		//新疆
			put("Yunnan",772);			//云南
			put("Zhejiang",810);		//浙江
		}
	};
	
	public static int percentageMark(String province, double mark){
		int pmark=0;
		Integer total=totalScoreByLocation.get(province);
		if(total!=null){
			pmark=Integer.valueOf((int) Math.round((mark/total)*100));
		}
		
		return pmark;
	}
}
