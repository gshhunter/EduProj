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

    <title>申请成为顾问状态页面</title>


    <style>
      
        .insidePageContent {
            
            margin-top: 15px;
           
            padding: 5px 5px 5px 5px;
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
        
        .iconStyle{
            color:#00897B;
        }
        .picStyle{
            color:#4CAF50;
            margin-right:20px;
        }
        .titleStyle{
            margin-top:30px;
            text-align:center;
        }
        .bk{
            padding-right:20px;
            padding-left:20px;
            color:#4CAF50;
        }
        .bannerG{
            font-size:150%; 
            text-align:center; 
            background:#4CAF50;
            padding:20px; 
            color:white;
        }
        
        
    </style>
</head>

<body>
    <div class="wrap">
        <div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <a class="webTitleh1FontMcx" href="<%=request.getContextPath() %>/home.do">Malimalihong</a>
                </div>
                              
                <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
                <ul class="menuStyleMcx headerLinkStyleMcx">                  
                    <!--<li><a href="#">收件箱</a></li>-->
                    <li><a href="<%=request.getContextPath() %>/account/toViewProfile.do">${loginUser.email}</a></li>
                    <li><a href="<%=request.getContextPath() %>/account/logout.do">退出</a></li>                                     
                </ul>
                </div>
                
            </div>
        </div>
        <br>
        <br>
        <br>
        <h1 class="titleStyle">感谢您的申请</h1>
        <br>
         <p class="bannerG">请将详细个人资料及护照扫描件发送到:<br>Service@malimalihong.com.au</p>
         <div class="pure-g">
             <div class="pure-u-8-24"></div>
             <div class="pure-u-8-24 insidePageContent" style="text-align:center;">
                    <br><br><br>
                    <a href=""><i class="fa fa-home fa-4x bk" aria-hidden="true"></i></a>
                    <a href=""><i class="fa fa-graduation-cap fa-4x bk" aria-hidden="true"></i></a>
                    <a href=""><i class="fa fa-rss fa-4x bk" aria-hidden="true"></i></a>
                    <a href=""><i class="fa fa-calendar fa-4x bk" aria-hidden="true"></i></a>
             </div>
             <div class="pure-u-7-24"></div>
         </div>
   
    </div>
    <!--footer display here-->
    <div>
        <footerpage></footerpage>
         
         <script src="js/riot.js"></script>

        <script src="footerpage.tag" type="riot/tag"></script>

        <script>riot.mount('footerpage')</script>
    </div>
</body>


</html>