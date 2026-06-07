<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
<title>用户登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Mirror Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style_login.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>

	<div class="header">
		<h1>用户登录</h1>
	</div>

<div class="design-w3l">
		<div class="mail-form-agile">
			<form action="user_login_post" method="post">
				<input type="text" id="user.loginName" name="user.loginName" placeholder="登录名" required/>
				<input type="password" id="user.password"  name="user.password" class="padding" placeholder="密码" required/>
				<input type="submit" value="登录">
			</form>
		</div>
		</div>
	
	<div class="footer-w3agile">
	<p>XXXXXXXX - XXX</p>
	<p><a href="index">返回首页</a></p>
	</div>

</body>
</html>