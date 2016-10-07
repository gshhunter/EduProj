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
    
    
    <title>邮箱注册页面</title>
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
            background: #5ED3B6;
            color: white;
            border:1px solid #5ED3B6;
            border-radius: 5px;
            box-shadow: 6px 6px 12px #BDBDBD;
        }
        input{color:#484848;font-size:22px;}
        .btn{
            background: #F6D380;
            color: #484848;
            text-align: center;
            border:1px solid #F6D380;
            border-radius: 5px;
            box-shadow: 1px 1px 5px rgba(66, 66, 66,0.6);
            font-size: 19px;
        }
        .btn:hover{
            background: #CCFDE4;
            border-color: #CCFDE4;
        }
        .error {
			color: red;
		}
    </style>
</head>

<body>
<div class="wrap">
    <headerdiv></headerdiv>
    <br><br><br>
    <form:form method="POST" commandName="account" action="registerEmail.do" >
    <div class="columns">
        
        <div class="column is-3"></div>
        <div class="column is-6 bg">
            <br>
            <p class="title1 middle"><i class="fa fa-envelope" aria-hidden="true" style="padding:5px 5px 0px 0px;"></i>&nbsp;邮箱注册</p>
            <br>
            <div class="columns">
                <div class="column is-2"></div>
                <div class="column is-4 left font1">
                    <form:label path="lastname">*姓氏</form:label><br>
                    <form:input id="lastname" path="lastname" placeHolder="姓氏"/><br>
                    <form:errors path="lastname" cssClass="error" />
                </div>
                <div class="column is-6 left font1">
                    <form:label path="firstname">*名称</form:label><br>
                    <form:input path="firstname" placeHolder="名称"/><br>
                    <form:errors path="firstname" cssClass="error" />
                </div>
            </div>
            <div class="columns">
                <div class="column is-2"></div>
                <div class="column is-10 height font1">
                    <form:label path="email">*电子邮箱</form:label><br>
                    <form:input path="email" type="email" placeHolder="电子邮箱" size="47"/><br>
                    <form:errors path="email" cssClass="error" /><br>

                    <form:label path="password">*密码</form:label><br>
                    <form:password path="password" placeHolder="密码" size="47"/><br>
                    <form:errors path="password" cssClass="error" /><br>
                </div>
            </div>
            
            <br>
            <div class="columns">
                <input class="btn column is-4 is-offset-4" type="submit" value="创建账户" /><br>
            </div>
            <br>
        </div>
        <div class="column is-3"></div>
    </div>
    </form:form>
</div>
<footerpage></footerpage>
<script src="tag/header.tag" type="riot/tag"></script>
<script src="tag/footerpage.tag" type="riot/tag"></script>

<script>
    riot.mount('*');
</script>
</body>
</html>