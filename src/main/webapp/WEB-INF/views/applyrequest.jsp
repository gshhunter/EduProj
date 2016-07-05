<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">

<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="stylesheet"
			href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
			<link rel="stylesheet"
				href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">

				<script type="text/javascript"
					src="<c:url value="/resources/js/lib/jquery.js" />"></script>
				<script type="text/javascript">
					$("p").click(function() {
						$(this).hide();
					});
				</script>

				<title>###</title>

				<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	background-color: #EEEEEE;
}

.wrap {
	height: auto;
	min-height: 100%;
	position: relative;
}

.header {
	background-color: #1464F6;
	color: #FFFFFF;
	height: 70px;
	vertical-align: middle;
}

.content {
	padding: 10px;
	padding-bottom: 50px;
}

.footer {
	margin-top: -30px;
	width: 100%;
	height: 30px;
	background: #6cf;
	text-align: center;
}
</style>
</head>

<body>
	<div class="wrap">
		<div class="header">
			<div class="pure-g">
				<div class="pure-u-1-24"></div>
				<div class="pure-u-10-24">
					<h1>Malimalihong</h1>
				</div>
			</div>
		</div>
		<div class="pure-g content" style="padding-top: 20px">
			<div class="pure-u-1-5"></div>
			<form class="pure-u-3-5 pure-form pure-form-aligned">
				<fieldset>
					<legend>学术成绩</legend>
					<label for="currentDegree">我现在：</label> <select id="currentDegree">
						<option value="middleThree">正在读高三</option>
						<option value="afterMiddle">刚刚高考完</option>
						<option value="UnivercityOne">正在读大一</option>
					</select><br> <label for="gaokaoResult">我的高考成绩大约是总分的百分之：</label> <select
						id="gaokaoResult">
							<option value="40">50以下</option>
							<option value="50">50~60</option>
							<option value="60">60~70</option>
							<option value="70">70~80</option>
							<option value="80">80~90</option>
							<option value="90">90以上</option>
					</select>
				</fieldset>
				<fieldset>
					<legend>兴趣</legend>
					<label for="interestCity">我感兴趣的城市：</label><br> <input
						type="radio" name="interestCity" value="Melbourne" checked>
							墨尔本<br> <input type="radio" name="interestCity"
								value="Sydney"> 悉尼<br> <input type="radio"
										name="interestCity" value="other"> 其他<br> <label
												for="interestMajor">我感兴趣的专业方向：</label><br> <input
													type="checkbox" name="interestMajor" value="accounting" />会计类<br>
														<input type="checkbox" name="interestMajor" value="IT" />IT类<br>
															<input type="checkbox" name="interestMajor" value="other" />其他<br>
				</fieldset>
				<fieldset>
					<legend>雅思成绩</legend>
					<label for="overallScore">总分：</label> <select id="overallScore">
						<option value="4.0">4分及以下</option>
						<option value="4.5">4.5</option>
						<option value="5.0">5</option>
						<option value="5.5">5.5</option>
						<option value="6.0">6</option>
						<option value="6.5">6.5</option>
						<option value="7.0">7</option>
						<option value="7.5">7.5</option>
						<option value="8.0">8分及以上</option>
					</select><br> <label for="listeningScore">听力：</label> <select
						id="listeningScore">
							<option value="4.0">4分及以下</option>
							<option value="4.5">4.5</option>
							<option value="5.0">5</option>
							<option value="5.5">5.5</option>
							<option value="6.0">6</option>
							<option value="6.5">6.5</option>
							<option value="7.0">7</option>
							<option value="7.5">7.5</option>
							<option value="8.0">8分及以上</option>
					</select> <label for="speakingScore">口语：</label> <select id="speakingScore">
							<option value="4.0">4分及以下</option>
							<option value="4.5">4.5</option>
							<option value="5.0">5</option>
							<option value="5.5">5.5</option>
							<option value="6.0">6</option>
							<option value="6.5">6.5</option>
							<option value="7.0">7</option>
							<option value="7.5">7.5</option>
							<option value="8.0">8分及以上</option>
					</select> <label for="readingScore">阅读：</label> <select id="readingScore">
							<option value="4.0">4分及以下</option>
							<option value="4.5">4.5</option>
							<option value="5.0">5</option>
							<option value="5.5">5.5</option>
							<option value="6.0">6</option>
							<option value="6.5">6.5</option>
							<option value="7.0">7</option>
							<option value="7.5">7.5</option>
							<option value="8.0">8分及以上</option>
					</select> <label for="writingScore">写作：</label> <select id="writingScore">
							<option value="4.0">4分及以下</option>
							<option value="4.5">4.5</option>
							<option value="5.0">5</option>
							<option value="5.5">5.5</option>
							<option value="6.0">6</option>
							<option value="6.5">6.5</option>
							<option value="7.0">7</option>
							<option value="7.5">7.5</option>
							<option value="8.0">8分及以上</option>
					</select>
				</fieldset>
				<button type="submit" class="pure-button pure-button-primary">提交申请</button>
				<span id="errorinfo"></apan>
			</form>
			<div class="pure-u-1-5"></div>
		</div>
	</div>
	<div class="footer">Malimaligong.com ®</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			var data = new Object();

			$("form").submit(function(e) {
				if (data.currentDegree == undefined) {
					$("#errorinfo").text("请选择你的就读状况");
					return false;
				} else if (data.gaokaoResult == undefined) {
					$("#errorinfo").text("请选择你的高考成绩");
					return false;
				} else if (data.overallScore == undefined) {
					$("#errorinfo").text("请选择你的分数");
					return false;
				} else if (data.listeningScore == undefined) {
					$("#errorinfo").text("请选择你的听力分数");
					return false;
				} else if (data.speakingScore == undefined) {
					$("#errorinfo").text("请选择你的口语分数");
					return false;
				} else if (data.readingScore == undefined) {
					$("#errorinfo").text("请选择你的阅读分数");
					return false;
				} else if (data.writingScore == undefined) {
					$("#errorinfo").text("请选择你的写作分数");
					return false;
				} else {
					var j = JSON.stringify(data);
					$.post('http://localhost:8080/agency/req/post/', j, function(data) {
						// Handles the callback when the data returns
					});
					return false;
				}
			});

			$("#currentDegree").click(function() {
				data.currentDegree = $(this).val();
			});

			$("#gaokaoResult").click(function() {
				data.gaokaoResult = parseInt($(this).val());
			});

			$("input[name='interestMajor']").click(function() {
				data.interestMajor1 = null;
				data.interestMajor2 = null;
				$("input[name='interestMajor']").attr("disabled", true);
				if ($("input[name='interestMajor']:checked").length >= 2) {
					$("input[name='interestMajor']:checked").attr("disabled", false);
				} else {
					$("input[name='interestMajor']").attr("disabled", false);
				}

				switch ($("input[name='interestMajor']:checked").length) {
				case 0:
					break;
				case 1:
					data.interestMajor1 = $("input[name='interestMajor']:checked").val();
					break;
				case 2:
					var majors = $("input[name='interestMajor']:checked").map(function() {
						return $(this).val();
					}).get();
					data.interestMajor1 = majors[0];
					data.interestMajor2 = majors[1];
					break;
				}
			});

			$("input[name='interestCity']").change(function() {
				data.interestCity = $("input[name='interestCity']:checked").val();
				console.log(data.interestCity);
			});

			$("#overallScore").click(function() {
				data.overallScore = parseFloat($(this).val());
			});

			$("#listeningScore").click(function() {
				data.listeningScore = parseFloat($(this).val());
			});

			$("#speakingScore").click(function() {
				data.speakingScore = parseFloat($(this).val());
			});

			$("#readingScore").click(function() {
				data.readingScore = parseFloat($(this).val());
			});

			$("#writingScore").click(function() {
				data.writingScore = parseFloat($(this).val());
			});

		});
	</script>
</body>

</html>