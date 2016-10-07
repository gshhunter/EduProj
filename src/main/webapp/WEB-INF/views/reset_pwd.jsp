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
    
    
    <title>重置密码</title>
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
            background: #92BBAE;
            color: white;
            border:1px solid #92BBAE;
/*
            border-radius: 5px;
            box-shadow: 6px 6px 12px #BDBDBD;
*/
        }
        input{color:#484848; font-size: 22px;}
        .btn{
            background: #F7E289;
            color: #484848;
            text-align: center;
            border:1px solid #F7E289;
            border-radius: 3px;
            box-shadow: 1px 1px 5px rgba(66, 66, 66,0.6);
            font-size: 18px;
        }
        .btn:hover{
            background: #F6D380;
            border-color: #F6D380;
            color: #484848;
        }
        .btnsm{
            background: #5ED3B6;
            color: #484848;
            text-align: center;
            border:1px solid #5ED3B6;
            border-radius: 2px;
            box-shadow: 1px 1px 3px rgba(66, 66, 66,0.3);
            font-size: 14px;
            padding:5px 15px;
        }
        .btnsm:hover{
            background: #54f8a3;
            border-color: #54f8a3;
            color: #484848;
        }
        
    </style>
</head>

<body>
<div class="wrap">
    <headerdiv></headerdiv>
    <br><br><br>
    <form:form method="POST" commandName="resetPasswordBean" action="resetPassword.do" >
    <div class="columns bg">
        
        <div class="column is-3"></div>
        <div class="column is-6">
            <br>
            <p class="title1 middle"><i class="fa fa-wrench" aria-hidden="true" style="padding:9px 0px 0px 0px;"></i>&nbsp;重置密码</p>
            <br><br>
            <div class="columns">
                <div class="column is-9 is-offset-3 left font1">
                    <form:label path="new_pass">*新密码</form:label><br>
                    <form:password path="new_pass" placeHolder="新密码"/><br>
                    <form:errors path="new_pass" cssClass="error" /><br>
                    <br>
                    <form:label path="confirm_pass">*确认密码</form:label><br>
                    <form:password path="confirm_pass" placeHolder="再次输入"/><br>
                    <form:errors path="confirm_pass" cssClass="error" /><br>
                </div>
            </div>
            <br>
            <div class="columns">
                <input class="btn column is-4 is-offset-4" type="submit" value="重置密码" />
            </div>
            <br><br>
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