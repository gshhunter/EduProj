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
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/grids-responsive.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/main.css" />">

    <title>个人资料查看</title>


    <style>
      
        .insidePageContent {
            
            margin-top: 15px;
            border-style: solid;
            border-color: #f2f2f2;
            border-width: 1px;
            border-radius: 5px;
            margin-left: 20px;
            padding: 5px 35px 5px 35px;
        }
   
        .legendStyle {
            background: #EEEEEE;
            padding: 8px 0px 8px 8px;
            margin-top: 4px;
            margin-left: 4px;
            margin-right: 4px;
        }
        
        .userInfoBox{
            background: white;
            color:#777777;
            margin-left:-12px;
            text-align: center;
            padding:20px;
            margin-top:15px;
        }
        
       
        .textStyle {
            font-size:120%;
            color:#404040;
            padding:2px;
        }
        
        .iconYes{
            color:#00897B;
        }
        
        .iconNo {
        	color: #958F8F;
        }
        
    </style>
</head>

<body>
    <div class="wrap">
        <div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <h1>Malimalihong</h1>
                </div>
               
                <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
                <ul class="menuStyleMcx headerLinkStyleMcx">
                    <li id="hightlightbox" class="highlightBorderMcx"><a id="beagent" href="#"></a></li>
                    <!--<li><a href="#">收件箱</a></li>-->
                    <li><a id="email"></a></li>
                    <li><a href="<%=request.getContextPath() %>/account/logout">注销</a></li>                   
                </ul>
            </div>
                
            </div>
        </div>

        <br>
        
         <!--用户信息显示区-->
        <div class="pure-g">
            <div class="pure-u-2-24"></div>
            <div class="pure-u-3-24 userInfoBox">
                <i class="fa fa-user fa-5x iconStyle" aria-hidden="true"></i><br>
                <span id="fname" class="textStyle"></span><br><br>
                <i id="isPassport" class="fa fa-check-square" aria-hidden="true"></i><label>身份验证</label><br>
                <i id="isEmail" class="fa fa-check-square" aria-hidden="true"></i><label>邮箱验证</label><br>
                <i id="isCellphone" class="fa fa-check-square" aria-hidden="true"></i><label>手机验证</label><br>
                <br>
                <br>
                <br>
                <a href="<%=request.getContextPath() %>/account/toEditProfile" style="color:#0D47A1;">编辑我的信息</a>
            </div>
           <div class="pure-u-16-24 insidePageContent">
               <h1 id="name">你好，我是</h1>
               <h3 id="address"></h3>
               <pre>
                  
               </pre>
                
               <!-- <label style="padding-right:25px;"><i class="fa fa-comments fa-2x" aria-hidden="true" style="color:#00796B;"></i> 评价(1)</label>
               <label><i class="fa fa-certificate fa-2x" aria-hidden="true" style="color:#FFC400;"></i> 认证用户</label> -->
                 
           </div>
           
           
        </div>


        <div class="pure-g">
            <div class="pure-u-5-24"></div>
             <div class="pure-u-16-24 insidePageContent" style="margin-left:49px;">
                
               <br>
               <br>
               <br>
              
           </div>
        </div>
        <br>
        
    </div>
    <div class="footer">Malimaligong.com ®</div>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		
		$.post("http://localhost:8080/agency/account/api/getProfile", function(data){
			$("#hightlightbox").prop("disabled", true);
			$("#email").text(data.email);
			$("#email").attr("href", "<%=request.getContextPath() %>/account/toViewProfile");
			
			if (data.isCellphone == 1) {
				$("#isCellphone").addClass("iconYes");
			} else {
				$("#isCellphone").addClass("iconNo");
			}
			
			if (data.isEmail == 1) {
				$("#isEmail").addClass("iconYes");
			} else {
				$("#isEmail").addClass("iconNo");
			}
			
			if (data.isPassport == 1) {
				$("#isPassport").addClass("iconYes");
			} else {
				$("#isPassport").addClass("iconNo");
			}
			
			if (data.firstname != null) {
				$("#fname").text(data.firstname);
				$("#name").append(data.firstname);
			}
			
			if (data.country != null) {
				$("#address").append(data.country + " ");
			}
			
			if (data.state != null) {
				$("#address").append(data.state + " ");
			}
			
			if (data.city != null) {
				$("#address").append(data.city);
			}
			
			if (data.userType == 3) {
				$("#name").append(" (留学顾问)");
				$("#hightlightbox").prop("disabled", true);
			} else {
				$("#beagent").text("成为中介");
				$("#beagent").attr("href", "<%=request.getContextPath() %>/agent/toBeAgent");
				$("#hightlightbox").prop("disabled", false);
			}
		});
	});
	</script>
</body>
</html>