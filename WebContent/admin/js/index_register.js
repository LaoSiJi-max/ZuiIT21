// JavaScript Document

function hide_step1()
{
	document.getElementById("container1").style.display="none";
}

function close_step1()
{
	window.open("","_self").close();
}

function check_loginName()
{
	var loginName = document.getElementById("loginName").value;

	if(loginName=="")
	{
		document.getElementById("checkForLoginName").value = "0";
		document.getElementById("hintForLoginName").innerHTML = "登录名不能为空";
	}
	else if(!loginName.match("[A-Za-z0-9_]+"))
	{
		document.getElementById("checkForLoginName").value = "0";
		document.getElementById("hintForLoginName").innerHTML = "登录名不符合要求";
	}
	else
	{
		http_request = false;
	
		if (window.XMLHttpRequest) 
		{
			http_request = new XMLHttpRequest();
		} 
		else if (window.ActiveXObject) 
		{
			try
			{
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch(e)
			{
				try
				{
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e){}
				
			}
		}
		
		http_request.onreadystatechange = result_loginName;
		http_request.open('GET',"UserAjax!checkColumnRepet?columnName=u_loginName&columnValue="+loginName,true);
		http_request.send(null);

	}
}

function result_loginName()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="repet")
			{
				document.getElementById("checkForLoginName").value = "0";
				document.getElementById("hintForLoginName").innerHTML = "该登陆名已存在！";
			}
			else
			{
				document.getElementById("checkForLoginName").value = "1";
				document.getElementById("hintForLoginName").innerHTML = "该登陆名可以使用";
			}
		} 
		else 
		{
			document.getElementById("checkForLoginName").value = "0";
			alert("error!");
		}
	}
}

function check_password()
{
	if(document.getElementById("password").value!="" && document.getElementById("repassword").value!="")
	{
		if(document.getElementById("password").value!=document.getElementById("repassword").value)
		{
			document.getElementById("hintForPassword").innerHTML = "两次输入的密码不一致";	
		}
		else
		{
			document.getElementById("hintForPassword").innerHTML = "";
		}
	}
}

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
		
		if(document.getElementById("password").value!=document.getElementById("repassword").value)
		{
			ispassed = false;
		}
		
		if(!ispassed)
		{
			alert("信息填写不符要求，请修改后提交");
		}
		
		return ispassed;
	}
	else
	{
		alert("验证码输入错误");
		return false;
	}
}