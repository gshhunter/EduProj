<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="zh">
<head>
    <script src="https://cdn.socket.io/socket.io-1.2.0.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="http://edu.comeon.today/public/resources/pure.css">
<link rel="stylesheet"
	href="http://edu.comeon.today/public/css/side-menu.css">
<link rel="stylesheet"
	href="http://edu.comeon.today/public/resources/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://edu.comeon.today/public/resources/grids-responsive.css">
<link rel="stylesheet"
	href="http://edu.comeon.today/public/css/main.css">

<script src="http://edu.comeon.today/public/resources/jquery.js"></script>
<script src="http://edu.comeon.today/public/resources/jquery.cookie.js"></script>
<script src="http://edu.comeon.today/public/resources/layer/layer.js"></script>
    <title>可以申请的学校</title>


    <style>
      
        .insidePageContent {           
            margin-top: 15px;         
            padding: 5px 5px 5px 5px; 
                     
        }
   
       
        .titleStyle{
            margin-top:30px;
            text-align:center;
            margin-left:3px;
             margin-bottom:10px;
        }
    
        .inTheMiddle{
            margin-left:auto;
            margin-right:auto; 
        }
        .middleText{
            text-align: center;
        }
        .chatBox{
            position: fixed;
            bottom: 2px;
            right: 2px;
            width:40%;
            height: 40%;
            
        }
         .alwaysRight{
            position: fixed;
            bottom: 50%;
            right: 0;
            writing-mode: vertical-rl;
            padding:2px;
            background:#00C853;
            color:white;
        }
        #info { list-style-type: none; margin: 0; padding: 0; }
        #info il { padding:3px; border-radius: 5px; border-width: 1px; border-style: solid;}
        #info div {background: #AED581; padding: 5px; border-bottom: 2px solid grey;}
        #info label {padding: 5px;}
        
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
                    <li><a href="#">收件箱</a></li>
                    <li><i class="fa fa-smile-o" aria-hidden="true"></i><a href="#">Amy</a></li>
                    <li><a href="#">退出</a></li>                                     
                </ul>
                </div>
                
            </div>
        </div>
      
        <h1 class="titleStyle ">
            <i class="fa fa-university" style="margin-right:30px;" aria-hidden="true"></i>你可以申请的学校</h1>
        <br>
        
        <!--<h2 style="margin-left:200px;">Amy 同学：</h2>-->
            
      
             
                      
         <div class="pure-g">
             <div class="pure-u-4-24"></div>
             <div class="pure-u-16-24 insidePageContent">
                 <ul id="info">
                 
                 </ul>
                 
                 
                 
                 
<!--
                    <table class="pure-table pure-table-horizontal inTheMiddle">
                        <thead>
                            <tr>
                                <th></th>
                                <th>学校名称</th>
                                <th class="middleText">对应英文名称</th>
                                <th class="middleText">详 情</th>
                            </tr>
                        </thead>

                        <tbody id="info">
                            <tr>
                                <td>1</td>
                                <td>莫纳什学院(莫纳什大学)</td>
                                <td>Monash College(Monash University)</td>
                                <td><a class="pure-button" 
                                    href='file:///Users/Chenxue/Documents/EduFont/detailUniversityIntro.html'>
                                    查看详情</a></td>
                            </tr>

                          
                        </tbody>
                    </table>
-->
                 
                    <br>
                    <div class="pure-g">
                        <div class="pure-u-9-24"></div>
                        <a id="sendBtn" class="pure-u-6-24 btnMcx">申请并付款</a>   
                        <div class="pure-u-8-24"></div>
                    </div>             
                    
             </div>
         </div>
       <a id="open" class="alwaysRight">点此展开聊天</a>
        <div id="chatBox" class="chatBox hideThisMcx">
            
            <studentChat></studentChat>
            
            <script src="http://edu.comeon.today/public/resources/riot.js"></script>
            <script src="http://edu.comeon.today/public/tag/studentChat.tag" type="riot/tag"></script>


            <script>riot.mount('studentChat')</script>
        </div>
        <!--<div id="chatBoxFold" class="chatBoxFold">
            <a id="open" class="pure-button">点此展开</a>
        </div>-->
        
         <script type="text/javascript">
            var isToggled = true;
            $("#open").click(function(){ 
                $('#chatBox').toggle();
                if(isToggled){
                    $("#open").text('收起聊天');isToggled = false;
                }
                else{
                    $("#open").text('展开聊天');isToggled = true;
                }
                
            });
            
             //导入Cookie中的内容
            var reqID = Cookies.get('requestID');
             //获取Cookie
             $(document).ready(function(){
                 console.log('request ID = ', reqID);
                 crossDomain("GET",'http://edu.comeon.today/api/v1/systemplan?rid='+reqID, null, function(returnPlan){
                     console.log('print get plan',returnPlan);
                     //统计给出几个options
                     var length = returnPlan.options.length;
//                     console.log('length of returnplan',length);
                     var suggestion = new Array(); 
                     var i;
                     for(i=0;i<length;i++){
                         console.log(i);
                     var clgName = returnPlan.options[i].collegeName;
                     var dipName = returnPlan.options[i].diplomaName;
                     var dipFee = returnPlan.options[i].tuition;
                     var dipSem = returnPlan.options[i].semesters;
                     var uniName = returnPlan.options[i].universityName;
                     var cosName1 = returnPlan.options[i].bechelors;

                     var container = document.getElementById('info');
                     var msgToDisplay = document.createElement('li');
                     var uniOption = $.makeArray(returnPlan.options[i].bachelors);
                     var keys =Object.keys(returnPlan.options[i].bachelors);
                     var courseOption;    
                    
                     
//                     var bchOption = $.map(uniOption, function(value,index){
//                         console.log(value);
//                         return value;
//                     });
                     
                     var innerH = 
                         '<div class= pure-g>'
                             +'<label class="pure-u-3-24">'+ 'Option'+(i+1)+'</label>'
                             +'<label class="pure-u-10-24">'+ 'COLLEGE:' + '<br>' 
                                +'预科名称：'+ clgName + '<br>' 
                                +'课程名称：'+ dipName + '<br>' 
                                +'学费：'+ dipFee +'澳币每年'+'<br>' 
                                +'学期长度：'+ dipSem +'学期'+'</label>' 
                             + '<label class="pure-u-10-24" id="uni">'+ 'UNIVERSITY:'+ '<br>' + '大学名称：'+ uniName ;

                     keys.map(function(thisKey){
                         console.log(returnPlan.options[i].bachelors[thisKey]);
                         courseOption = returnPlan.options[i].bachelors[thisKey].toString();
                         console.log(courseOption);
                          innerH=  innerH + '<li>课程名称：'+ courseOption + '</li>';
                     })
                     innerH =  innerH + '</label>'+'</div>';
                     msgToDisplay.innerHTML = innerH;
                     container.appendChild(msgToDisplay);
                     
                     }
                     
                    });
                 
             });
             
            $('#sendBtn').click(function(){
                //layer 插件 prompt层 方法
                layer.prompt({
                  title: '输入邀请码',
                  formType: 1 //prompt风格，支持0-2
                }, function(pass){
                    var promCode = new Object();
                        promCode.type = 1;
                        promCode.requestId = Number(reqID);
                        promCode.code = pass;
                    var pCode = JSON.stringify(promCode);
                    console.log(pCode);
                    crossDomain("POST",'http://edu.comeon.today/api/v1/codevalidation',pCode,function(returnStatus){
                        if(returnStatus.status==0){
                            layer.msg('邀请码验证成功！');
                            console.log(returnStatus);
                        }
                        else{
                            layer.msg('邀请码验证失败！');
                            console.log(returnStatus);
                        }
                    });
                });
            });
            
            //跨域请求的post和get方法
            function crossDomain(method,url,data,callback){
               $.ajax({
                   method: method,
                   url:    url,
                   data:   data,
                   xhrFields: {
                       withCredentials: true
                   }
               }).done(callback);
            }
            function back(msg){
               console.log(msg);
            }
             
             
            
        </script> 
                   
    </div>

    <!--<div class="footer">Malimaligong.com ®</div>-->
</body>


</html>