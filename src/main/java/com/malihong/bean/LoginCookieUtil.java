package com.malihong.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malihong.service.CookieHelper;
import com.malihong.util.Base64Encript;

public class LoginCookieUtil {

	//从Cookie获取用户账号Id
		public static int getAccountIdByCookie(HttpServletRequest request, HttpServletResponse response) {
			String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
			String mingwen = Base64Encript.decode(miwen);
			String[] array = mingwen.split("&");
			int accountId = Integer.parseInt(array[0]);
			return accountId;
		}
		
		//从Cookie获取用户邮箱
		public static String getEmailByCookie(HttpServletRequest request, HttpServletResponse response) {
			String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
			String mingwen = Base64Encript.decode(miwen);
			String[] array = mingwen.split("&");
			String email = array[1];
			return email;
		}
}
