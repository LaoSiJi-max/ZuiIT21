// JavaScript Document

function check_loginInfo_submit()
{
	var ispassed = true;
	var VCode = document.getElementById("VCode").value;
	var VCodeValue = document.getElementById("VCodeValue").value;
	
	if(VCode.toLowerCase()==VCodeValue.toLowerCase())
	{
		if(document.getElementById("checkForLoginName").value!="1")
		{
			ispassed = false;
		}
		
		if(document.getElementById("user.password").value!=document.getElementById("password2").value)
		{
			ispassed = false;
			alert("两次输入的密码不一致");
		}
		
		return ispassed;
	}
	else
	{
		alert("验证码输入错误");
		return false;
	}
}