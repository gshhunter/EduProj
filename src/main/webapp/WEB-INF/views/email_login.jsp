<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
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
    
    
    <title>邮箱登录页面</title>
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
            background: #6DBFE4;
            color: white;
            border:1px solid #6DBFE4;
            border-radius: 5px;
            box-shadow: 6px 6px 12px #BDBDBD;
        }
        input{color:#484848;font-size:18px;}
        .btn{
            background: #CCFDE4;
            color: #484848;
            text-align: center;
            border:1px solid #CCFDE4;
            border-radius: 5px;
            box-shadow: 1px 1px 5px rgba(66, 66, 66,0.6);
            font-size: 19px;
        }
        .btn:hover{
            background: #FBC02D;
            border-color: #FBC02D;
            color: white;
        }
        .error {
			color: red;
		}
		a{color:white;}
    </style>
</head>

<body>
<div class="wrap">
    <headerdiv></headerdiv>
    <br><br><br><br>
    <form:form method="POST" commandName="emailLoginBean" action="loginEmail.do" >
    <div class="columns">
        
        <div class="column is-3"></div>
        <div class="column is-6 bg">
            <br>
            <p class="title1 middle"><i class="fa fa-laptop" aria-hidden="true" style="padding:9px 3px 0px 0px;"></i>&nbsp;邮箱登录</p>
            <br><br>
            <div class="columns">
                <div class="column is-4 right font1">
                    <form:label path="email">*电子邮箱</form:label><br><br>
                    <form:label path="password">*密码</form:label><br><br>
                </div>
                <div class="column is-8 height">
                    <form:input path="email" type="email" placeHolder="电子邮箱"/>
                    <form:label path="email" class="hint">
                    	<form:errors path="email" cssClass="error" />
                    </form:label>
                    <br><br>
                    <form:password path="password" placeHolder="密码"/>
                    <form:label path="password">
                    	<form:errors path="password" cssClass="error" />
                    </form:label>
                </div>
           
            </div>
            
            <div class="columns">
                <div class="column is-4">

                </div>
                <div class="column is-2">
                    <form:label path="remember_me" class="pure-checkbox">
                    	<form:checkbox path="remember_me" /> &nbsp;记住登录密码
                    </form:label> 
                </div>
                <div class="column is-6">
                	<label for="forget">
                    	<a id="forget" href="<%=request.getContextPath() %>/account/forgetPwd.do">忘记密码？</a> | <a href="<%=request.getContextPath() %>/account/toEmailRegister.do">去注册</a>
                    </label>
                </div>
            </div>
            <br>
            <div class="columns">
                <input class="btn column is-4 is-offset-4" type="submit" value="登录账号" />
            </div>
            <br><br>
        </div>
        <div class="column is-3"></div>
    </div>
    </form:form>
</div>
<footerpage></footerpage>
<script src="http://edu.comeon.today/public/tag/header.tag" type="riot/tag"></script>
<script src="http://edu.comeon.today/public/tag/footerpage.tag" type="riot/tag"></script>

<script>
    riot.mount('*');
</script>
</body>
</html>