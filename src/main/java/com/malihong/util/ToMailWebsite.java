package com.malihong.util;

public class ToMailWebsite {

	public static String getMailWebsite(String mail) {
		switch(mail){
			case "163.com":
				mail = "mail.163.com";
				break;
			case "126.com":
				mail = "mail.126.com";
				break;
			case "qq.com":
				mail = "mail.qq.com";
				break;
			case "vip.qq.com":
				mail = "mail.qq.com";
				break;
			case "foxmail.com":
				mail = "mail.qq.com";
				break;
			case "gmail.com":
				mail = "mail.google.com";
				break;
			case "sohu.com":
				mail = "mail.sohu.com";
				break;
			case "tom.com":
				mail = "mail.tom.com";
				break;
			case "sina.com":
				mail = "mail.sina.com.cn";
				break;
			case "sina.com.cn":
				mail = "mail.sina.com.cn";
				break;
			case "yahoo.com.cn":
				mail = "mail.cn.yahoo.com";
				break;
			case "yahoo.cn":
				mail = "mail.cn.yahoo.com";
				break;
			case "hotmail.com":
				mail = "www.hotmail.com";
				break;
			default:
				break;
		}
		return mail;
	}
}
