<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />

<div id="iframeInside">
	<div id="titleChar">分类信息编辑</div>
    <form action="adNews_COUType_post" method="post" id="typeEdit" name="typeEdit">
   	  <p>
   	    <input name="newsType.id" id="newsType.id" type="hidden" value="${newsType.id}">
   	  </p>
   	  <p>分类ID：${newsType.id}</p>
   	  <p>分类名：
      <input name="newsType.name" type="text" id="newsType.name" size="20" maxlength="20" required aria-required="true" value="${newsType.name}">      
   	  <p id="buttonblock"><input name="submit" type="submit" value="提交"></p>
    </form>
</div>