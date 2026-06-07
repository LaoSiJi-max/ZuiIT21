<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/admin_tableOperate.js"></script>
<div id="iframeInside">
	<div id="searchBox">
	  <form action="" method="get" name="ArticleSelect" id="ArticleSelect">
      查询方式：<select name="where">
        <option value="id" ${where=="id"?' selected="selected"':''}>按文章ID</option>
        <option value="author.name" ${where=="author.name"?' selected="selected"':''}>按作者</option>
        <option value="title" ${where=="title"?' selected="selected"':''}>按标题</option>
        <option value="text" ${where=="text"?' selected="selected"':''}>按内容</option>
        <option value="type.name" ${where=="type.name"?' selected="selected"':''}>按分类</option>
      </select>
      	        关键字：
   	    <input name="value" type="search" id="value" value="${value}" size="12" maxlength="20">
	    <input type="submit" name="submit" id="submit" value="查询">
	  </form>
	</div>
    <div id="tableBlock">
    <div id="tabHead">
        <table width="727" border="1" cellspacing="0">
              <tr>
                <th width="75" scope="col">文章ID</th>
                <th width="230" scope="col">标题</th>
                <th width="100" scope="col">作者</th>
                <th width="150" scope="col">发表时间</th>
                <th width="105" scope="col">类别</th>
                <th width="80" scope="col">操作</th>
              </tr>
        </table>
    </div>
    <div id="tabContent">
<table width="800" border="1" cellspacing="0">
	<s:iterator value="#request.list" id="news">
      <tr>
  	    <td width="75">${news.id}</td>
        <td width="230">${fn:substring(news.title,0,14)}</td>
        <td width="100">${news.author.name}</td>
        <td width="150">${fn:substring(news.date,0,10)}</td>
        <td width="105">${news.type.name}</td>
        <td width="80"><a href="adNews_createOrUpdate?id=${news.id}">修改</a> <a href="javascript:delete_news(${news.id});">删除</a></td>
      </tr>
    </s:iterator>
</table>
	<div id="pageCode">
	<a href="adNews?where=${request.where}&value=${request.value}&page=${paging.thisPage-1}">&lt;&lt;</a>
	 ${paging.thisPage}/${paging.maxPage} 
	 <a href="adNews?where=${request.where}&value=${request.value}&page=${paging.thisPage+1}">&gt;&gt;</a>
	 </div>
	</div>
    </div>
</div>