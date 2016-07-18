package com.malihong.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {

	public static void saveCookie(String cookieName, String value, boolean remember_me, HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, value);
		if (remember_me == true) {
			cookie.setMaxAge(7*24*60*60);
		}
		cookie.setPath("/agency/");
	    response.addCookie(cookie);
	}
	
	public static String getCookieValue(String cookieName, HttpServletRequest request) {
		String value = null;
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	      int i = 0;
	      boolean cookieExists = false;
	      while (!cookieExists && i < cookies.length) {
	        if (cookies[i].getName().equals(cookieName)) {
	          cookieExists = true;
	          value = cookies[i].getValue();
	        } else {
	          i++;
	        }
	      }
	    }
	    return value;
	}
	
	public static void deleteCookieValue (String cookieName, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookieName.equals(cookie.getName())) {
				cookie.setMaxAge(0);
				cookie.setValue(null);
				cookie.setPath("/agency/");
				response.addCookie(cookie);
				break;
				}
			}
		}
	}
}
