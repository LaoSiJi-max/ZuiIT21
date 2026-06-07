<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/admin_tableOperate.js"></script>

<div id="iframeInside">
    <div id="tableBlock">
    <div id="tabHead">
        <table width="503" border="1" cellspacing="0">
              <tr>
                <th width="118" scope="col">分类ID</th>
                <th width="200" scope="col">类别名称</th>
                <th width="150" scope="col">操作</th>
                <th width="294" scope="col">&nbsp;</th>
              </tr>
        </table>
    </div>
    <div id="tabContent">
<table width="800" border="1" cellspacing="0">
	<s:iterator value="#request.list" id="type">
      <tr>
  	    <td width="118">${type.id}</td>
        <td width="200">${type.name}</td>
        <td width="150"><a href="adNews_COUType?id=${type.id}">修改</a> <a href="javascript:delete_newsType(${type.id});">删除</a></td>
        <td width="294"></td>
      </tr>
    </s:iterator>
</table>
	<div id="pageCode"></div>
	</div>
    </div>
</div>