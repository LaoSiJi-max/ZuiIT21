<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Zui IT 2 后台管理系统</title>
<link rel="Shortcut Icon" href="favicon.ico" />
<link href="css/main_css.css" rel="stylesheet" type="text/css" />
<link href="css/iconfont.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/jquery.treeview.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.2.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>

<!--<script src="js/lib/jquery.js" type="text/javascript"></script>-->
<script src="js/lib/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript" src="js/demo.js"></script>

</head>

<body onload="getDate01()">
    <div id="top">
		<div id="top_logo">
			<img alt="logo" src="images/logo.png" width="65" height="65" style="vertical-align:middle;">
            <span>Zui IT 2 后台管理系统</span>
		</div>
		<div id="top_links">
			
			<div id="top_close">
            	<a class="icon iconfont" href="admin_logout" onclick="return confirm('您确定要退出本系统吗？');" target="_parent">&#xe619;</a>
            	<img src="images/admin.png" alt="" /><span>${session.loginAdmin.name}</span>
				
			</div>
            <div id="top_op"></div>
		</div>
	</div>
    <div class="foot">XXXXXXXX - XXX</div>
    <!-- side menu start -->
    <script>
    	function change(){
			document.getElementById('lit').style.color = "#ff0000";	
		}
    </script>
	<div id="side">
		<div id="left_menu">
 				<div class="www360buy" style="margin:0 auto">
		<div class="hd">
			<ul>
				<div class="picScroll-top" id="TabPage2">
                <div class="hd2">
                    
                    
                </div>
                <div class="bd2">
                    <ul class="picList" id="lit" onclick="change();">

                    </ul>
                </div>
            </div>
    
            <script type="text/javascript">
             jQuery(".picScroll-top").slide({titCell:".hd2 ul",mainCell:".bd2 ul",autoPage:true,effect:"top",autoPlay:false,vis:6,trigger:"click"});
			 
            </script>
			</ul>
		</div>
        <div class="gncd">功能菜单</div>
		<div class="bd">
				<ul class="lh">
					<!--系统管理-->
                  <div id="left_main_nr">
                    <ul id="browser" class="filetree">
                    	<s:if test="#session.perms>=0">
                        <li><span class="folder">文章管理</span>
                            <ul>
                                <li><span class="file"><a href="adNews_createOrUpdate" target="right">文章发布</a></span></li>
                                <li><span class="file"><a href="adNews" target="right">文章信息管理</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                        <s:if test="#session.perms>=1">
                        <li><span class="folder">用户管理</span>
                            <ul>
                                <li><span class="file"><a href="adUser" target="right">用户信息管理</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                        <s:if test="#session.perms>=2">
                        <li><span class="folder">管理员管理</span>
                            <ul>
                                <li><span class="file"><a href="admin_table" target="right">管理员信息管理</a></span></li>
                                <li><span class="file"><a href="admin_createOrUpdate" target="right">新建管理员</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                        <s:if test="#session.perms>=1">
                        <li><span class="folder">系统管理</span>
                            <ul>
                                <li><span class="file"><a href="adNews_type" target="right">分类信息管理</a></span></li>
                                <li><span class="file"><a href="adNews_COUType" target="right">新建分类</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                    </ul>
                </div>
						
				</ul>
                
		</div>
	</div>
	<script type="text/javascript">jQuery(".www360buy").slide({delayTime:0 });</script>


			
			
		 </div>
		 
	</div>
    <!-- side menu start -->
    <!--时间js代码-->
    <script>
    	function  getDate01(){
			var time = new Date();
			document.getElementById("day_day").innerHTML =  time.getFullYear()
    +"年"+(time.getMonth()+1)+"月"+time.getDate()
    +"日"+time.getHours()+"时"+time.getMinutes()
    +"分";
		}
    </script>
    <div id="top_nav">
    	<div class="time">
        	<i class="icon iconfont">&#xe61a; 当前时间：</i>
			<span id="day_day"></span>
        </div>
	</div>
    <div id="main">
      	<iframe name="right" id="rightMain" src="admin_index" frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true"/>
    </div>
    <div style="text-align:center;">
</div>

</body>
</html>


