<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="<c:url value="/resources/js/lib/jquery.js" />"></script>
<title>填写留学意愿</title>
</head>

<body>

	<script>
		console.log(document.domain);
		var str = '{"email":"gshhunter@gmail.com","password":"f4b5a9f1d424737f13a3abbac4c60f20"}';
		var str2 = '{"gaokaoResult": 500,"gaokaoLocation": "Chongqing","interestMajor1": "Accounting"}';
		$.post('http://localhost:8080/agency/api/v1/login', str, function(data) {
			console.log(data);
			 $.post('http://localhost:8080/agency/api/v1/newrequest',str2,function(data){
			 	console.log(data);
			 })
// 			$.ajax({
// 				method : "POST",
// 				url : 'http://edu.comeon.today/api/v1/newrequest',
// 				data : str2,
// 				xhrFields : {
// 					withCredentials : true
// 				}
// 			}).done(function(msg) {
// 				console.log(msg)
// 			});
		})
	</script>


</body>
</html>