<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="http://edu.comeon.today/public/resources/pure.css">
    <link rel="stylesheet" href="http://edu.comeon.today/public/css/side-menu.css" >
    <link rel="stylesheet" href="http://edu.comeon.today/public/resources/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://edu.comeon.today/public/css/main.css">
    <link rel="stylesheet" href="http://edu.comeon.today/public/resources/grids-responsive.css" >

    <title>中介账号管理 安全设置</title>

    <style>
        
        .insidePageContent {
            background: white;
            margin-top: 15px;
            border-style: solid;
            border-color: #f2f2f2;
            border-width: 1px;
            border-radius: 5px;
            padding-top:5px;
            padding-bottom:5px;
        }

		.errors {
			color: red;
		}
    </style>
</head>

<body>
    <div class="wrap">
        <div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <a class="webTitleh1FontMcx" href="http://edu.comeon.today">Malimalihong</a>
                </div>
               
                 <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
                <ul class="menuStyleMcx headerLinkStyleMcx">
                	<c:if test="${userType != 3}">
	                	<li class="highlightBorderMcx"><a href="http://edu.comeon.today/agent/toBeAgent">成为中介</a></li>
	                </c:if>            
                    <li><a href="http://edu.comeon.today/account/toViewProfile">${loginEmail}</a></li>
                    <li><a href="http://edu.comeon.today/account/logout">退出</a></li>                                     
                </ul>
                </div>
                
            </div>
        </div>

        <!--水平菜单-->
        <div class="pure-g headerMenuBackgroundMcx">
            <div class="pure-u-2-24 "></div>
            <div class="pure-u-22-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx headerMenuBackgroundMcx">
                <ul class="menuStyleMcx">

                    <li ><a href="file:///Users/Chenxue/Documents/EduFont/agent1CaseList.html">您的申请</a></li>
                    <c:if test="${userType == 3}">
                    	<li><a href="http://edu.comeon.today/agent/toCaseList-done" >工作列表</a></li>
                    </c:if>
                    <li ><a href="http://edu.comeon.today/account/toEditProfile" >个人资料</a></li>
                    <li class="menuItemSelectedMcx"><a href="http://edu.comeon.today/account/toPrivacySetting" style="color:#f2f2f2;">账号管理</a></li>
                </ul>
            </div>
        </div>
 <!--错误信息提示占位-->
        <div id="blank" class="infoBlankMcx"></div>
        
        <div class="pure-g">
            <div class="pure-u-2-24"></div>
            <!--垂直菜单-->
            <div class="pure-u-3-24 pure-menu pure-menu-open testMenuMcx menustyleVerMcx ">
                <ul>
                    <!-- <li><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc1MsgSetting.html">通知设置</a></li> -->
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc2PaySetting.html">付款方式</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc3EarnSetting.html">收款偏好</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc4TranSetting.html">交易记录</a></li>
                    <li><a href="http://edu.comeon.today/account/toPrivacySetting">隐私设置</a></li>
                    <li class="menuItemSelectedMcx">
                        <i class="fa fa-caret-right" aria-hidden="true"></i>
                        <a href="http://edu.comeon.today/account/toSecuritySetting" style="color:#333333;">安全设置</a>
                    </li>
                </ul>
            </div>
            <div class="pure-u-15-24"> 
                <div class="pure-g">  
                    <div class="pure-u-1-1 labelTitleStyleMcx">
                        <label>修改密码</label> 
                    </div> 
                    <div class="pure-u-1-1 insidePageContentMcx">               
                        <form class="pure-form pure-form-aligned">
                            <fieldset>
                                <br>
                                
                                <div class="pure-control-group">
                                    <label for="oldpwd">旧密码:</label>
                                    <input id="oldpwd" type="password" placeholder="输入旧密码" />
                                    <span id="info1" style="color: red;"></span>
                                </div>

                                <div class="pure-control-group">
                                    <label for="newpwd">新密码:</label>
                                    <input id="newpwd" type="password" placeholder="输入新密码" />
                                    <span id="info2" style="color: red;"></span>
                                </div>

                                <div class="pure-control-group">                       
                                    <label for="againpwd">确认新密码:</label>
                                    <input id="againpwd" type="password" placeholder="再次输入新密码" />
                                    <span id="info3" style="color: red;"></span>
                                </div>
                                
                                <button id="change_pwd_btn" type="submit" class="pure-button pure-button-primary" style="float:right; margin-right:50px;">更新密码</button>
                                
                            </fieldset>
                        </form>
                    </div>  
                </div>          
            </div> 
            <div class="pure-u-4-24"></div>        
        </div>
    </div>
   <!--footer display here-->
    <!-- <div>
        <footerpage></footerpage>
         
         <script src="js/riot.js"></script>

        <script src="footerpage.tag" type="riot/tag"></script>

        <script>riot.mount('footerpage')</script>
    </div> -->
    <script type="text/javascript" src="<c:url value="http://edu.comeon.today/public/resources/jquery.js" />"></script>
    <script>
    $(document).ready(function(){
    	
    	var ss = new Object();
    	
    	$("#oldpwd").change(function(){
    		var pass = $(this).val();
            if (checkPassword(pass)) {
            	$(this).css('border-color','lime');
            	$("#info1").text("");
            } else {
            	$(this).css('border-color','red');
            	$("#info1").text("密码必须是6-24位字母和数字，不能有特殊字符");
            }
    	});
    	
    	$("#newpwd").change(function(){
    		var pass = $(this).val();
            if (checkPassword(pass)) {
            	$(this).css('border-color','lime');
            	$("#info2").text("");
            } else {
            	$(this).css('border-color','red');
            	$("#info2").text("密码必须是6-24位字母和数字，不能有特殊字符");
            }
    	});
    	
    	$("#againpwd").change(function(){
    		var pass = $(this).val();
    		var newpass = $("#newpwd").val();
    		
    		if (checkPassword(pass)) {
    			if (pass == newpass) {
                	$(this).css('border-color','lime');
                	$("#info3").text("");
                } else {
                	$(this).css('border-color','red');
                	$("#info3").text("两次输入的密码不一样，请重新输入");
                }
            } else {
            	$(this).css('border-color','red');
            	$("#info3").text("密码必须是6-24位字母和数字，不能有特殊字符");
            }

    	});
    	
    	$("form").submit(function(e){
    		var oldpwd = $("#oldpwd").val();
        	var newpwd = $("#newpwd").val();
        	var againpwd = $("#againpwd").val();
        	
        	console.log("123 " + oldpwd);
        	
        	if (!checkPassword(oldpwd)) {
        		$(this).css('border-color','red');
            	$("#info1").text("密码必须是6-24位字母和数字，不能有特殊字符");
        		return false;
        	} else {
        		$(this).css('border-color','lime');
            	$("#info1").text("");
        	}
        	
        	if (!checkPassword(newpwd)){
        		$(this).css('border-color','red');
            	$("#info2").text("密码必须是6-24位字母和数字，不能有特殊字符");
            	return false;
        	} else {
        		$(this).css('border-color','lime');
            	$("#info2").text("");
        	}
        	
        	if (!checkPassword(againpwd)) {
        		$(this).css('border-color','red');
            	$("#info3").text("密码必须是6-24位字母和数字，不能有特殊字符");
            	return false;
        	} else {
        		$(this).css('border-color','lime');
            	$("#info3").text("");
        	}
        	
        	if (newpwd != againpwd) {
        		$(this).css('border-color','red');
            	$("#info3").text("两次输入的密码不一样，请重新输入");
            	return false;
        	} else {
        		$(this).css('border-color','lime');
            	$("#info3").text("");
        	}
        	
        	ss.oldpwd = oldpwd;
        	ss.newpwd = newpwd;
        	ss.againpwd = againpwd;
        	var r = JSON.stringify(ss);
        	
			$.post('http://edu.comeon.today/account/api/changePassword', r, function(data){
				console.log(r);
				console.log(data.status);
				
        		if (data.status == -4) {
        			$(this).css('border-color','red');
                	$("#info1").text("旧密码输入不正确，请重新输入");
            		return false;
        		} else if (data.status == 1) {
        			var str='<div id="suc" class="successMcx">操作成功哦！<i class="fa fa-check" aria-hidden="true"></i></div>';
					$("#blank").empty();
					$("#blank").append(str);				
					$("#suc").fadeOut(2000);
					return false;
        		} else {
        			var str='<div id="fail" class="errorMcx">操作失败哦！<i class="fa fa-times" aria-hidden="true"></i></div>';
					$("#blank").empty();
					$("#blank").append(str);			
					$("#fail").fadeOut(2000);
					return false;
        		}
        	});
			
			return false;
    	});

    });
    
    function checkPassword(password){
        var pattern = /^[a-zA-Z0-9_-]{6,24}$/;
        if(pattern.test(password)){
            return true;
        }else{
            return false;
        }
    }
    
	</script>
</body>


</html>