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

    <title>填写签证号码</title>


    <style>
         .textStyle {
            font-size:120%;
            color:#404040;
            padding:2px;
        }
        .middleText{
            text-align:center;
        }
        .iconColor{
            color:#00897B;
        }
       
        .insidePageContent {
            background: white;
            margin-top: 15px;
            margin-left:20px;
            border-style: solid;
            border-color: #f2f2f2;
            border-width: 1px;
            border-radius: 5px;
        }

        .commentPoster {
            font-size: 90%;
            color: #8c8c8c;
            
        }
        .upper{
            margin-top:-10px;
        }
        .addBtn{
            background: #00897B;
            border: 2px solid #00897B;
            border-radius: 5px;
            font-size:150%;
            text-decoration: none;
            color: White;
            padding: 10px 25px 10px 25px;   
            margin-top:20px;
        }
        .alwaysRight{
            position: fixed;
            bottom: 50%;
            right: 15%;
        }
        .linkStyle{
            text-decoration: none;
            color:#424242;
            background: #E0E0E0;
            padding:2px;
            writing-mode: vertical-rl;
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
                    
                    <li><i class="fa fa-smile-o" aria-hidden="true"></i><a href="#">张顾问</a></li>
                    <li><a href="<%=request.getContextPath() %>/account/logout.do">退出</a></li>                   
                    
                </ul>
            </div>
                
            </div>
        </div>

        <!--水平菜单-->
        <div class="pure-g headerMenuBackgroundMcx">
            <div class="pure-u-2-24 "></div>
            <div class="pure-u-22-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx headerMenuBackgroundMcx">
                <ul class="menuStyleMcx">
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/agentDashboard.html">控制面板</a></li>
                    <li><a href="#">收件箱</a></li>
                    <li class="menuItemSelectedMcx"><a href="#" style="color:#f2f2f2; border-bottom:3px solid #f2f2f2;padding-bottom:7px;"">工作列表</a></li>
                    <li ><a href="file:///Users/Chenxue/Documents/EduFont/agentProfile2Edit.html" >个人资料</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/agentAcc1MsgSetting.html">账号管理</a></li>
                </ul>
            </div>
        </div>

        <br>
        <div class="pure-g">
            <div class="pure-u-4-24"></div>
            <!--垂直菜单-->
            
            
            <div class="pure-u-16-24">
                <div class="testMenuMcx horizontalMenuMcx labelTitleStyleMcx">
                    <div class="menuStyleMcx pure-g">
                        <label class="pure-u-2-5"></label>
                        <label class="pure-u-1-5">Abby 同学的申请
                            <i class="fa fa-hourglass-half" aria-hidden="true"></i></label>
                        <div class="pure-u-2-5"></div>
                    </div>
                </div>
                <div class="insidePageContentMcx">
                    <div class="pure-g">
                        <div class="pure-u-6-24"></div>
                        <div class="pure-u-12-24">
                            <form class="pure-form pure-form-stacked">
                                <fieldset>
                                    <p>填写<span>Abby</span>同学的签证号码(VISA Reference Number)：</p>
                                    <input class="pure-u-1-1"id="visaNo" placeholder="VISA Reference Number Here">
                                    <br>
                                    <div class="pure-g">
                                        <div class="pure-u-4-5"></div>
                                        <a class="pure-button pure-button-primary pure-u-1-5">提 交</a>
                                    </div>
                                </fieldsett>
                            </form>
                        </div>
                        <div class="pure-u-6-24"></div>
                    </div>
                    <br> 
                </div>
            </div>
            <div class="pure-u-4-24"> 
                <a class="alwaysRight linkStyle"
                href="file:///Users/Chenxue/Documents/EduFont/agent1CaseList.html">
                返回列表<i class="fa fa-caret-left" aria-hidden="true"></i></a>
            </div>
        </div>

        
      

       <!--显示收到／发出的评价的方法：参数showA为展示，hideB为隐藏-->
       
           
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