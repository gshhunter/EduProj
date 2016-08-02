<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Email register page">

    <title>成为留学顾问</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
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
	        <a class="pure-menu-heading" href="<%=request.getContextPath() %>">Malimalihong</a>
	
	        <ul class="pure-menu-list">
	            <li class="pure-menu-item"><a href="<%=request.getContextPath() %>/toBeAgent" class="pure-menu-link">成为留学顾问</a></li>
	            <li class="pure-menu-item"><a href="<%=request.getContextPath() %>" class="pure-menu-link">${login_email}</a></li>
	            <li class="pure-menu-item"><a href="<%=request.getContextPath() %>/account/logout" class="pure-menu-link">注销</a></li>
	        </ul>
	    </div>
	</div>
	
	<div class="content" id="main-content">
		
		<h2 class="content-head is-center"><b>申请成为留学顾问</b></h2>
			
		<form:form class="pure-form pure-form-stacked" method="GET" commandName="beAgentBean" action="beAgent">
			<fieldset>
				<legend>顾问认证信息填写</legend>
				<div class="pure-g">
				
					<!-- 1 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                        <form:label path="surname">*真实姓</form:label>
                        <form:input path="surname" class="pure-input-1" placeHolder="真实姓"/>
                        <form:errors path="surname" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    	<form:label path="firstname">*真实名</form:label>
                    	<form:input path="firstname" class="pure-input-1" placeHolder="真实名"/>
                    	<form:errors path="firstname" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 1-->
                    
					<!-- 2 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <form:label path="birthday">*出生日期</form:label>
                        <form:input id="datepicker" path="birthday" class="pure-input-1" placeHolder="出生日期" value="" readonly="true" />
                        <form:errors path="birthday" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 2 -->
                    
                    <!-- 3 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                        <form:label path="address">*详细地址</form:label>
                        <form:input path="address" class="pure-input-1" placeHolder="详细地址" />
                        <form:errors path="address" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 3 -->
                    
                    <!-- 4 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                        <form:label path="postcode">*邮编</form:label>
                        <form:input path="postcode" class="pure-input-1" placeHolder="邮编"/>
                        <form:errors path="postcode" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    	<form:label path="city">*所在城市</form:label>
                    	<form:input path="city" class="pure-input-1" placeHolder="城市"/>
                    	<form:errors path="city" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 4 -->
                    
                    <!-- 5 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    	<form:label path="state">*所在省/州</form:label>
                    	<form:input path="state" class="pure-input-1" placeHolder="省/州"/>
                    	<form:errors path="state" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    	<form:label path="country">*所在国家</form:label>
                    	<form:select path="country" class="pure-input-1">
						   <form:option value="NONE" label="--- 选择所在国家  ---"/>
						   <form:options items="${countryList}" />
						</form:select>
						<form:errors path="country" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 5 -->
                    
                    <!-- 行4 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    	<br/>
                        <input class="pure-button pure-input-1" type="submit" value="成为顾问" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 行4 end -->
                    <br/>
                    
                    <!-- 行5 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    	<p><b>单击"创建账户"，即表示同意XXX的<a href="">条款和条件</a>以及<a href="">隐私策略</a></b></p>
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    <!-- 行5 end -->
				</div>
			</fieldset>
		</form:form>
	</div>
	
	<div class="footer l-box is-center"> Malimaligong.com ® </div>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  	<script src="<c:url value="/resources/js/datepicker/datepicker-zh-CN.js" />"></script>
  	<script>
	  	$( function() {
	  	    $( "#datepicker" ).datepicker({
	  	    	changeMonth:true,
	  	    	changeYear:true
	  	    });
	  	  	$( "#datepicker" ).datepicker("option", $.datepicker.regional["zh-CN"]);  	    
	  	} );
  	</script>
</body>
</html>