// JavaScript Document
function show_infoBlock()
{
	document.getElementById("infoBlock").style.display="inline";
	document.getElementById("infoBlock_update").style.display="none";
}

function show_infoBlock_update()
{
	document.getElementById("infoBlock").style.display="none";
	document.getElementById("infoBlock_update").style.display="inline";
}

function show_signBlock()
{
	document.getElementById("signBlock").style.display="inline";
	document.getElementById("signBlock_update").style.display="none";
}

function show_signBlock_update()
{
	document.getElementById("signBlock").style.display="none";
	document.getElementById("signBlock_update").style.display="inline";
}

function show_headicon_change()
{
	document.getElementById("frame_headicon_change").style.display = "inline";
	document.getElementById("loginBackground").style.display="inline";
	document.body.style.overflow="hidden";
}

function hide_headicon_change()
{
	document.getElementById("frame_headicon_change").style.display = "none";
	document.getElementById("loginBackground").style.display="none";
	document.body.style.overflow="auto";
}

function headicon_chose(choseicon)
{
	document.getElementById("lastchoseicon").value = document.getElementById("choseicon").value;
	document.getElementById("choseicon").value = choseicon.id;
	
	document.getElementById(choseicon.id).style.border = "medium outset rgba(0,0,255,1)";
	document.getElementById(document.getElementById("lastchoseicon").value).style.border = "thin outset rgba(0,0,255,1)";
}

function headicon_submit()
{
	if(document.getElementById("choseicon").value=="-1")
	{
		alert("请选择一个头像");
		return false;
	}
	else
	{
		return true;
	}
}

function checkName()
{
	var name = document.getElementById("name").value;
	
	if(name==document.getElementById("oldName").value)
	{
		document.getElementById("checkForName").value = "1";
		document.getElementById("hintForName").innerHTML = " 用户名只能修改一次";
	}
	else if(name=="")
	{
		document.getElementById("checkForName").value = "0";
		document.getElementById("hintForName").innerHTML = " 用户名不能为空";
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
	
		var urlname = encodeURI(encodeURI(name));
		
		http_request.onreadystatechange = checkName_result;
		http_request.open('GET',"UserAjax!checkColumnRepet?columnName=u_name&columnValue="+urlname,true);
		http_request.send(null);
	}
}

function checkName_result()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="repet")
			{
				document.getElementById("checkForName").value = "0";
				document.getElementById("hintForName").innerHTML = " 该用户名已存在！";
			}
			else
			{
				document.getElementById("checkForName").value = "1";
				document.getElementById("hintForName").innerHTML = " 该用户名可以使用";
			}
		} 
		else 
		{
			document.getElementById("checkForName").value = "0";
			alert("error!");
		}
	}
}

function check_userInfo_update()
{
	if(document.getElementById("checkForName").value=="1")
	{
		return true;
	}
	else
	{
		alert("信息填写不符要求，请修改后提交");
		return false;
	}
}

function show_updatePassword()
{
	document.getElementById("frame_updatePassword").style.display = "inline";
	document.getElementById("loginBackground").style.display="inline";
	document.body.style.overflow="hidden";
}

function hide_updatePassword()
{
	document.getElementById("frame_updatePassword").style.display = "none";
	document.getElementById("loginBackground").style.display="none";
	document.body.style.overflow="auto";
}

function updatePassword_submit()
{
	var oldPassword = document.getElementById("oldPassword").value;
	var newPassword = document.getElementById("newPassword").value;
	var reNewPassword = document.getElementById("reNewPassword").value;
	
	if(oldPassword=="" || newPassword=="" || reNewPassword=="")
	{
		alert("输入不能为空");
		return false;
	}
	if(newPassword!=reNewPassword)
	{
		alert("两次密码不一致");
		return false;
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
			
		http_request.onreadystatechange = updatePassword_submit_result;
		http_request.open('GET',"UserAjax!checkPassword?oldPassword="+oldPassword+"&newPassword="+newPassword,false);
		http_request.send(null);
		
		return updatePassword_submit_result();
	}
}

function updatePassword_submit_result()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="right")
			{
				alert("密码修改成功");
				return true
			}
			else if(http_request.responseText=="notright")
			{
				alert("原始密码不正确，修改失败");
				return false;
			}
			else
			{
				alert("验证失败");
				return false;
			}
		} 
		else 
		{
			alert("error!");
			return false;
		}
	}
}