<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Email login page">

    <title>登录页面</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <!--[if lte IE 8]>
    
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
    
    <![endif]-->
    <!--[if gt IE 8]><!-->
    
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    
    <!--<![endif]-->
    
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <!--[if lte IE 8]>
        <link rel="stylesheet" href="css/layouts/marketing-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="<c:url value="/resources/css/layouts/marketing.css" />" >
    <!--<![endif]-->
	<style>
		#main-content {
			position: absolute;
			top: 50px;
			width: 100%;
		}
		.error {
			color: red;
		}
	</style>
</head>
<body>

	<div class="header">
	    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
	        <a class="pure-menu-heading" href="<%=request.getContextPath() %>">Logo</a>
	
	        <ul class="pure-menu-list">
	            <li class="pure-menu-item"><a href="#" class="pure-menu-link">成为留学顾问</a></li>
	            <li class="pure-menu-item"><a href="<%=request.getContextPath() %>/account/toEmailRegister" class="pure-menu-link">注册</a></li>
	            <li class="pure-menu-item"><a href="<%=request.getContextPath() %>/account/toEmailLogin" class="pure-menu-link">登录</a></li>
	        </ul>
	    </div>
	</div>
	
	<div class="content" id="main-content">
		
		<h2 class="content-head is-center">邮箱登录<!-- <a href="">手机登录</a> --></h2>
			
		<form:form class="pure-form pure-form-stacked" method="POST" commandName="emailLoginBean" action="loginEmail" >
			<fieldset>
				<legend>用户登录</legend>
				<div class="pure-g">
					<!-- 行1 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <form:label path="email">电子邮箱</form:label>
                        <form:input path="email" class="pure-input-1" type="email" placeHolder="电子邮箱"/>
                        <form:label path="email" class="hint">
                    		<form:errors path="email" cssClass="error" />
                    	</form:label>
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">

                    </div>
                    <!-- 行1 end -->
                    
                    <!-- 行2 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <form:label path="password">密码</form:label>
                        <form:password path="password" class="pure-input-1" placeHolder="密码"/>
                        <form:label path="password">
                    		<form:errors path="password" cssClass="error" />
                    	</form:label>
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    	
                    </div>
                    <!-- 行2 end -->
                    
                    <!-- 行3 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    	<form:label path="remember_me" class="pure-checkbox">
                    		<form:checkbox path="remember_me" /> &nbsp;&nbsp;记住登录密码
                    	</form:label>
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    	<label for="forget">
                    		<a id="forget" href="<%=request.getContextPath() %>/account/forgetPwd">忘记密码？</a> | <a href="">去注册</a>
                    	</label>
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    
                    </div>
                    <!-- 行3 end -->
                    
                    <!-- 行4 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <input class="pure-button pure-input-1" type="submit" value="登录" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 行4 end -->
				</div>
			</fieldset>
		</form:form>
		
	</div>
	
	<div class="footer l-box is-center"> Malimaligong.com ® </div>

</body>
</html>