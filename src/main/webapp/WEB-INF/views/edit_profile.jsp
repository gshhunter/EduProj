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
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/tracy/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/intlTelInput.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery-countryselector.min.css" />">
	<title>学生个人资料编辑</title>
    
    <style>
       
        .insidePageContent {
            background: white;
            margin-top: 15px;
            margin-left:20px;
            border-style: solid;
            border-color: #f2f2f2;
            border-width: 1px;
            border-radius: 5px;
        }
       
       .infoDefault {
       		margin-top: 20px;
       		color: white;
       }
       
       .infoSuccess {
       		background-color: #00cc99;
       }
       
       .infoFail {
       		background-color: #ff8080;
       }
    </style>
</head>

<body>
	<div class="wrap">
		<div class="header">
            <div class="pure-g">
                <div class="pure-u-1-24"></div>
                <div class="pure-u-16-24" style="text-align:left;">
                    <a class="webTitleh1FontMcx" style="font-size:250%;" href="">Malimalihong</a>
                </div>
               
                <div class="pure-u-6-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx">
                <ul class="menuStyleMcx headerLinkStyleMcx">
                    <li class="highlightBorderMcx"><a href="#">成为中介</a></li>
                    <!-- <li><a href="#">收件箱</a></li> -->
                    <li><a id="email"></a></li>
                    <li><a href="#">注销</a></li>                   
                </ul>
            </div>
                
            </div>
        </div>
        
        <!--水平菜单-->
        <div class="pure-g">
            <div class="pure-u-2-24 headerMenuBackgroundMcx" ></div>           
            <div class="pure-u-22-24 pure-menu pure-menu-open testMenuMcx horizontalMenuMcx headerMenuBackgroundMcx">
                <ul class="menuStyleMcx">
                    <!-- <li><a href="file:///Users/Chenxue/Documents/EduFont/studentDashboard.html">控制面板</a></li> -->
                    <!-- <li><a href="#">收件箱</a></li> -->
                    <li><a href="#">您的申请</a></li>
                    <li class="menuItemSelectedMcx"><a href="#"style="color:#f2f2f2;">个人资料</a></li>
                    <li><a href="">账号管理</a></li>
                </ul>
            </div>  
        </div>
        
        <!-- 信息提示 -->
        <div id="blank" class="blank"></div>

        <div class="pure-g">
          
          <div class="pure-u-2-24"></div>
          <div class="pure-u-3-24 pure-menu pure-menu-open testMenuMcx menustyleVerMcx " >
                <ul>
                    <li class="menuItemSelectedMcx"><i class="fa fa-caret-right" aria-hidden="true"></i><a href="#">编辑</a></li>
                    <li><a href="<%=request.getContextPath() %>/account/toVerification">信任验证</a></li>
                    <li><a href="file:///Users/Chenxue/Documents/EduFont/studentProfileComment.html#">评价</a></li>
                   	<br/>  
                	<div class="pure-button">查看我的资料</div>
                </ul>
                
            </div>
            
            <div class="pure-u-16-24 insidePageContent">
              <form class="pure-form pure-form-aligned " style="padding:20px;" method="POST">
                  
                <fieldset>
                	<legend>基本资料 (必填*)</legend>
                	
                    <div class="pure-control-group">
                        <label for="lastname">姓 :</label>
                        <input id="lastname" class="pure-u-2-5" type="text" />
                    </div>

                    <div class="pure-control-group">
                        <label for="firstname">名 :</label>
                        <input id="firstname" class="pure-u-2-5" type="text" />
                    </div>

                    <div class="pure-control-group">
                        <label for="gender">性别:</label>
                        <select id="gender" class="pure-u-1-9">
                        	<option value="-1">---请选择---</option>
                            <option value ="1">男</option>
                            <option value ="0">女</option>
                            <option value ="2">其他</option>
                        </select>
				    </div>
                    
                    
                    <div class="pure-control-group">
                        <label for="birthday">生日:</label>
                        <input id="birthday" class="pure-u-2-5" type="date" />
                    </div>

                    

                </fieldset>
                
                <fieldset>
                	<legend>个性化资料</legend>
                	
                	<div class="pure-control-group">
                        <label for="cellphone">手机:</label>
                        <input id="cellphone" class="pure-u-1" type="tel" style="margin-right:-8px;"/>
                    </div>
                    
                	<div class="pure-control-group">
                		<label>国家:</label>
                		<select id="country" data-role="country-selector" class="pure-u-2-5"></select>
                	</div>
                	
                	<div class="pure-control-group">
                		<label>地址:</label>
                		<input id="address" class="pure-u-2-5" type="text"></input>
                	</div>
                	<div class="pure-control-group">
                		<label>邮编</label>
                		<input id="postcode" class="pure-u-2-5" type="text"></input>
                	</div>
                	<div class="pure-control-group">
                		<label>个人简介:</label>
                        <textarea id="description" class="pure-u-2-5" rows="8" cols="50" ></textarea>
                	</div>
                	<br/>
                	<div class="pure-control-group">
                		<label></label>
                		<button id="saveProfile" type="submit" class="pure-button pure-button-primary pure-u-2-5">保存</button>
                	</div>
                </fieldset>
                
            </form>
            </div>

        </div>
	</div>
    <div class="footer">Malimaligong.com ®</div>
    <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/intlTelInput.min.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.countryselector.min.js" />"></script>
	<script>
	$(document).ready(function(){
		//电话号码国家自动选择
		$("#cellphone").intlTelInput({
			initialCountry: "auto",
			geoIpLookup: function(callback) {
				$.get('http://ipinfo.io', function() {}, "jsonp").always(function(resp) {
					var countryCode = (resp && resp.country) ? resp.country : "";
				    callback(countryCode);
			});}
			,utilsScript: "../resources/js/utils.js"
		});

		$.post("http://localhost:8080/agency/account/api/getProfile", function(data){
			
			if (data == null) {
				$("#info").text("Fail: Cannot load data");
				$("#info").addClass("infoFail");
			} else {
				$("#email").text(data.email);
				$("#email").attr("href", "<%=request.getContextPath() %>/account/toViewProfile");
				$("#firstname").val(data.firstname);
				$("#lastname").val(data.lastname);
				$("#gender").val(data.gender);
				$("#birthday").val(data.birthday);
				console.log(data.birthday);
				$("#cellphone").val(data.cellphone);
				console.log(data.cellphone);
				$("#country").val(data.eng_country);
				console.log(data.eng_country);
				$("#state").val(data.state);
				$("#address").val(data.address);
				$("#description").val(data.description)
				if (data.postcode == 0) {
					$("#postcode").val("");
				} else {
					$("#postcode").val(data.postcode);
				}
				$("#descr").val(data.description);
			}
			
			
		});
		
		$("#saveProfile").click(function(){
			var profile = new Object();
			profile.lastname = $("#lastname").val();
			profile.firstname = $("#firstname").val();
			profile.gender = $("#gender").val();
			profile.birthday = $("#birthday").val();
			profile.cellphone = $("#cellphone").val();
			profile.country = $("#country").val();
			profile.address = $("#address").val();
			profile.postcode = $("#postcode").val();
			profile.description = $("#description").val();
			
			var j = JSON.stringify(profile);
			$.post("http://localhost:8080/agency/account/api/saveProfile", j, function(data) {
				if (data.status == 1) {
					var str='<div id="suc" class="successMcx">操作成功哦！<i class="fa fa-check" aria-hidden="true"></i></div>';
					$("#blank").empty();
					$("#blank").append(str);				
					$("#suc").fadeOut(2000);
					
				} else {
					var str='<div id="fail" class="errorMcx">操作失败哦！<i class="fa fa-times" aria-hidden="true"></i></div>';
					$("#black").empty();
					$("#blank").append(str);				
					$("#fail").fadeOut(2000);
					
				}
			});
			return false;
		});
	});
	  
	</script>
</body>


</html>