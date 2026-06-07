<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Sign Up Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- js -->
<script src="js/jquery-1.8.3.min.js"></script>
<!-- //js -->
<link href="css/style_user-register.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Comfortaa:400,300,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/VCode.js"></script>
<script type="text/javascript" src="js/index_register.js"></script>
</head>
<body onload="printVCode();">
	<div class="main">
		<h1>用户注册</h1>
		<div class="agileinfo_main">
			<h3>请填写您的信息</h3>
			<h2>欢迎加入我们</h2>
			<form action="user_register_post" method="post" onsubmit="return check_loginInfo_submit();">
				<div class="agileinfo_main_grid1 agileinfo_main_grid">
					<input id="user.loginName" name="user.loginName" type="text" size="20" maxlength="20" required aria-required="true" pattern="[A-Za-z0-9_]+" placeholder="用户登录名"/> 
				</div>
				<!---strat-date-piker---->
					<link rel="stylesheet" href="css/jquery-ui.css" />
					<script src="js/jquery-ui.js"></script>
					  <script>
							  $(function() {
								$( "#datepicker,#datepicker1" ).datepicker();
							  });
					  </script>
				<!---/End-date-piker---->
				<div class="agileinfo_main_grid2 agileinfo_main_grid"></div> 
				<div class="agileinfo_main_grid agileinfo_main_grid_left">
					<input id="user.password" name="user.password" type="password" size="20" maxlength="20" required aria-required="true" pattern="[A-Za-z0-9\@\#\$\%\^\&\*_]+" placeholder="密码"/> 
			  </div>
				<div class="agileinfo_main_grid agileinfo_main_grid_left1">
					<p>
					  <input id="password2" name="password2" type="password" size="20" maxlength="20" required aria-required="true" pattern="[A-Za-z0-9\@\#\$\%\^\&\*_]+" placeholder="密码确认"/>
				  </p>
					<p id="hintForPassword">&nbsp;</p>
				</div>
              <div class="agileinfo_main_grid2 agileinfo_main_grid"></div>
              
              <div class="agileinfo_main_grid agileinfo_main_grid_left">
					<input name="VCode" type="text" id="VCode" size="4" maxlength="4" required aria-required="true" placeholder="验证码">
			  </div>
				<div class="agileinfo_main_grid agileinfo_main_grid_left1">
                    <a href="javascript:printVCode();">
                    <input type="hidden" id="VCodeValue" name="VCodeValue" value="">
			<canvas id="VCodeImage" name="VCodeImage" height="50" width="100"/></a>
				</div>
              <div class="agileinfo_main_grid2 agileinfo_main_grid"></div>
              
              <input type="submit" value="提交">
			</form>
		</div>
		<div class="wthree_footer_copy">
			<p>XXXXXXXX - XXX</p>
		</div>
	</div>
</body>
</html>