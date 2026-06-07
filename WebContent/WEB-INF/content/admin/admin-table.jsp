<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.zihao.ZuiIT21.enums.LoginState" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/admin_tableOperate.js"></script>
<div id="iframeInside">
	<form action="" method="get" name="AdminSelect" id="AdminSelect">
      查询方式：<select name="where">
        <option value="id" ${where=="id"?'selected="selected"':''}>按ID</option>
        <option value="loginName" ${where=="loginName"?'selected="selected"':''}>按登陆名</option>
        <option value="name" ${where=="name"?'selected="selected"':''}>按昵称</option>
      </select>
      	        关键字：
   	    <input name="value" type="search" id="value" value="${value}" size="12" maxlength="20">
	    <input type="submit" name="submit" id="submit" value="查询">
	  </form>
    <div id="tableBlock">
    <div id="tabHead">
        <table width="727" border="1" cellspacing="0">
              <tr>
                <th width="100" scope="col">管理员ID</th>
                <th width="150" scope="col">管理员名</th>
                <th width="150" scope="col">登录名</th>
                <th width="100" scope="col">类型</th>
                <th width="100" scope="col">状态</th>
                <th width="140" scope="col">操作</th>
              </tr>
        </table>
    </div>
    <div id="tabContent">
<table width="800" border="1" cellspacing="0">
	<s:iterator step="1" value="#request.list" var="admin">
      <tr>
  	    <td width="100">${admin.id}</td>
  	    <td width="150">${admin.name}</td>
  	    <td width="150">${admin.loginName}</td>
  	    <td width="100">${admin.level}</td>
  	    <td width="100">${admin.state}</td>
        <td width="140"><a href="javascript:updateState_admin(${admin.id},${admin.state==LoginState.正常?'1':'0'});">${admin.state==LoginState.正常?'封号':'解封'}</a> <a href="admin_createOrUpdate?id=${admin.id}">修改</a> <a href="javascript:delete_admin(${admin.id});">删除</a></td>
      </tr>
   </s:iterator>
</table>
	<div id="pageCode">
	<a href="admin_table?where=${request.where}&value=${request.value}&page=${paging.thisPage-1}">&lt;&lt;</a>
	 ${paging.thisPage}/${paging.maxPage} 
	 <a href="admin_table?where=${request.where}&value=${request.value}&page=${paging.thisPage+1}">&gt;&gt;</a>
	 </div>
	</div>
    </div>
</div>