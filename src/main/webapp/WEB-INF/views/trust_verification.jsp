<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="<c:url value="/resources/css/tracy/pure.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/side-menu.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/grids-responsive.css" />">

	<title>学生个人资料信任与验证</title>
    
    
    <style>
        .labelStyle {
        	background:#EDEFED;
            padding:10px 0px 10px 10px;
            
            border-width:1px 1px 0px 1px;
            border-style:solid;
            border-color:#C4C4C4;
        }
        
        .blankStyle {
        	background:white;
        	padding:10px 0px 30px 10px;
        	
            margin-bottom:20px;
            
            border: 1px solid #C4C4C4;
        }
        
        .hideThis{
            display:none;
        }
        
        .blank{
			height:40px;
		}
		
		.iconGrey {
			color: #B0BEC5;
		}
		
		.iconGreen {
			color: green;
		}
        
    </style>
</head>

<body>
	<div class="wrap">
		<div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <a class="webTitleh1FontMcx" href="">Malimalihong</a>
                </div>
               
                <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
	                <ul class="menuStyleMcx headerLinkStyleMcx">
	                    <li class="highlightBorderMcx"><a href="#">成为中介</a></li>
	                    <li><a href="#">收件箱</a></li>
	                    <li><lable>Amy</label></li>
	                    <li><a href="#">退出</a></li>                   
	                </ul>
            	</div> 
            </div>
        </div>
        
        <!--水平菜单-->
        <div class="pure-g">
            <div class="pure-u-2-24 headerMenuBackgroundMcx" ></div>           
            <div class="pure-u-22-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx headerMenuBackgroundMcx">
                <ul class="menuStyleMcx">
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/studentDashboard.html">控制面板</a></li>
                    <!-- <li><a href="#">收件箱</a></li> -->
                    <li><a href="#">您的申请</a></li>
                    <li class="menuItemSelectedMcx"><a href="#"style="color:#D8D8D8;">个人资料</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/studentAcc1MsgSetting.html">账号管理</a></li>
                </ul>
            </div>  
        </div>
		<div id="blank" class="blank"></div>

        <!-- 内容 -->
        <div class="pure-g">
        	<!-- 左空白 -->
	        <div class="pure-u-2-24"></div>
	        <!--垂直菜单-->
	        <div class="pure-u-4-24 pure-menu pure-menu-open testMenuMcx menustyleVerMcx " >
		        <ul>
		            <li><a href="file:///Users/Chenxue/Documents/EduFont/studentProfileEdit.html">编辑</a></li>
		            <li class="menuItemSelectedMcx"><i class="fa fa-caret-right" aria-hidden="true"></i><a href="#">信任验证</a></li>
		            <li><a href="file:///Users/Chenxue/Documents/EduFont/studentProfileComment.html#">评价</a></li>
		            <br/>
		            <div class="pure-button pure-button-primary">查看我的资料</div>
		        </ul>
	        </div>
			
			<!-- 信任和验证内容区域 -->
			<div class="pure-u-14-24">
		        
		   		<div class="pure-g">
		   			<!--验证护照信息框-->
		   			<div id="verify_passport_label" class="pure-u-1-1 labelStyle" style="display:none;">
		   				<label id="passportTitle">护照验证</label>
		   			</div>
	            	<div id="verify_passport_box" class="pure-u-1-1 blankStyle" style="display:none;">
	            		
	            		<div class="pure-g">
		                    <div class="pure-u-15-24">
								<label id="passportContent">护照验证是最容易的一种方式帮助您建立信任在Malimalihong社区</label>
							</div>
							<div class="pure-u-4-24"></div>
							<div class="pure-u-5-24">
			                	<div id="verify_passport_btn" class="pure-button pure-button-primary">验证护照</div>
			                </div>
		                </div>
	                </div>
	              	
	              	<!-- 邮箱验证 -->
	              	<div id="verify_email_label" class="pure-u-1-1 labelStyle">
		   				<label id="emailTitle">邮箱验证</label>
		   			</div>
	            	<div id="verify_email_box" class="pure-u-1-1 blankStyle">
	            		<div class="pure-g">
		                    <div class="pure-u-15-24">
								<label id="emailContent"></label>
							</div>
							<div class="pure-u-4-24"></div>
							<div class="pure-u-5-24">
			                	<button id="verify_email_btn" class="pure-button pure-button-primary">验证邮箱</button>
			                </div>
		                </div>
	                </div>
	              	
	              	<!-- 手机验证 -->
	              	<!--<div id="verify_cellphone_label" class="pure-u-1-1 labelStyle">
		   				<label id="cellphoneTitle">手机验证</label>
		   			</div>
	            	<div id="verify_cellphone_box" class="pure-u-1-1 blankStyle">
	            		<div class="pure-g">
		                    <div class="pure-u-15-24">
								<label id="cellphoneContent"></label>
							</div>
							<div class="pure-u-4-24"></div>
							<div class="pure-u-5-24">
			                	<div id="verify_cellphone_btn" class="pure-button pure-button-primary">验证手机</div>
			                </div>
		                </div>
	                </div> -->
	              	
	              	<!-- 微博验证 -->
	              	<div id="verify_weibo_label" class="pure-u-1-1 labelStyle">
		   				<label id="weiboTitle">微博验证</label>
		   			</div>
	            	<div id="verify_weibo_box" class="pure-u-1-1 blankStyle">
	            		<div class="pure-g">
		                    <div class="pure-u-15-24">
								<label id="weiboContent"></label>
							</div>
							<div class="pure-u-4-24"></div>
							<div class="pure-u-5-24">
			                	<div id="verify_weibo_btn" class="pure-button pure-button-primary">验证微博</div>
			                </div>
		                </div>
	                </div>
	              	
				</div>
		    </div>
	        <!-- 右空白 -->
        	<div class="pure-u-4-24"></div>
    	</div>
	</div>
       
    <div class="footer">Malimaligong.com ®</div>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
   	<script>
   	
   	$(document).ready(function(){
   		
   		var times = '<i class="fa fa-times" style="color:#B0BEC5" aria-hidden="true"></i>';
   		
   		var check = '<i class="fa fa-check" style="color:green" aria-hidden="true"></i>';
   		
   		$.post("http://localhost:8080/agency/account/api/getProfile", function(data){
   			if (data == null) {
   				
   			} else {
   
   				
   				//Passport 验证
   				if (data.isPassport == 0) {
   					$("#verify_passport_label").css("display", "block");
   					$("#verify_passport_box").css("display", "block");
   				} else {
   					
   				}
   				
   				//Email 验证
   				if (data.isEmail == 0) {
   					if (data.email == null || data.email == "") {
   						$("#emailContent").text("添加验证邮箱可以最大限度确保账号安全");
   					} else {
   						$("#emailContent").text("未验证邮箱： " + data.email);
   						$("#emailContent").append(" " + times);
   						
   					}
   				} else {
   					if (data.email == null || data.email == "") {
   						$("#emailContent").text("添加验证邮箱可以最大限度确保账号安全");
   					} else {
   						$("#emailContent").text("验证邮箱： " + data.email);
   						$("#emailContent").append(" " + check);
   						$("#verify_email_btn").text("邮箱已验证");
   						$("#verify_email_btn").attr("disabled", "disabled");
   						
   					}
   				}
   				
   				//Cellphone 验证
   				if (data.isCellphone == 0) {
   					if (data.cellphone == null || data.cellphone == "") {
   						$("#cellphoneContent").text("手机验证增加账号的安全等级");
   					} else {
   						$("#cellphoneContent").text("未验证手机： " + data.cellphone);
   						$("#cellphoneContent").append(" " + times);
   					}
   				} else {
   					if (data.cellphone == null || data.cellphone == "") {
   						$("#cellphoneContent").text("手机验证增加账号的安全等级");
   					} else {
   						$("#cellphoneContent").text("验证手机： " + data.cellphone);
   						$("#cellphoneContent").append(" " + check);
   						$("#verify_cellphone_btn").text("手机已验证");
   						$("#verify_cellphone_btn").attr("disabled", "disabled");
   					}
   				}
   				
   				//Weibo 验证
   				if (data.isWeibo == 0) {
   					$("#weiboContent").text("微博验证可以增加您的账号安全等级");
   				} else {
   					if (data.weibo == null || data.weibo == "") {
   						$("#weiboContent").text("微博验证可以增加您的账号安全等级");
   					} else {
   						$("#weiboContent").text("验证微博： " + data.weibo);
   						$("#weiboContent").append(" " + check);
   						$("#verify_weibo_btn").text("微博已验证");
   						$("#verify_weibo_btn").attr("disabled", "disabled");
   					}
   				}
   			}
   		});
   		
   		$("#verify_email_btn").click(function(){
   			$.get('http://localhost:8080/agency/account/api/sendVerificationMail', function(sback){
   					var sendEmail = $("#verify_email_btn");
   					settime(sendEmail);
   			});
   		});
   		
   		$("#verify_passport_btn").click(function(){
   			alert("请联系后台工作人员帮您完成验证");
   		});
   		
   	});
   	
	var countdown = 60;
	
	function settime(obj) {
		if (countdown == 0) {
			obj.prop("disabled", false);
			obj.text("验证邮箱");
			
			countdown = 60;
			return;
			
		} else {
			obj.prop("disabled", true);
			obj.text("重新发送（" + countdown + "）");
			countdown--;
			console.log(countdown);
		}
		
		setTimeout(function(){
			settime(obj)
		}, 1000)
	}
   	</script>
</body>


</html>