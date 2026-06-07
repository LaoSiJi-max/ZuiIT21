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
      <div class="left"><a href="index" target="_self">Zui IT 2</a><span class="kj"></span>
      </div>
      <div class="right">
      <s:if test="#session.loginUser==null"><a href="user_login" target="_self">登录</a> <a href="user_register" target="_self">注册</a></s:if>
	<s:else>您好！<a href="user">${session.loginUser.nickName}</a> <a onsubmit="return confrim('是否要退出登录？');" href="user_logout" target="_self">退出</a></s:else>
	  </div>
  </div>
</div>

<div class="navbar_div"><!-- 导航 -->
	<div id=navbar>
		<div class=l></div>
		<div class=r></div>
		<div class=m><a class="first" href="index">网站首页</a>
        <s:iterator value="#request.types" id="type"><a href="news?type=${type.id}">${type.name}</a></s:iterator>
		</div>
     </div>
</div>
<div class="w960 div_body1">
  <div class="fr right000">
    <div class="right biankuang"> 
        <div class="style_01_ht">
		     <div class="style_01_nr">热点资讯</div>
		</div>
        <div class="nr_bk_02 box3">
           <UL>
            <s:iterator value="#request.popular" id="news">
       		 <li><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,15)}</a></li>
       		</s:iterator>
            </UL>
        </div>   
    </div>
    <div class="right biankuang"> 
        <div class="style_01_ht">
		     <div class="style_01_nr">文章推荐</div>
		</div>
        <div class="nr_bk_02 box3">
           <UL>
            <s:iterator value="#request.lists[0]" id="news">
       		 <li><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,15)}</a></li>
       		</s:iterator>
           </UL>
        </div>   
    </div>


    </div>
    

<div class="w730 fl div_body1">
<div class="div_body1">
	
	<div class="mid fl biankuang">  
        <div class="nr_bk_03">
          <div class="style_02_ht">

            <div class="style_03_nr">最新资讯</div>
          </div>
          <div class="bd2 box2">
			<UL>
            <s:iterator value="#request.recent" id="news">
              <li><span>[${fn:substring(news.date,0,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${news.title}</a></li>
            </s:iterator>
            </UL>
          </div>       
        </div>    
	</div>
	     
    
</div>


<div class="w960 div_body2">
   <div class="list2 biankuang fl">
      <div class="style_02_ht">
      <div class="fr gengduo"><a href="news?type=${types[0].id}">更多>></a></div>
		 <div class="style_03_nr">${types[0].name}</div>
	  </div>
       <div class="nr_bk_02 box2 summary_foot">
            <UL>
            <s:iterator value="#request.lists[0]" id="news">
              <li><span>[${fn:substring(news.date,5,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,20)}</a></li>
            </s:iterator>
            </UL>
        </div>   
   </div>
   

   <div class="list2 biankuang fl">
      <div class="style_02_ht">
      <div class="fr gengduo"><a href="news?type=${types[1].id}">更多>></a></div>
		 <div class="style_03_nr">${types[1].name}</div>
	  </div>
       
       <div class="nr_bk_02 box2 summary_foot">
            <UL>
              <s:iterator value="#request.lists[1]" id="news">
              <li><span>[${fn:substring(news.date,5,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,20)}</a></li>
            </s:iterator>
            </UL>
        </div>   
   </div>
   
</div>
<div class="w960 div_body2">
   <div class="list2 biankuang fl">
      <div class="style_02_ht">
      <div class="fr gengduo"><a href="news?type=${types[2].id}">更多>></a></div>
		 <div class="style_03_nr">${types[2].name}</div>
	  </div>
       
       <div class="nr_bk_02 box2 summary_foot">
            <UL>
              <s:iterator value="#request.lists[2]" id="news">
              <li><span>[${fn:substring(news.date,5,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,20)}</a></li>
            </s:iterator>
            </UL>
        </div>   
   </div>
   

   <div class="list2 biankuang fl">
      <div class="style_02_ht">
      <div class="fr gengduo"><a href="news?type=${types[3].id}">更多>></a></div>
		 <div class="style_03_nr">${types[3].name}</div>
	  </div>
       <div class="nr_bk_02 box2 summary_foot">
            <UL>
              <s:iterator value="#request.lists[3]" id="news">
              <li><span>[${fn:substring(news.date,5,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,20)}</a></li>
            </s:iterator>
            </UL>
        </div>   
   </div>
   
</div>
<div class="w960 div_body2">
   <div class="list2 biankuang fl">
      <div class="style_02_ht">
      <div class="fr gengduo"><<a href="news?type=${types[4].id}">更多>></a></div>
		 <div class="style_03_nr">${types[4].name}</div>
	  </div>
       <div class="nr_bk_02 box2 summary_foot">
            <UL>
              <s:iterator value="#request.lists[4]" id="news">
              <li><span>[${fn:substring(news.date,5,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,20)}</a></li>
            </s:iterator>
            </UL>
        </div>   
   </div>
   

   <div class="list2 biankuang fl">
      <div class="style_02_ht">
      <div class="fr gengduo"><a href="news?type=${types[5].id}">更多>></a></div>
		 <div class="style_03_nr">${types[5].name}</div>
	  </div>

       <div class="nr_bk_02 box2 summary_foot">
            <UL>
              <s:iterator value="#request.lists[5]" id="news">
              <li><span>[${fn:substring(news.date,5,10)}]</span><a href="news_article?id=${news.id}" target="_blank">${fn:substring(news.title,0,20)}</a></li>
            </s:iterator>
            </UL>
        </div>   
   </div>
   
</div>

</div>
</div>
<div class="footer w960">
  <div class="bottom_link"><a href="index_about">关于我们</a></div>
    <div class="copyright">XXXXXXXX - XXX</div>
</div>
</body>
</html>