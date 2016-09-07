<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>填写留学意愿完成</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    <link rel="stylesheet" href="http://edu.comeon.today/public/resources/fontawesome/css/font-awesome.min.css">
    <!--[if lte IE 8]>
        <link rel="stylesheet" href="css/layouts/marketing-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="http://edu.comeon.today/public/css/shuhao/marketing.css" >
        <link rel="stylesheet" href="http://edu.comeon.today/public/css/shuhao/request-complete.css" >
    <!--<![endif]-->
</head>
<body>

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading" href="http://edu.comeon.today">Logo（待确认）</a>

        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="http://edu.comeon.today/agent/toBeAgent" class="pure-menu-link">成为留学顾问</a></li>
            <li class="pure-menu-item"><a href="http://edu.comeon.today/account/" class="pure-menu-link">注册</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">登录</a></li>
        </ul>
    </div>
</div>

<div class="content">
    <div class="sub-content">
        <h2 class="message-head is-center">请求已经成功发送！</h2>

        <div class="pure-g">
            <div class="pure-u-1 pure-u-md-1">

                <div class="user-info is-center">
                    <p>系统正在根据您填写的表单匹配留学顾问，留学顾问将在24小时以内为您发送定制留学计划！</p>
                </div>
                <div class="view-more is-center">
                    <div class="l-box-lrg is-center pure-u-1-4 pure-u-md-1-4 pure-u-lg-1-4">
                        <a href="#">
                            <img class="pure-img-responsive" alt="File Icons" src="<c:url value="/resources/img/common/University Filled-80.png"/>" title="大学排名查询" >
                        </a>
                    </div>
                    <div class="l-box-lrg is-center pure-u-1-4 pure-u-md-1-4 pure-u-lg-1-4">
                        <a href="#">
                            <img class="pure-img-responsive" alt="File Icons" src="<c:url value="/resources/img/common/Graduation Cap Filled-80.png" />" title="学科前景分析">
                        </a>
                    </div>
                    <div class="l-box-lrg is-center pure-u-1-4 pure-u-md-1-4 pure-u-lg-1-4">
                        <a href="#">
                            <img class="pure-img-responsive" alt="File Icons" src="<c:url value="/resources/img/common/Living Room Filled-80.png" />" title="留学生活相关">
                        </a>
                    </div>
                    
                    <p><a href="#">浏览更多>></a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer l-box is-center">
    Malimaligong.com ®
</div>


</body>
</html>
