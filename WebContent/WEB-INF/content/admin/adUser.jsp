<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.zihao.ZuiIT21.enums.LoginState" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/admin_tableOperate.js"></script>
<div id="iframeInside">
	<div id="searchBox">
	  <form action="" method="get" name="UserSelect" id="UserSelect">
      查询方式：<select name="where">
        <option value="id" ${where=="id"?' selected="selected"':''}>按ID</option>
        <option value="loginName" ${where=="loginName"?' selected="selected"':''}>按登陆名</option>
        <option value="nickName" ${where=="nickName"?' selected="selected"':''}>按昵称</option>
      </select>
      	        关键字：
   	    <input name="value" type="search" id="value" value="${value}" size="12" maxlength="20">
	    <input type="submit" name="submit" id="submit" value="查询">
	  </form>
	</div>
    <div id="tableBlock">
    <div id="tabHead">
        <table width="699" border="1" cellspacing="0">
              <tr>
                <th width="100" scope="col">用户ID</th>
                <th width="150" scope="col">登录名</th>
                <th width="150" scope="col">用户名</th>
                <th width="150" scope="col">联系电话</th>
                <th width="46" scope="col">状态</th>
                <th width="150" scope="col">操作</th>
              </tr>
        </table>
    </div>
    <div id="tabContent">
<table width="800" border="1" cellspacing="0">
	<s:iterator value="#request.list" var="user">
      <tr>
  	    <td width="100">${user.id}</td>
        <td width="150">${user.loginName}</td>
        <td width="150">${user.nickName}</td>
        <td width="150">${user.phone}</td>
        <td width="46">${user.state}</td>
        <td width="150"><a href="javascript:updateState_user(${user.id},${user.state==LoginState.正常?'1':'0'});">${user.state==LoginState.正常?'封号':'解封'}</a> <a href="javascript:delete_user(${user.id});">删除</a></td>
      </tr>
   </s:iterator>
</table>
	<div id="pageCode">
	<a href="adUser?where=${request.where}&value=${request.value}&page=${paging.thisPage-1}">&lt;&lt;</a>
	 ${paging.thisPage}/${paging.maxPage} 
	 <a href="adUser?where=${request.where}&value=${request.value}&page=${paging.thisPage+1}">&gt;&gt;</a>
	 </div>
	</div>
    </div>
</div>

<!-- 提示窗 -->
<div id="Frame_hint" class="Frame_hint">
	删除成功！
</div>
<!-- ----- -->