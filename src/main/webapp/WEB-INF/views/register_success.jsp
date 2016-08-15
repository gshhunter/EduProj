<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/pure.css">
    <link rel="stylesheet" href="css/side-menu.css">
    <link rel="stylesheet" href="font-awesome-4.6.3/CSS/font-awesome.min.css">
    <link rel="stylesheet" href="css/grids-responsive.css">
    <link rel="stylesheet" href="css/main.css">

    <title>邮箱注册验证</title>


    <style>
      
      
        .titleStyle{
            margin-top:30px;
            text-align:center;
            
             margin-bottom:10px;
        }
        .verifyBtn{
            background: #00897B;
            border: 2px solid #00897B;
            border-radius: 5px;
            font-size:250%;
            text-decoration: none;
            color: White;
            padding: 15px 25px 15px 25px;   
        }
        .middleBox{
            margin-top:30px;
            text-align:center;
            padding:20px 20px 80px 20px;
            border: 1px dashed #00897B;
        }
    </style>
</head>

<body>
    <div class="wrap">
        <div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <a class="webTitleh1FontMcx" href="">Malimalihong</a>
                </div>
                              
                <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
                <ul class="menuStyleMcx headerLinkStyleMcx">   
                    <li><a href="#">登录</a></li>
                    <li><a href="#">注册</a></li>                                     
                </ul>
                </div>
                
            </div>
        </div>
        <br><br><br>
      
        <div class="pure-g">
            <div class="pure-u-7-24"></div>
            <div class="pure-u-9-24 middleBox">
                <h1 class="titleStyle ">
                    <i class="fa fa-thumbs-up" style="margin-right:30px;" aria-hidden="true"></i>邮箱注册成功！</h1>
                <br><br><br>
                <a  class="verifyBtn" href="#"><span>立即验证</span></a>
            </div>
            <div class="pure-u-7-24"></div>
        </div>
    </div>
    <div class="footer">
        <div class="pure-g">
            <span class="pure-u-1-1" style="text-align: center; color:#00E5FF; font-size:150%;">
                <i class="fa fa-bullseye fa-3x" aria-hidden="true" ></i>Malimaligong
            </span>
        </div>
        <br>
        <div class="pure-g">
            
            <div class="pure-u-8-24">
                <span class="labelStyleF1Mcx">Malimaligong</span><br><br>
                <span class="labelStyleF2Mcx">贴心的留学服务</span><br>
                <div class="labelStyleF2Mcx">
                <a><i class="fa fa-weixin" aria-hidden="true"></i></a>
                <a><i class="fa fa-facebook-square" aria-hidden="true"></i></a>
                <a><i class="fa fa-weibo" aria-hidden="true"></i></a>
                <a><i class="fa fa-qq" aria-hidden="true"></i></a>
                <a><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a><i class="fa fa-twitter-square" aria-hidden="true"></i></a>
                </div>
            </div>
            <div class="pure-u-10-24">
                <div class="pure-g footerLinkSyMcx">
                    <div class="pure-u-1-4">
                        <p>关于我们</p>
                        <a>关于我们</a><br>
                        <a>版权声明</a><br> 
                        <a>用户协议</a><br>
                        <a>联系我们</a>
                        
                    </div>   
                    <div class="pure-u-1-4">
                        <p>帮助中心</p>
                        <a>申请流程</a><br> 
                        <a>退款政策</a><br>
                        <a>安全保障</a><br>
                        <a>常见问题</a>
                    </div> 
                    <div class="pure-u-1-4">
                        <p>媒体中心</p>
                        <a>媒体报道</a><br>
                        <a>新闻中心</a> 
                    </div>
                    <div class="pure-u-1-4">
                        <p>合作网站</p>
                        <a>AAAAA</a><br>
                        <a>BBBBB</a> 
                    </div>
                </div>          
            </div>
            <div class="pure-u-6-24">#二维码</div>
            </div>
            
        <div class="pure-g">
            <span class="pure-u-1-1 ">
            <p class="copyrightBottom">Copyright&nbsp;© &nbsp; 2016 Malimaligong.com ®</p>
            </span>
        </div>
   </div> 
</body>


</html>