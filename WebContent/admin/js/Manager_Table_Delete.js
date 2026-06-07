// JavaScript Document

function click_delete_ArticleComment(id)
{
	if(confirm("确认要删除吗？"))
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
			
		http_request.onreadystatechange = result_click_delete;
		http_request.open('GET',"ArticleCommentAjax!doDelete?id="+id,true);
		http_request.send(null);
	}
}

function click_delete_Article(id)
{
	if(confirm("确认要删除吗？"))
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
			
		http_request.onreadystatechange = result_click_delete;
		http_request.open('GET',"ArticleAjax!doDelete?id="+id,true);
		http_request.send(null);
	}
}

function click_delete_software(id)
{
	if(confirm("确认要删除吗？"))
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
			
		http_request.onreadystatechange = result_click_delete;
		http_request.open('GET',"SoftwareAjax!doDelete?id="+id,true);
		http_request.send(null);
	}
}

function click_delete_admin(id)
{
	if(confirm("确认要删除吗？"))
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
			
		http_request.onreadystatechange = result_click_delete;
		http_request.open('GET',"AdministratorAjax!doDelete?id="+id,true);
		http_request.send(null);
	}
}

function result_click_delete()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="deleteSuccess")
			{
				document.getElementById("Frame_hint").style.display = "inline";
				location.reload(true);
			}
			else if(http_request.responseText=="levelNotEnough")
			{
				alert("权限不足，无法删除数据");
			}
			else
			{
				alert("发生异常，删除数据失败");
			}
		} 
		else 
		{
			alert("error!");
		}
	}
}

//禁用管理员
function click_enclose_admin(id)
{
	if(confirm("确认要禁用该管理员吗？"))
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
			
		http_request.onreadystatechange = result_click_enclose_admin;
		http_request.open('GET',"AdministratorAjax!doEnclose?id="+id,false);
		http_request.send(null);
	}
}

function result_click_enclose_admin()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="encloseSuccess")
			{
				alert("该账户已经被禁用");
				location.reload(true);
			}
			else if(http_request.responseText=="levelNotEnough")
			{
				alert("权限不足，您无法禁用该账户");
			}
			else
			{
				alert("发生异常，操作失败");
			}
		} 
		else 
		{
			alert("error!");
		}
	}
}

//启用管理员
function click_using_admin(id)
{
	if(confirm("确认要启用该管理员吗？"))
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
			
		http_request.onreadystatechange = result_click_using_admin;
		http_request.open('GET',"AdministratorAjax!doUsing?id="+id,false);
		http_request.send(null);
	}
}

function result_click_using_admin()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="usingSuccess")
			{
				alert("该账户已经被启用");
				location.reload(true);
			}
			else if(http_request.responseText=="levelNotEnough")
			{
				alert("权限不足，您无法启用该账户");
			}
			else
			{
				alert("发生异常，操作失败");
			}
		} 
		else 
		{
			alert("error!");
		}
	}
}

//禁用用户
function click_enclose_user(id)
{
	if(confirm("确认要封停该用户吗？"))
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
			
		http_request.onreadystatechange = result_click_enclose_user;
		http_request.open('GET',"UserAjax!doEnclose?id="+id,false);
		http_request.send(null);
	}
}

function result_click_enclose_user()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="encloseSuccess")
			{
				alert("该账户已经被封停");
				location.reload(true);
			}
			else if(http_request.responseText=="levelNotEnough")
			{
				alert("权限不足，您无法禁用该账户");
			}
			else
			{
				alert("发生异常，操作失败");
			}
		} 
		else 
		{
			alert("error!");
		}
	}
}

//启用用户
function click_using_user(id)
{
	if(confirm("确认要解封该用户吗？"))
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
			
		http_request.onreadystatechange = result_click_using_user;
		http_request.open('GET',"UserAjax!doUsing?id="+id,false);
		http_request.send(null);
	}
}

function result_click_using_user()
{
	if (http_request.readyState == 4)
	{
		if (http_request.status == 200) 
		{
			if(http_request.responseText=="usingSuccess")
			{
				alert("该账户已经被解封");
				location.reload(true);
			}
			else if(http_request.responseText=="levelNotEnough")
			{
				alert("权限不足，您无法启用该账户");
			}
			else
			{
				alert("发生异常，操作失败");
			}
		} 
		else 
		{
			alert("error!");
		}
	}
}