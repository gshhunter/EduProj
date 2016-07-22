<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Reset Password Page">

    <title>重置密码页面</title>
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
			top: 35px;
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
		
		<h2 class="content-head is-center"><b>重置密码<!-- | <a href="">手机注册</a> --></b></h2>
			
		<form:form class="pure-form pure-form-stacked" method="POST" commandName="resetPasswordBean" action="resetPassword" >
			<fieldset>
				<legend>输入新密码</legend>
				<div class="pure-g">
					<!-- 行1 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <form:label path="new_pass">*新密码</form:label>
                        <form:input path="new_pass" class="pure-input-1" type="email" placeHolder="新密码"/>
                    	<form:errors path="new_pass" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 行1 end -->
                    
                    <!-- 行2 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <form:label path="confirm_pass">*确认密码</form:label>
                        <form:password path="confirm_pass" class="pure-input-1" placeHolder="再次输入新密码"/>
                    	<form:errors path="confirm_pass" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 行2 end -->
                    
                    <!-- 行3 -->
                    
                    <!-- 行3 end -->
                    
                    
                    <!-- 行4 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    	<br/>
                        <input class="pure-button pure-input-1" type="submit" value="重置密码" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 行4 end -->
                    <br/>
                    
                    <!-- 行5 -->
                    
                    <!-- 行5 end -->
				</div>
			</fieldset>
		</form:form>
		
	</div>
	
	<div class="footer l-box is-center"> Malimaligong.com ® </div>

</body>
</html>