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

    <title>账号管理 隐私设置</title>


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

        .labelStyle{
            margin-left:25px;
            margin-right:10px;
            padding-top:10px;
            color:#8c8c8c;
            text-align: center;
            
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
                    <li><a id="email_name" href="#"></a></li>
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
                    <!-- <li><a href="#">收件箱</a></li> -->
                    <li ><a href="#">您的申请</a></li>
                    <c:if test="${userType == 3}">
                    	<li><a href="http://edu.comeon.today/agent/toCaseList" >工作列表</a></li>
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
                    <li id="payeeCard"><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc3EarnSetting.html">收款偏好</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc4TranSetting.html">交易记录</a></li>
                    <li class="menuItemSelectedMcx">
                        <i class="fa fa-caret-right" aria-hidden="true"></i>
                        <a href="http://edu.comeon.today/account/toPrivacySetting" style="color:#333333;">隐私设置</a>
                    </li>
                    <li><a href="http://edu.comeon.today/account/toSecuritySetting">安全设置</a></li>
                   
                </ul>
            </div>
            <div class="pure-u-15-24"> 
                <div class="pure-g"> 
                    <div class="pure-u-1-1 labelTitleStyleMcx">
                        <label >设置查看权限</label> 
                    </div> 
                    <div class="pure-u-1-1 insidePageContentMcx">                  
                        <form class="pure-form pure-form-stacked">
                            <fieldset>
                                <div class="pure-g">
                                    <div class="pure-u-8-24">
                                        <label class="labelStyle">设置信息查看权限 </label>
                                        <label class="labelStyle">选择可见的用户</label>
                                    </div>
                                    <div class="pure-u-15-24">
                                    <label for="allowLimit" class="pure-checkbox">
                                        <input id="allowLimit" type="checkbox"> 只允许与我有申请关系的用户查看我的资料
                                   
                                    <label for="allowAnyone" class="pure-checkbox">
                                        <input id="allowAnyone" type="checkbox"> 允许任何人查看我的资料
                                    </label>
                                
                                </div>

                            </div>
                            </fieldset>
                        </form>
                    </div> 
                </div>            
            </div> 
            <div class="pure-u-4-24"></div>          
        </div>

        <br>
        <div class="pure-g">
            <div class="pure-u-18-24"></div>
            <button id="save" type="submit" class="pure-button pure-button-primary pure-u-2-24">保 存</button>
        </div>
    </div>
   <!--footer display here-->
    <div>
        <footerpage></footerpage>
         
         <script src="<c:url value="/resources/js/riot.js" />"></script>

        <script src="footerpage.tag" type="riot/tag"></script>

        <script>riot.mount('footerpage')</script>
    </div>
   	<script type="text/javascript" src="<c:url value="http://edu.comeon.today/public/resources/jquery.js" />"></script>
    <script>
	var str='<div id="suc"class="successMcx">操作成功哦！<i class="fa fa-check" aria-hidden="true"></i></div>';
	
	$(document).ready(function(){
		
		$.post("http://edu.comeon.today/account/api/getProfile", function(data){
			if (data == null) {
				
			} else {
				
				$("#email_name").text(data.email);
				
				if (data.privacy_setting == 0) {
					$("#allowAnyone").prop('checked', true);
					$("#allowLimit").prop('checked', false);
				} else if (data.privacy_setting == 1) {
					$("#allowAnyone").prop('checked', false);
					$("#allowLimit").prop('checked', true);
				} else {
					$("#allowAnyone").prop('checked', false);
					$("#allowLimit").prop('checked', false);
				}
			}
		});
		
		$("#allowAnyone").change(function(){
			if ($("#allowAnyone").prop('checked')) {
				$("#allowLimit").prop('checked', false);
			} else {
				$("#allowLimit").prop('checked', true);
			}
		});
		
		$("#allowLimit").change(function(){
			if ($("#allowLimit").prop('checked')) {
				$("#allowAnyone").prop('checked', false);
			} else {
				$("#allowAnyone").prop('checked', true);
			}
		});
		
		$("#save").click(function(){
			var pid = 0;
			
			if ($("#allowAnyone").prop('checked')) {
				pid = 0;	
			}
			
			if ($("#allowLimit").prop('checked')) {
				pid = 1;	
			}
			
			$("#save").prop("disabled", true);
			
			$.get("http://edu.comeon.today/account/api/setPrivacy?pid=" + pid, function(data){
				console.log(pid);
				console.log("hhhhhhh: " + data.status);
				
				$("#save").prop("disabled", false);
				
				if (data.status == 1) {
					var str='<div id="suc" class="successMcx">操作成功哦！<i class="fa fa-check" aria-hidden="true"></i></div>';
					$("#blank").empty();
					$("#blank").append(str);				
					$("#suc").fadeOut(2000);
				} else {
					var str='<div id="fail" class="errorMcx">操作失败哦！<i class="fa fa-times" aria-hidden="true"></i></div>';
					$("#black").empty();
					$("#blank").append(str);			
					$("#fail").fadeOut(2000);
					return false;
				}
			});
		});					
	});
	</script>
</body>


</html>