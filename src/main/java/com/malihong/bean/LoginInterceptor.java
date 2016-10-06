package com.malihong.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.malihong.service.CookieHelper;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    
    @Override
	 public boolean preHandle(HttpServletRequest request,
	         HttpServletResponse response,
	         Object handler) throws Exception {
		 
		 String miwen = CookieHelper.getCookieValue("EDUJSESSION", request);
		 String url = request.getRequestURI().replace(request.getContextPath(), "");
		 logger.info("----------------- URI: " + url);
		 if (null != miwen || url.equals("/account/toEmailLogin.do") || url.equals("/account/toEmailRegister.do")) {
			return true; 
		 }
		 String header = request.getContextPath();
		 System.out.println(header);
		 response.sendRedirect(header + "/account/toEmailLogin.do");
		 return false;
	 }
 
}
