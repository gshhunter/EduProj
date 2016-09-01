<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/pure.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/side-menu.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/grids-responsive.css" />">

    <title>中介工作详细内容 已有方案</title>

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
       
        .commentPoster {
            font-size: 90%;
            color: #737373;
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
        .is-center{
        	text-align: center;
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
                    <li><a href="#">收件箱</a></li>
                    <li><i class="fa fa-smile-o" aria-hidden="true"></i><a href="#">张顾问</a></li>
                    <li><a href="#">退出</a></li>                   
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
                        <label class="pure-u-1-5 is-center">学生申请详情</label>
                            <!-- <i class="fa fa-hourglass-half" aria-hidden="true"></i> -->
                        <div class="pure-u-2-5"></div>
                    </div>
                </div>
                <div class="insidePageContentMcx">
                    <div class="pure-g">
                        <div class="pure-u-1-24"></div>
                        <form class="pure-form pure-form-aligned pure-u-22-24">
                             <!--处理中的申请-->
                            <fieldset id="current">
                                <br>
                                <div class="pure-g commentPoster">
                                    <div class="pure-u-1-24"></div>
                                    <div class=" pure-u-10-24">
                                        <legend class="textStyle">1 基本资料</legend><br>
                                        <div class="pure-g respondBox">
                                            <div class="pure-u-1-4">
                                                <i class="fa fa-user fa-5x iconColor" aria-hidden="true"></i>
                                            </div>
                                            <div class="pure-u-3-4">
                                                <div class="pure-g">
                                                    <label class="pure-u-1-5 ">姓名:</label>
                                                    <label class="pure-u-4-5 ">${account.lastname} ${account.firstname}</label>
                                                    <label class="pure-u-1-5 ">电话:</label>
                                                    <label class="pure-u-4-5 ">
	                                                    <c:if test="${account.cellphone eq null || account.cellphone == ''}">
	                                                    	<a href="">前往验证</a>
	                                                    </c:if>
	                                                    <c:if test="${account.cellphone != null}">
	                                                    	${account.cellphone}
	                                                    </c:if>
                                                    </label>
                                                    <label class="pure-u-1-5 ">邮件:</label>
                                                    <label class="pure-u-4-5 ">${account.email}</label>
                                                </div>
                                            </div>
                                         </div>
                                    </div>
                                    <div class="pure-u-1-24"></div>
                                    <div class="pure-u-10-24">
                                        <legend class="textStyle">2 学生意愿</legend><br>
                                        <div class="pure-g">
                                            <label class="pure-u-7-24">学 历:</label>
                                            <label class="pure-u-17-24">${degree}</label>
                                            <label class="pure-u-7-24">高考信息:</label>
                                            <label class="pure-u-17-24">
                                            	<c:if test="${request.currentDegree == 2}">
                                            		${request.gaokaoResult}／${request.gaokaoLocation}／${request.gaokaoYear}
                                            	</c:if>
                                            	<c:if test="${request.currentDegree != 2}">
                                            		无
                                            	</c:if>
                                            </label>
                                            <label class="pure-u-7-24">意愿方向:</label>
                                            <label class="pure-u-17-24">${request.interestMajor1}</label>
                                            
                                        </div>
                                    </div>
                                   
                                    </div>
                                    <br><br>
                                    <div class="pure-g commentPoster">
                                        <div class="pure-u-1-24"></div>
                                        <div class="pure-u-21-24">
                                            
                                            <legend class="textStyle">3 详细留学计划</legend><br>
                                            <div id="planDtl" class="pure-g">
                                                <div class="pure-u-1-24"></div>
                                                <!--学校一-->
                                                <div class="pure-u-7-24">
                                                    <h4>学校一</h4>
                                                    <div class="pure-g">
                                                        <label class="pure-u-1-5">大学:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].univercityName}</label>
                                                        <label class="pure-u-1-5">课程:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].bachelorCourseName}</label>
                                                        <label class="pure-u-1-5">学制:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].bachelorSemesters} 学期 （${plan.options[0].bachelorSemesters/2.0} 学年）</label>
                                                        <label class="pure-u-1-5">学费:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].bachelorTuition} 澳元/每年</label>
                                                        <label class="pure-u-1-5">预科:</label>
                                                        <label class="pure-u-4-5">
                                                        	<c:if test="${plan.options[0].diplomaSemesters > 0 }">是</c:if>
                                                        	<c:if test="${plan.options[0].diplomaSemesters <= 0 }">否</c:if>
                                                        </label>
                                                    </div>
                                                    <br>
                                                    <c:if test="${plan.options[0].diplomaSemesters > 0 }">
                                                    <div class="pure-g">
                                                        <label class="pure-u-1-5">预科:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].collegeName}</label>
                                                        <label class="pure-u-1-5">课程:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].diplomaCourseName}</label>
                                                        <label class="pure-u-1-5">学制:</label>
                                                        <label class="pure-u-4-5">3 学期 （1 学年）</label>
                                                        <label class="pure-u-1-5">学费:</label>
                                                        <label class="pure-u-4-5">${plan.options[0].diplomaTuition} 澳元/每年</label>
                                                    </div>
                                                    </c:if>
                                                </div>
                                                <div class="pure-u-1-24"></div>
                                                <!--学校二-->
                                                <div class="pure-u-7-24">
                                                    <h4>学校二</h4>
                                                    <div class="pure-g">
                                                        <label class="pure-u-1-5">大学:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].univercityName}</label>
                                                        <label class="pure-u-1-5">课程:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].bachelorCourseName}</label>
                                                        <label class="pure-u-1-5">学制:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].bachelorSemesters} 学期 （${plan.options[1].bachelorSemesters/2.0} 学年）</label>
                                                        <label class="pure-u-1-5">学费:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].bachelorTuition} 澳元/每年</label>
                                                        <label class="pure-u-1-5">预科:</label>
                                                        <label class="pure-u-4-5">
                                                        	<c:if test="${plan.options[1].diplomaSemesters > 0 }">是</c:if>
                                                        	<c:if test="${plan.options[1].diplomaSemesters <= 0 }">否</c:if>
                                                        </label>
                                                    </div>
                                                    <br>
                                                    <c:if test="${plan.options[1].diplomaSemesters > 0 }">
                                                    <div class="pure-g">
                                                        <label class="pure-u-1-5">预科:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].collegeName}</label>
                                                        <label class="pure-u-1-5">课程:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].diplomaCourseName}</label>
                                                        <label class="pure-u-1-5">学制:</label>
                                                        <label class="pure-u-4-5">3 学期 （1 学年）</label>
                                                        <label class="pure-u-1-5">学费:</label>
                                                        <label class="pure-u-4-5">${plan.options[1].diplomaTuition} 澳元/每年</label>
                                                    </div>
                                                    </c:if>
                                                </div>
                                                <div class="pure-u-1-24"></div>
                                                <!--学校三-->
                                                <div class="pure-u-7-24">
                                                    <h4>学校三</h4>
                                                    <div class="pure-g">
                                                        <label class="pure-u-1-5">大学:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].univercityName}</label>
                                                        <label class="pure-u-1-5">课程:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].bachelorCourseName}</label>
                                                        <label class="pure-u-1-5">学制:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].bachelorSemesters} 学期 （${plan.options[2].bachelorSemesters/2.0} 学年）</label>
                                                        <label class="pure-u-1-5">学费:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].bachelorTuition} 澳元/每年</label>
                                                        <label class="pure-u-1-5">预科:</label>
                                                        <label class="pure-u-4-5">
                                                        	<c:if test="${plan.options[2].diplomaSemesters > 0 }">是</c:if>
                                                        	<c:if test="${plan.options[2].diplomaSemesters <= 0 }">否</c:if>
                                                        </label>
                                                    </div>
                                                    <br>
                                                    <c:if test="${plan.options[2].diplomaSemesters > 0 }">
                                                    <div class="pure-g">
                                                        <label class="pure-u-1-5">预科:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].collegeName}</label>
                                                        <label class="pure-u-1-5">课程:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].diplomaCourseName}</label>
                                                        <label class="pure-u-1-5">学制:</label>
                                                        <label class="pure-u-4-5">3 学期 （1 学年）</label>
                                                        <label class="pure-u-1-5">学费:</label>
                                                        <label class="pure-u-4-5">${plan.options[2].diplomaTuition} 澳元/每年</label>
                                                    </div>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <br><br>
                                            <legend class="textStyle">4 申请状态</legend><br>
                                            <div class="pure-g">
                                                <div class="pure-u-1-24"></div>
                                                <div class="pure-u-20-24">
                                                    <p>申请状态：<span>申请中</span></p>
                                                    <p>申请开始时间：<span>${plan.createdTime}</span></p>
                                                    <div class="pure-g">
                                                        <label class="pure-u-16-24"></label>
                                                        <a id="sendTRN" class="pure-u-8-24 pure-button pure-button-primary">附上签证号码并完成申请</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                
                                
                            </fieldset>  
                        </form>
                        <div class="pure-u-1-24"></div>
                    </div>
                    <br> 
                </div>
            </div>
            <div class="pure-u-4-24"> 
                <a class="alwaysRight linkStyle"
                href="file:///Users/Chenxue/Documents/EduFont/agent1CaseListIng1.html">返回列表<i class="fa fa-caret-left" aria-hidden="true"></i></a>
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
  	<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
  	<script type="text/javascript" src="<c:url value="/resources/js/layer/layer.js" />"></script>
    <script>
        $(document).ready(function() {
        	var trn;
            $("#sendTRN").click(function(e) {
                layer.prompt({
             		title: '输入TRN:',
              		formType: 0 //prompt风格，支持0-2
            	}, function(pass){
            		
                	layer.msg('TRN: '+ pass+' 输入成功！' );
                	$.get('http://localhost:8080/agency/plan/api/saveTRN?pid='+${plan.idPlan}+'&trn='+pass, function(data){
            			
                		$(location).attr('href','http://localhost:8080/agency/plan/toCaseDetail?pid='+${plan.idPlan});
                	});
            	});
                
            });
        });
    </script>
</body>
 

</html>