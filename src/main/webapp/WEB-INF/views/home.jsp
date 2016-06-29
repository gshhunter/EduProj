<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Home Page of Studying Abroad">

    <title>首页</title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <!--[if lte IE 8]>
    
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
    
    <![endif]-->
    <!--[if gt IE 8]><!-->
    
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
    
    <!--<![endif]-->
    
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

    <!--[if lte IE 8]>
        <link rel="stylesheet" href="css/layouts/marketing-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="<c:url value="/resources/css/layouts/marketing.css" />" >
    <!--<![endif]-->

</head>
<body>

<div class="header">
    <div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
        <a class="pure-menu-heading" href="#">Logo</a>

        <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">成为留学顾问</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">注册</a></li>
            <li class="pure-menu-item"><a href="#" class="pure-menu-link">登录</a></li>
        </ul>
    </div>
</div>

<div class="splash-container">
    <!--<div class="bg-img">
        <img src="img/bg1.jpg" />
    </div>-->
    <div class="splash">
        <h1 class="splash-head">澳洲留学</h1>
        <p class="splash-subhead">
            提供专业留学信息，自主选择留学服务
        </p>
        <p>
            <a href="#" class="pure-button pure-button-primary">我要留学</a>
        </p>
    </div>
</div>

<div class="content-wrapper">
    
    <div class="content">
        <h2 class="content-head is-center">澳洲高校</h2>
        
        <div class="pure-g">
            <div class="photo-box pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                <a href="www.monash.edu">
                    <img src="<c:url value="/resources/img/home/university1.jpg" />" alt="Monash University">
                </a>
            </div>
            <div class="photo-box pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                <a href="www.monash.edu.au">
                    <img src="<c:url value="/resources/img/home/university2.jpg" />" alt="Monash University">
                </a>
            </div>
            <div class="photo-box pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                <a href="www.monash.edu.au">
                    <img src="<c:url value="/resources/img/home/university3.jpeg" />" alt="Monash University">
                </a>
            </div>
            
        </div>
        <div class="pure-g" style="margin-top:50px;">
        	<div class="photo-box pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                <a href="www.monash.edu">
                    <img src="<c:url value="/resources/img/home/university1.jpg" />" alt="Monash University">
                </a>
            </div>
            <div class="photo-box pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                <a href="www.monash.edu.au">
                    <img src="<c:url value="/resources/img/home/university2.jpg" />" alt="Monash University">
                </a>
            </div>
            <div class="photo-box pure-u-1 pure-u-md-1-3 pure-u-lg-1-3">
                <a href="www.monash.edu.au">
                    <img src="<c:url value="/resources/img/home/university3.jpeg" />" alt="Monash University">
                </a>
            </div>
        </div>
    </div>
    
    <div class="content">
    	<h2 class="content-head is-center" >学生风采</h2>
    	<div class="pure-g">
	    	<div class="l-box pure-u-md-1-5 pure-u-lg-1-5">
	    		
	    	</div>
	    	<div class="l-box is-center pure-u-1-1 pure-u-md-3-5 pure-u-lg-3-5">
	    		<img src="<c:url value="/resources/img/home/discovery.jpg" />" alt="Promotion" class="pure-img-responsive">
	    	</div>
	    	<div class="l-box pure-u-md-1-5 pure-u-lg-1-5">
	    		
	    	</div>
    	</div>
    </div>
    
    <div class="content">
        <h2 class="content-head is-center">留学服务</h2>

        <div class="pure-g">
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                    <i class="fa fa-rocket"></i>
                    留学意愿
                </h3>
                <p>
                    通过填写调查问卷，系统将根据申请条件自动匹配到合适的澳洲学校。
                </p>
            </div>
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                    <i class="fa fa-mobile"></i>
                    留学查询
                </h3>
                <p>
                    帮您找到详尽的澳洲留学信息，再也不怕被忽悠。
                </p>
            </div>
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                    <i class="fa fa-th-large"></i>
                    顾问推荐
                </h3>
                <p>
                    帮助申请者推荐优秀的留学顾问，提升offer成功率。
                </p>
            </div>
            <div class="l-box pure-u-1 pure-u-md-1-2 pure-u-lg-1-4">
                <h3 class="content-subhead">
                    <i class="fa fa-check-square-o"></i>
                    流程跟踪
                </h3>
                <p>
                    平台将会帮助申请者全程追踪留学申请，实时监控申请状态。
                </p>
            </div>
        </div>
    </div>
    
    <div class="ribbon l-box-lrg pure-g">
        <div class="l-box-lrg is-center pure-u-1 pure-u-md-1-2 pure-u-lg-2-5">
            <img class="pure-img-responsive" alt="File Icons" width="300" src="<c:url value="/resources/img/common/file-icons.png" />">
        </div>
        <div class="pure-u-1 pure-u-md-1-2 pure-u-lg-3-5">

            <h2 class="content-head content-head-ribbon">申请指导</h2>

            <p>
                提供了2016年度全澳洲TOP30高校的入学申请要求，请点击左边文件下载链接查看
            </p>
        </div>
    </div>

    <div class="content">
		<h2 class="content-head is-center">关注我们</h2>
        <div class="pure-g is-center">
            <!-- <div class="l-box-lrg pure-u-1 pure-u-md-2-5">
                <form class="pure-form">
                    <fieldset class="pure-group">
                        <label for="name">给我们留言</label>
                        <input id="name" type="text" placeholder="发件人名称">
                        <input id="email" type="email" placeholder="发件人邮箱">
                    </fieldset>
                    <fieldset class="pure-group">
                        <input id="title" type="text" placeholder="邮件标题">
                        <textarea id="e-content" placeholder="请输入邮件内容..." rows="5"></textarea>
                    </fieldset>
                     <button type="submit" class="pure-button">提交</button>
                    
                </form>
            </div> -->
            <div class="l-box-sm pure-u-1 pure-u-md-1-5">
            </div>
			<div class="l-box-sm pure-u-1 pure-u-md-1-5">
				<h4>公司信息</h4>
                <p>关于</p>
                <p>工作机会</p>
                <p>新闻</p>
                <p>博客</p>
                <p>帮助</p>
                <p>政策</p>
                <p>条款与隐私</p>
			</div>
            <div class="l-box-sm pure-u-1 pure-u-md-1-5">
                <h4>发现</h4>
                <p>信任与安全</p>
                <p>留学基金</p>
                <p>礼品卡</p>
                <p>Malihong精选</p>
                <p>移动版</p>
                <p>网站地图</p>
            </div>
            <div class="l-box-sm pure-u-1 pure-u-md-1-5">
                <h4>为什么要留学</h4>
                <p>顾问义务</p>
                <p>客服指导</p>
                <p>建议留言</p>
                <p>新生建议</p>
            </div>
            <div class="l-box-sm pure-u-1 pure-u-md-1-5">
            </div>
        </div>

    </div>

    <div class="footer l-box is-center">
        Malimaligong.com ®
    </div>

</div>






</body>
</html>
