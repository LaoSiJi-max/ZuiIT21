// 验证码

function printVCode()
{
	//随机生成验证码实际值
	var VCodeValue = createValue();
	
	//获取网页上的画布
	var c = document.getElementById("VCodeImage");
	var cxt = c.getContext("2d");
	
	//清空画布
	cxt.clearRect(0,0,100,50);
	
	//画底色
	cxt.fillStyle = "rgb(255,255,255)";
	cxt.fillRect(0,0,100,50);
	
	//随机生成颜色
	var r = createRandomNum(1,255);
	var g = createRandomNum(1,255);
	var b = createRandomNum(1,255);
	cxt.strokeStyle = "rgb("+r+","+g+","+b+")";
	
	//画出验证码图
	cxt.font = "36px sans-serif";
	cxt.strokeText(VCodeValue,8,37);
	
	//添加3个线条
	cxt.beginPath();
	
	cxt.moveTo(0,createRandomNum(0,50));
	cxt.bezierCurveTo(createRandomNum(10,40),createRandomNum(10,40),createRandomNum(60,90),createRandomNum(10,40),150,createRandomNum(0,80));
	cxt.stroke();
	
	cxt.moveTo(0,createRandomNum(0,50));
	cxt.bezierCurveTo(createRandomNum(10,40),createRandomNum(10,40),createRandomNum(60,90),createRandomNum(10,40),150,createRandomNum(0,80));
	cxt.stroke();
	
	cxt.moveTo(0,createRandomNum(0,50));
	cxt.bezierCurveTo(createRandomNum(10,40),createRandomNum(10,40),createRandomNum(60,90),createRandomNum(10,40),150,createRandomNum(0,80));
	cxt.stroke();
	
	cxt.closePath();
	
	//设置验证码的实际 值
	document.getElementById("VCodeValue").value = VCodeValue;
}

function createValue()
{
	var VCodeValue = "";
	var charSet = new Array('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
	
	for(var i=0;i<=3;i++)
	{
		VCodeValue += charSet[createRandomNum(0,61)];
	}
	
	return VCodeValue;
}

function createRandomNum(min,max)
{
	return Math.floor(Math.random()*(max-min+1)+min);
}