<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Zui IT 2</title>
<meta name="keywords" content="IT">
<meta name="description" content="IT资讯网">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/ads.js"></script>
<base target="_blank">
</head>

<body>

<div class="topBar">
  <div class="topBar_d">
      <div class="left"><a href="index">Zui IT 2</a><span class="kj"></span>
      </div>
      <div class="right">
      <s:if test="#session.loginUser==null"><a href="user_login" target="_self">登录</a> <a href="user_register" target="_self">注册</a></s:if>
	<s:else>您好！<a href="index_userCenter.jsp">${session.loginUser.nickName}</a> <a onsubmit="return confrim('是否要退出登录？');" href="user_logout">退出</a></s:else>
	  </div>
  </div>
</div>

<div class="navbar_div"><!-- 导航 -->
	
</div>
<div class="list_twidth">
     <!--left-->
      <div class="mframe mR">
      	 <div class=tm>
    	   <div class=tit><span class=tt><a href="index">网站首页</a> &gt;&gt; <a href="">${newsType.name}</a></span></div>
     	 </div>
        <div class=wrapper>
        <div class="mm ">
<div class="box2"><ul><s:iterator value="#request.list" var="news"><li><span class="dateR">[${fn:substring(news.date,0,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,50)}</a></li></s:iterator></ul></div><div class=pager><UL><LI class=p_total>${paging.thisPage }/${paging.maxPage}</LI>
  <li></li><li><a href="news?type=${newsType.id}&page=${paging.thisPage-1}"  target="_self">&#8249;</a></li><LI class=p_current> ${paging.thisPage }</LI><li><a href="news?type=${newsType.id}&page=${paging.thisPage+1}"  target="_self">&#8250;</a></li></UL></div> 
      </div>
     </div>
    </div>
    <!--right-->
	<div style="float:right; width:250px;">
    <div class=lframe>
     	   <div class="tm"> 
		       <div class="style_01_nr">分类列表</div>
			</div>
    	    <div class=wrapper>
     		  <div class=mm>
     			 <ul class=sList>
       				<li><a href="news">所有分类</a></li>
                    <s:iterator value="#request.typeList" var="type">
                    <li><a href="news?type=${type.id}">${type.name}</a></li>
                    </s:iterator>
				</ul>
             </div>
            </div>
      </div>
	</div>
</div>
<div class="footer w960">
 <div class="footer w960">
  <div class="bottom_link"><a href="index_about">关于我们</a></div>
    <div class="copyright">XXXXXXXX - XXX</div>
</div>
</body>
</html>