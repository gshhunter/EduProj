<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!doctype html>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://edu.comeon.today/public/resources/riot.js"></script>
    <script src="http://edu.comeon.today/public/resources/jquery.js"></script>
    <script src="http://edu.comeon.today/public/js/main.js"></script>
   
    <link rel="stylesheet" href="http://edu.comeon.today/public/resources/bulma.css">
    <link rel="stylesheet" href="http://edu.comeon.today/public/css/main.css">

    <link rel="stylesheet" href="http://edu.comeon.today/public/resources/fontawesome/css/font-awesome.min.css">

    <script src="http://edu.comeon.today/public/resources/jquery.cookie.js"></script>
    <script src="http://edu.comeon.today/public/resources/layer/layer.js"></script>
    <script src="http://edu.comeon.today/public/resources/md5.js"></script>
    
    
    <title>找回密码</title>
    <style>
        .middle{text-align: center;}
        .right{text-align: right;}
        .left{text-align: left;}
        .title1{
            font-size: 2.5em;
/*            color:#484848;*/
            font-weight: bold;
        }
        .font1{font-size: 18px; font-weight: bold;}
        .height{line-height: 20px;}
        .bg{
            background: #ADAFDE;
            color: white;
        }
        input{color:#484848;font-size:22px;}
        .btn{
            background: #757575;
            color: white;
            text-align: center;
            border:1px solid #757575;
            border-radius: 3px;
            box-shadow: 1px 1px 5px rgba(66, 66, 66,0.6);
            font-size: 18px;
        }
        .btn:hover{
            background: #9E9E9E;
            border-color: #9E9E9E;
            color:white;
        }
        .btnsm{
            background: #F7E289;
            color: #484848;
            text-align: center;
            border:1px solid #F7E289;
            border-radius: 2px;
            box-shadow: 1px 1px 3px rgba(66, 66, 66,0.3);
            font-size: 14px;
            padding:5px 15px;
        }
        .btnsm:hover{
            background: #faeeb7;
            border-color: #faeeb7;
            color: #484848;
        }
        .error {
			color: red;
		}
		/*#sendEmail, #errorMsg {
			position:relative;
			top: 47px;
		}*/
    </style>
</head>

<body>
<div class="wrap">
    <headerdiv></headerdiv>
    <br><br><br>
    <div class="columns bg">
        
        <div class="column is-3"></div>
        <div class="column is-6">
            <br>
            <p class="title1 middle"><i class="fa fa-key" aria-hidden="true" style="padding:9px 0px 0px 0px;"></i>&nbsp&nbsp找回密码</p>
            <br><br>
            <div class="columns">
                <div class="column is-9 is-offset-3 left font1">
                    <label for="email">电子邮箱</label><br>
                    <input id="email" type="email" placeHolder="电子邮箱" size="25">
                    <input id="sendEmail" type="button" class="btnsm" value="发送验证邮件"><br>
                    <span id="error"></span>
                </div>
            </div>
            <br>
            <div class="columns">
                <input id="forwardEmail" class="btn column is-4 is-offset-4" type="button" value="前往邮箱验证" />
            </div>
            <br><br>
        </div>
        <div class="column is-3"></div>
    </div>
</div>
<footerpage></footerpage>
<script src="tag/header.tag" type="riot/tag"></script>
<script src="tag/footerpage.tag" type="riot/tag"></script>
<script type="text/javascript" src="<c:url value="http://edu.comeon.today/public/resources/jquery.js" />"></script>
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
			
			$.get('http://edu.comeon.today/api/v1/sendResetMail?email=' + email, function(sback){
	
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
<script>
    riot.mount('*');
</script>
</body>
</html>