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
			
		<form class="pure-form pure-form-stacked">
			<fieldset>
				<legend>请填写邮箱并发送验证</legend>
				<div class="pure-g">
					<!-- 行1 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-4 pure-u-lg-1-4">
                        <label for="email">电子邮箱</label>
                        <input id="email" class="pure-input-1" type="email" placeHolder="电子邮箱"/>
                    	<span id="error"></span>
                    </div>
                    
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-1-8 pure-u-lg-1-8">
                    	<input id="sendEmail" type="button" class="pure-button pure-input-1" value="发送邮件"/>
                    </div>

                    <div class="l-box-sm pure-u-1 pure-u-md-1-8 pure-u-lg-1-8">
                    	<a id="errorMsg"></a>
                    </div>
                    <div class="l-box-sm pure-u-1 pure-u-md-1-6 pure-u-lg-1-6">
                    </div>
                    <!-- 行1 end -->
                    
                    <!-- 行2 -->
                   
                    <!-- 行2 end -->
                    
                    <!-- 行4 -->
                    <div class="l-box-sm pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-3-8 pure-u-lg-3-8">
                    	<br/>
                        <input id="forwardEmail" class="pure-button pure-input-1" type="button" value="前往邮箱验证" />
                    </div>
                    
                    <div class="l-box-sm pure-u-1 pure-u-md-7-24 pure-u-lg-7-24">
                    </div>
                    <!-- 行4 end -->
                    <br/>

				</div>
			</fieldset>
		</form>
		
	</div>
	
	<div class="footer l-box is-center"> Malimaligong.com ® </div>

	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		
		$("#forwardEmail").prop("disabled", true);
		$("#error").text("");
		
		$("#sendEmail").click(function(){
			
			var email = $("#email").val();
			console.log("---------" + email);
			if (email == "" || email == "undefined" || email == null) {
				$("#error").css("color", "red");
				$("#error").text("请输入正确的电子邮箱");
				return "";
			}
			if (!isEmail(email)) {
				$("#error").css("color", "red");
				$("#error").text("电子邮箱格式错误，请重新输入");
				return "";
			}
			$("#error").text("");
			
			$.get('http://localhost:8080/agency/account/api/sendResetMail?email=' + email, function(sback){
	
				if (sback.status == -1) {
					$("#error").css("color", "red");
					$("#error").text("该电子邮箱还未被注册,请重新输入");
					return "";
				}
				
				if (sback.status == 0) {
					$("#error").css("color", "red");
					$("#error").text("请输入正确的电子邮箱");
					return "";
				}
				
				if (sback.status == 1) {
					var sendEmail = $("#sendEmail");
					settime(sendEmail);
					$("#error").css("color", "green");
					$("#error").text("成功发送，请登录邮箱查看");
					$("#forwardEmail").prop("disabled", false);
					var cc = email.split("@");
					var url = cc[1];
					console.log("========== " + cc[0]);
					console.log("++++++++++ " + cc[1]);
					$("#forwardEmail").click(function(){
						window.open("http://mail." + url);
					});
					return "";
				}
			});
			
			
		});
		
		
	});
	
	function isEmail(email) {
		var reg = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		if (reg.test(email)) {
			return true;
		} else {
			return false;
		}
	}
	
	function setCountdown() {
		var cookieValue = document.cookie.replace(/(?:(?:^|.*;\s*)countdown\s*\=\s*([^;]*).*$)|^.*$/, "$1");
		if (cookieValue == "" || cookieValue == "undefined") {
		    var d = new Date();
		    var expire = d.getTime() + 60;
		    console.log(expire);
		    document.cookie = "countdown=" + expire + "; expires=" + expire.toGMTString();
		    countdown = 60;
		} else {
		    var b = new Date();
		    countdown = cookieValue - b.getTime();
		}
	}
	
	var countdown = 60
	
	function settime(obj) {
		if (countdown == 0) {
			obj.prop("disabled", false);
			obj.val("发送邮件");
			countdown = 60;
			return;
			
		} else {
			obj.prop("disabled", true);
			obj.val("重新发送（" + countdown + "）");
			countdown--;
		}
		
		setTimeout(function(){
			settime(obj)
		}, 1000)
	}
	
	function sendmail(obj) {
			settime(obj);	
	}
	</script>
</body>
</html>