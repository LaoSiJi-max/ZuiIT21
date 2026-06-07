<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />

<div id="iframeInside">
	<div id="titleChar">管理员信息编辑</div>
    <form action="admin_createOrUpdate_post" method="post" id="adminEdit" name="adminEdit">
   	  <input name="admin.id" id="admin.id" type="hidden" value="${admin.id}">
   	  <p>
   	  	登录名：
   	  <input name="admin.loginName" type="text" id="admin.loginName" size="20" maxlength="20" required aria-required="true" value="${admin.loginName}">      
   	  <p>
   	  	密码：
    	  <input name="admin.password" type="password" id="admin.password" size="20" maxlength="20" ${admin.password!=null?'readonly="readonly"':''}> 
      <p>
        名称：
    	  <input name="admin.name" type="text" id="admin.name" size="20" maxlength="20" required aria-required="true" value="${admin.name}">
    	</p>
    	<p>
    	等级：
    	  <select name="admin.level" id="admin.level">
    	   	 <option value="作者" ${admin.level=="作者"?'selected="selected"':''}>作者</option>
    	   	 <option value="系统管理员" ${admin.level=="系统管理员"?'selected="selected"':''}>系统管理员</option>
             <option value="超级管理员" ${admin.level=="超级管理员"?'selected="selected"':''}>超级管理员</option>
  	      </select>
   	  </p>
        <p id="buttonblock"><input name="submit" type="submit" value="提交"></p>
    </form>
</div>