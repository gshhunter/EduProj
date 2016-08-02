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
    <%-- <link rel="stylesheet" href="<c:url value="/resources/css/tracy/grids-responsive.css" />"> --%>
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/main.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/intlTelInput.css" />">
	<title>学生个人资料编辑</title>
    
    <style>
       
        .insidePageContent {
            background: white;
            margin-top: 15px;
            margin-left:20px;
            border-style: solid;
            border-color: #f2f2f2;
            border-width: 1px;
            border-radius: 5px;
        }
       
    </style>
</head>

<body>
	<div class="wrap">
		<div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <a class="webTitleh1FontMcx" style="font-size:250%;" href="">Malimalihong</a>
                </div>
               
                <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
                <ul class="menuStyleMcx headerLinkStyleMcx">
                    <li class="highlightBorderMcx"><a href="#">成为中介</a></li>
                    <!-- <li><a href="#">收件箱</a></li> -->
                    <li><a id="email"></a></li>
                    <li><a href="#">注销</a></li>                   
                </ul>
            </div>
                
            </div>
        </div>
        
        <!--水平菜单-->
        <div class="pure-g">
            <div class="pure-u-2-24 headerMenuBackgroundMcx" ></div>           
            <div class="pure-u-22-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx headerMenuBackgroundMcx">
                <ul class="menuStyleMcx">
                    <!-- <li><a href="file:///Users/Chenxue/Documents/EduFont/studentDashboard.html">控制面板</a></li> -->
                    <!-- <li><a href="#">收件箱</a></li> -->
                    <li><a href="#">您的申请</a></li>
                    <li class="menuItemSelectedMcx"><a href="#"style="color:#f2f2f2;">个人资料</a></li>
                    <li><a href="">账号管理</a></li>
                </ul>
            </div>  
        </div>
          
        <br>
        <div class="pure-g">
          <div class="pure-u-2-24"></div>
          <div class="pure-u-3-24 pure-menu pure-menu-open testMenuMcx menustyleVerMcx " >
                <ul>
                    <li class="menuItemSelectedMcx"><i class="fa fa-caret-right" aria-hidden="true"></i><a href="#">编辑</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/studentProfileValidation.html">信任验证</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/studentProfileComment.html#">评价</a></li>
                   	<br>  
                	<div class="pure-button">查看我的资料</div>
                </ul>
                 
            </div>
            
            <div class="pure-u-16-24 insidePageContent">
                <!--<form class="pure-form" style="padding:20px;">
                    <fieldset>
                        <legend style="background:#EEEEEE;">基本资料</legend>-->

              <form:form class="pure-form pure-form-aligned " style="padding:20px;" commandName="editProfile" method="POST">
                  
                <fieldset>
                <legend style="background:#EEEEEE;">基本资料 (必填*)</legend>
                    <div class="pure-control-group">
                        <form:label path="lastname">姓 :</form:label>
                        <form:input path="lastname" id="lastname" class="pure-u-1-5" type="text" />
                    </div>

                    <div class="pure-control-group">
                        <form:label path="firstname">名 :</form:label>
                        <form:input path="firstname" id="firstname" class="pure-u-1-5" type="text" />
                    </div>

                    <div class="pure-control-group">
                        <form:label path="gender">性别:</form:label>
                        <form:select path="gender" id="gender" class="pure-u-1-12">
                            <form:option value ="1">男</form:option>
                            <form:option value ="0">女</form:option>
                            <form:option value ="2">其他</form:option>
                        </form:select>
				    </div>
                    
                    
                    <div class="pure-control-group">
                        <form:label path="birthday">生日:</form:label>
                        <form:input path="birthday" class="pure-u-1-5" id="birthday" type="date" />
                    </div>
                    
                     <%-- <div class="pure-control-group">
                        <form:label path="email">邮箱:</form:label>
                        <form:input path="email" class="pure-u-2-5" id="email" type="email" />
                    </div> --%>

                    <div class="pure-control-group">
                        <form:label path="cellphone">手机:</form:label>
                        <form:input path="cellphone" class="pure-u-1" id="cellphone" type="tel" style="margin-right:-8px;"/>
                        <span id="valid-msg" class="hide">✓ Valid</span>
						<span id="error-msg" class="hide">Invalid number</span>
                    </div>

                    <div class="pure-controls">
                        
                        <button type="submit" class="pure-button pure-button-primary pure-u-1-5">保存</button>
                    </div>
                </fieldset>
            </form:form>
            </div>

        </div>
	</div>
    <div class="footer">Malimaligong.com ®</div>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/intlTelInput.min.js" />"></script>
	<script>
	  $("#cellphone").intlTelInput();
	</script>
</body>


</html>