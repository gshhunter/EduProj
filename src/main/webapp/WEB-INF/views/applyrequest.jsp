<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="zh">

<head>
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
<title>填写留学意愿</title>

<style>
.backBox {
	margin-top: 20px;
	border: 2px dashed grey;
	margin: 20px 15px 20px 0px;
}

.extrapadding1 {
	padding-bottom: 36px;
	padding-left: 6%;
	padding-right: 6%;
}

.extrapadding2 {
	padding-left: 2%;
	padding-right: 2%;
}

.legendStyle {
	font-size: 110%;
	font-weight: bold;
}

.paddingForm {
	padding: 20px 5px 5px 20px;
}

.btnA {
	float: right;
	text-align: right;
	text-decoration: none;
	margin-right: 20px;
}

.boxBg {
	background: #00ACC1;
	text-align: center;
	margin: 4px;
	border-radius: 2px;
}

.boxBg:hover {
	background: #FBC02D;
}

label {
	padding: 5px 8px 5px 8px;
}

a {
	text-decoration: none;
	color: white;
}

.bannercolor {
	background: #C8E6C9;
}
</style>
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>	-->

</head>

<body>
	<div class="wrap">
		<div class="header">
			<div class="pure-g">
				<div class="pure-u-1-24"></div>
				<div class="pure-u-16-24" style="text-align: left;">
					<a class="webTitleh1FontMcx" href="">Malimalihong</a>
				</div>

				<div
					class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
					<ul class="menuStyleMcx headerLinkStyleMcx">
						<li><a href="#">登录</a></li>
						<li><a href="#">注册</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!--错误信息提示占位-->
		<div id="blank" class="infoBlankMcx"></div>
		<br>
		<h1 class="alignCenterMcx">简单两步，找到最适合你的学校和专业</h1>
		<div class="pure-g bannercolor">
			<div class="pure-u-5-24"></div>
			<div class="pure-u-4-24 backBox extrapadding1">
				<form class="pure-form pure-form-stacked paddingForm">
					<fieldset>
						<label class="legendStyle">1.填写我的高考成绩</label> <label
							for="gkprovince">高考省份</label> <select id="province">
							<option value="" style="color: grey">选择省份</option>
							<option value="Anhui">安徽</option>          
							<option value="Beijing">北京</option>             
							<option value="Chongqing">重庆</option>             
							<option value="Fujian">福建</option>             
							<option value="Gansu">甘肃</option>             
							<option value="Guangxi">广西</option>             
							<option value="Guangdong">广东</option>             
							<option value="Guizhou">贵州</option>             
							<option value="Hainan">海南</option>             
							<option value="Hebei">河北</option>             
							<option value="Heilongjiang">黑龙江</option>             
							<option value="Henan">河南</option>             
							<option value="Hubei">湖北</option>             
							<option value="Hunan">湖南</option>             
							<option value="Inner Mongolia">内蒙古</option>             
							<option value="Jiangsu">江苏</option>             
							<option value="Jiangxi">江西</option>             
							<option value="Jilin">吉林</option>             
							<option value="Liaoning">辽宁</option>             
							<option value="Ningxia">宁夏</option>             
							<option value="Qinghai">青海</option>             
							<option value="Shandong">山东</option>             
							<option value="Shanghai">上海</option>             
							<option value="Shanxi">山西</option>             
							<option value="Shaanxi">陕西</option>             
							<option value="Sichuan">四川</option>             
							<option value="Tianjin">天津</option>             
							<option value="Tibet">西藏</option>             
							<option value="Xinjiang">新疆</option>             
							<option value="Yunnan">云南</option>             
							<option value="Zhejiang">浙江</option>
						</select> <br> <label for="gkscore">高考成绩:</label> <input id="score"
							placeholder="高考分数"> <br>
						<!--<a class="pure-button btnA pure-button-primary" id="showzy" >下一项</a>-->
					</fieldset>
				</form>
			</div>

			<div id="zy" class="pure-u-6-24 backBox extrapadding2">
				<form class="pure-form pure-form-stacked paddingForm">
					<fieldset>
						<label class="legendStyle alignCenterMcx">2.选一个我喜欢的方向</label> <br>
						<div class="pure-g" id="major">
							<div class="boxBg pure-u-7-24" value="Business">
								<a><label><i class="fa fa-line-chart"
										aria-hidden="true"></i> 商科</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="IT">
								<a value="it"><label><i class="fa fa-laptop"
										aria-hidden="true"></i> IT</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="Engineering">
								<a><label><i class="fa fa-cogs" aria-hidden="true"></i>
										工程</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="Education">
								<a><label><i class="fa fa-book" aria-hidden="true"></i>
										教育</label></a>
							</div>

							<div class="boxBg pure-u-7-24" value="Design">
								<a><label><i class="fa fa-paint-brush"
										aria-hidden="true"></i> 设计</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="Arts">
								<a value="aaa"><label><i
										class="fa fa-universal-access" aria-hidden="true"></i> 人文</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="Science">
								<a><label><i class="fa fa-flask" aria-hidden="true"></i>
										科学</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="Law">
								<a><label><i class="fa fa-gavel" aria-hidden="true"></i>法律</label></a>
							</div>
							<div class="boxBg pure-u-7-24" value="Medicine">
								<a><label><i class="fa fa-heartbeat"
										aria-hidden="true"></i>医学</label></a>
							</div>
						</div>
						<br>
						<br>
						<br>
						<br>
					</fieldset>
				</form>
			</div>
			<div class="pure-u-4-24"></div>
		</div>
		<br>
		<div class="pure-g">
			<div class="pure-u-10-24"></div>
			<div class="pure-u-4-24 paddingForm alignCenterMcx">
				<a href="" id="sendRequest" class="btnMcx">查看结果</a>
			</div>
			<div class="pure-u-9-24"></div>
		</div>
		<script type="text/javascript">
			var data = new Object();
			//获取感兴趣的专业的方法	
			$('#major div').click(function(e) {
				data.interestMajor1 = $(e.currentTarget).attr('value');
				console.log(data.interestMajor1);
				$(e.currentTarget).css({
					"background" : "#FBC02D",
					"color" : "484848"
				});
				$('#major div').not($(e.currentTarget)).css({
					"background" : "#00ACC1"
				});
				// $(e.currentTarget).append('<i class="fa fa-check" aria-hidden="true"></i>'); 
			});
			//获取省份
			$('select').click(function() {
				var optionSelected = $(this).find("option:selected");
				data.gaokaoLocation = optionSelected.attr('value');
			});
			//获取高考分数
			$('#score').blur(function() {
				data.gaokaoResult = $('#score').val();
				console.log(data.gaokaoResult);
			});
			$(document)
					.ready(
							function() { //判断是否登录
								$("#sendRequest")
										.click(
												function(e) {
													if (data.gaokaoLocation != null
															&& data.gaokaoLocation != "") {
														if (data.gaokaoResult != null) {
															if (data.interestMajor1 != null) {
																console
																		.log('输入完成');
																crossDomain(
																		"GET",
																		'http://edu.comeon.today/api/v1/userinfo',
																		null,
																		function(
																				returnUserInfo) {
																			console
																					.log(returnUserInfo);
																			if (returnUserInfo.login == 'true') {
																				var stdRequest = JSON
																						.stringify(data);
																				console
																						.log(
																								'logined, print request',
																								stdRequest);
																				crossDomain(
																						"POST",
																						'http://edu.comeon.today/api/v1/newrequest',
																						stdRequest,
																						sendReq);
																			} else {
																				console
																						.log('not login');
																				//弹出登录窗口
																				layer
																						.open({
																							type : 1,
																							skin : 'layui-layer-rim', //加上边框
																							area : [
																									'420px',
																									'240px' ], //宽高
																							title : '登 录',
																							content : '<div class="pure-form pure-form-aligned">'
																									+ '<br>'
																									+

																									'<div class="pure-control-group">'
																									+ '<label for="name">输入用户名</label>'
																									+ '<input id="userName" type="text" placeholder="用户名">'
																									+ '</div>'
																									+

																									'<div class="pure-control-group">'
																									+ '<label for="password">输入密码</label>'
																									+ '<input id="password" type="password" placeholder="密码">'
																									+ '</div>'
																									+

																									'<div class="pure-controls">'
																									+ '<button id="userLogin" class="pure-button pure-button-primary">登录</button>'
																									+

																									'</div>'
																									+ '</div>'
																						});

																				//取出弹窗里的用户名和密码
																				$(
																						'#userLogin')
																						.click(
																								function(
																										e) {
																									var user = new Object();
																									user.email = $(
																											'#userName')
																											.val();
																									user.password = $(
																											'#password')
																											.val();
																									var userLoginInfo = JSON
																											.stringify(user);
																									console
																											.log(
																													'1 print user detail input',
																													user);
																									crossDomain(
																											"POST",
																											'http://edu.comeon.today/api/v1/login',
																											userLoginInfo,
																											function(
																													returnStatus) {
																												// Handles the callback when the data returns
																												console
																														.log(
																																'2 print user login status',
																																returnStatus);

																												if (returnStatus.status == 0) {//status 0:登录 
																													var stdRequest = JSON
																															.stringify(data);
																													crossDomain(
																															"POST",
																															'http://edu.comeon.today/api/v1/newrequest',
																															stdRequest,
																															sendReq);
																												} else {
																													console
																															.log('Unsuccessfully login');
																												}
																											});
																									// return false;
																								});

																			} //end of else
																		})// end of get userinfo

															} else {
																console
																		.log('请选择感兴趣的专业');
															}
														} else {
															console
																	.log('请输入高考成绩');
														}

													} else {
														console.log('请选择高考省份');
													}
													return false;

												});//end of click sendrequest

							});//end of ready function

			//显示错误信息的方法

			var str = '<div id="suc"class="successMcx">操作成功哦！<i class="fa fa-check" aria-hidden="true"></i></div>';
			$(document).ready(function() {
				$("#blank").append(str);
				$("#suc").fadeOut(2000);
			});

			//跨域请求服务器 post 和 get 数据
			function crossDomain(method, url, data, callback) {
				$.ajax({
					method : method,
					url : url,
					data : data,
					xhrFields : {
						withCredentials : true
					}
				}).done(callback);
			}
			function back(msg) {
				console.log(msg);
			}

			//发送学生意愿请求信息并收取反馈 
			function sendReq(returnData) {
				console.log('3 print user request post status, 0 is success',
						returnData);
				if (returnData.status == 0) {//status 0: 请求已接受
					var reqID = returnData.requestId;

					crossDomain(
							"GET",
							'http://edu.comeon.today/api/v1/systemplan?rid='
									+ reqID,
							null,
							function(returnPlan) {
								console.log('4 print get plan', returnPlan);
								//                        document.cookie = reqID; 解决这里的cookie问题
								Cookies.set('requestID', reqID);
								console.log(Cookies.get('requestID'));
								window.location.href = "http://localhost:3000/studentUniPlanSuggest.1.html";
								//                        
							});
				} else {
					console.log('return plan not working');
				}
			}
		</script>
	</div>
	<!--footer display here-->
	<div>
		<footerpage></footerpage>
		<script src="http://edu.comeon.today/public/resources/riot.js"></script>
		<script src="http://edu.comeon.today/public/tag/footerpage.tag" type="riot/tag"></script>
		<script>
			riot.mount('footerpage')
		</script>
	</div>
</body>
</html>
