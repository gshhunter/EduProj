<%@ page language="java" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>中介工作列表当前申请</title>


<style>
hr {
	display: block;
	margin-top: 0.2em;
	margin-bottom: 1em;
	margin-left: auto;
	margin-right: auto;
	border: none;
	height: 1px;
	background-color: #b3b3b3;
}

.insidePageContent {
	background: white;
	margin-top: 15px;
	margin-left: 20px;
	border-style: solid;
	border-color: #f2f2f2;
	border-width: 1px;
	border-radius: 5px;
}

.commentPoster {
	font-size: 90%;
	color: #8c8c8c;
}

.upper {
	margin-top: -10px;
}
</style>
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
						<!-- <li><a href="#">收件箱</a></li> -->
						<li><a href="<%=request.getContextPath() %>/account/toEditProfile">${loginEmail}</a></li>
						<li><a href="<%=request.getContextPath() %>/account/logout">退出</a></li>

					</ul>
				</div>

			</div>
		</div>

		<!--水平菜单-->
		<div class="pure-g headerMenuBackgroundMcx">
			<div class="pure-u-2-24 "></div>
			<div
				class="pure-u-22-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx headerMenuBackgroundMcx">
				<ul class="menuStyleMcx">
					<li><a href="#">您的申请</a></li>
					<li class="menuItemSelectedMcx"><a href="<%=request.getContextPath() %>/agent/toCaseList"
						style="color: #f2f2f2; border-bottom: 3px solid #f2f2f2; padding-bottom: 7px;">工作列表</a></li>
					<li><a
						href="<%=request.getContextPath() %>/account/toEditProfile">个人资料</a></li>
					<li><a
						href="<%=request.getContextPath() %>/account/toPrivacySetting">账号管理</a></li>
				</ul>
			</div>
		</div>

		<br>
		<div class="pure-g">
			<div class="pure-u-2-24"></div>
			<!--垂直菜单-->
			<div
				class="pure-u-3-24 pure-menu pure-menu-open testMenuMcx menustyleVerMcx ">
				<ul>
					<li class="menuItemSelectedMcx" style="color: black !important;"><i
						class="fa fa-caret-right" aria-hidden="true"></i><a href="<%=request.getContextPath() %>/agent/toCaseList">处理中的申请</a></li>
					<li><a style="font-size: 95%;"
						href="file:///Users/Chenxue/Documents/EduFont/agent1CaseListPre2.html">未给出方案的申请</a></li>
					<li><a
						href="<%=request.getContextPath() %>/agent/toCaseList-done">已完成的申请</a></li>
				</ul>
			</div>
			<!--垂直菜单-->


			<div class="pure-u-15-24">
				<br>


				<div class="">
					<div class="pure-g">
						<div class="pure-u-1-24"></div>
						<div class="pure-u-22-24">
							<table id="tableid" class="display pure-table pure-table-horizontal inTheMiddle" width="100%">

								<thead>
									<tr>
										<th>申请人姓名</th>
										<th>意向学校一</th>
										<th>意向学校二</th>
										<th>意向学校三</th>
										<th>申请开始时间</th>
										<th>详 情</th>
									</tr>
								</thead>						
							</table>
						</div>

						<br>
					</div>
				</div>
				<div class="pure-u-3-24"></div>
			</div>
		</div>
	</div>
	<!--footer display here-->
	<div>
		<footerpage></footerpage>

		<script src="js/riot.js"></script>

		<script src="footerpage.tag" type="riot/tag"></script>

		<script>
			riot.mount('footerpage')
		</script>
	</div>

</body>
<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js" />"></script>
<!-- <script type="text/javascript" src="<c:url value="https://cdn.datatables.net/plug-ins/1.10.12/sorting/chinese-string.js" />"></script> -->
<script type="text/javascript">
	$(document).ready(function(){
		$.get('http://localhost:8080/agency/agent/api/getUnprocessedPlan', function(data){
			var table = $("#tableid").DataTable({
				"data": data,
	            "columns": [{"mData":"username"},
	                          {"mData":"uni1"},
	                          {"mData":"uni2"},
	                          {"mData":"uni3"},
	                          {"mData":"createdTime"},
	                          {"mData":"pid",
	                           "render": function(data, type, full, meta){
	                        	   return '<a href="http://localhost:8080/agency/plan/toCaseDetail?pid=' + data + '"> 详细\>\></a>';
	                           }
	                         }],
				"oLanguage": {
				      "sSearch": "过滤：",
				      "sZeroRecords": "没有数据",
				      "oPaginate": {
				    	  "sFirst": "首页",
				    	  "sLast": "末页",
				          "sNext": "下一页",
				          "sPrevious": "上一页"
				      },
				      "sInfo": "显示 _START_ 到 _END_ 条结果，总计 _TOTAL_ 条数据",
				      "sInfoEmpty": "",
				      "sLengthMenu": "显示 _MENU_ 条数据",
				      "sProcessing": "服务器处理中...",
				      "sInfoFiltered": "共有 _MAX_ 条数据被过滤"
				}
			});
		});
	});
</script>

</html>