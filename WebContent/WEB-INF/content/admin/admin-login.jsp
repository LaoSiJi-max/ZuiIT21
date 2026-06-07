<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Zui IT 2后台管理系统</title>
<link rel="Shortcut Icon" href="favicon.ico" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div class="login">
        <div class="loginbox">
          <div class="loginmain" >
              <form id="login" action="admin_login_post" method="post" name="login" onsubmit="return managerLogin_submit();">
                
                <div class="loginname">用户名：<input id="admin.loginName" name="admin.loginName" type="text" size="20" maxlength="20" required aria-required="true" pattern="[A-Za-z0-9_]+"/></div>
                <div class="loginpwd">密 &nbsp;码：<input id="admin.password" name="admin.password" type="password" size="20" maxlength="20" required aria-required="true" pattern="[A-Za-z0-9\@\#\$\%\^\&\*_]+"/></div>
                <input id="btn_login" type="submit" value="" class="loginbtn"/>
                <input id="btn_reset" type="reset" value="" class="resetbtn"/>
                </form>
            </div>
        </div>
    </div>
    <div class="seereals_loading"></div>

<div style="text-align:center;">
</div>

</body>
</html>
