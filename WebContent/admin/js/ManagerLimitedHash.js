// JavaScript Document

function LimitedHash(needLevel)
{
	var level = document.getElementById("userLevel").value;
	
	if(level>=needLevel)
	{
		return true;
	}
	else
	{
		alert("您没有此项操作权限");
		return false;
	}
}