<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Forget Password Page">

    <title>忘记密码页面</title>
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
		#sendEmail, #errorMsg {
			position:relative;
			top: 47px;
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
		
		<h2 class="content-head is-center"><b>找回密码<!-- | <a href="">手机注册</a> --></b></h2>
			
		<form:form class="pure-form pure-form-stacked" method="POST" commandName="emailBean" action="changePwd" >
			<fieldset>
				<legend>向邮箱发送验证</legend>
				<div class="pure-g">
					<!-- 行1 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-4 pure-u-lg-1-4">
                        <form:label path="email">电子邮箱</form:label>
                        <form:input id="email" path="email" class="pure-input-1" type="email" placeHolder="电子邮箱"/>
                    	<form:errors id="error" path="email" cssClass="error" />
                    </div>
                    
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-8 pure-u-lg-1-8">
                    	<input id="sendEmail" type="button" class="pure-button pure-input-1" value="发送邮件" onClick="sendmail(this);"/>
                    </div>

                    <div class="l-box-sm pure-u-1 pure-u-md-1-8 pure-u-lg-1-8">
                    	<a id="errorMsg"></a>
                    </div>
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    </div>
                    <!-- 行1 end -->
                    
                    <!-- 行2 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-4 pure-u-lg-1-4">
                        <form:label path="code">验证码</form:label>
                        <form:password path="code" class="pure-input-1" placeHolder="验证码"/>
                    	<form:errors path="code" cssClass="error" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-5-12 pure-u-lg-5-12">
                    </div>
                    <!-- 行2 end -->
                    
                    <!-- 行4 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-4 pure-u-lg-1-4">
                    	<br/>
                        <input class="pure-button pure-input-1" type="submit" value="验证" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-5-12 pure-u-lg-5-12">
                    </div>
                    <!-- 行4 end -->
                    <br/>

				</div>
			</fieldset>
		</form:form>
		
	</div>
	
	<div class="footer l-box is-center"> Malimaligong.com ® </div>

	<script type="text/javascript">
		
		//设置Cookie
		function setCookie(cname) {
			var d = new Date();
			d.setTime(d.getTime() + 60);
			var value = d.getTime();
			var expires = "expires=" + d.toUTCString();
			document.cookie = cname + "=" + value + "; " + expires;
		}
		
		//取得Cookie
		function getCookie(cname) {
		    var name = cname + "=";
		    var ca = document.cookie.split(';');
		    for(var i = 0; i <ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0)==' ') {
		            c = c.substring(1);
		        }
		        if (c.indexOf(name) == 0) {
		            return c.substring(name.length,c.length);
		        }
		    }
		    return "";
		}
		
		var countdown = 60;
		function settime(obj) {
			if (countdown == 0) {
				obj.removeAttribute("disabled");
				obj.value="发送邮件";
				countdown = 60;
				return;
				
			} else {
				obj.setAttribute("disabled", true);
				obj.value = "重新发送（" + countdown + "）";
				countdown--;
			}
			
			setTimeout(function(){
				settime(obj)
			}, 1000)
		}
		
		function sendmail(obj) {
			var email = document.getElementById("email").value;
			var error = document.getElementById("errorMsg");
			var coo = getCookie("countdown");
			var t = new Date();
			
			if (email == "") {
				alert("请输入正确的电子邮件");
				//error.value = "请输入正确的电子邮件";
				//error.style.color = "red";
				return false;
			} else {
				if (coo != "" && coo != undefined && coo != 'NaN') {
					countdown = coo - t.getTime();
				} else {
					countdown = 60;
					setCookie("countdown");
				}
				settime(obj);
				//alert("邮件发送成功");
				//error.value = "邮件发送成功";
				//error.style.color = "green";
			}
			
		}
	</script>
</body>
</html>