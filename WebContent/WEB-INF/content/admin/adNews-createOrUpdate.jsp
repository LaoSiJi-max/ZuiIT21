<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="news.text"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<div id="iframeInside">
	<div id="titleChar">新闻编辑</div>
    <form action="adNews_createOrUpdate_post" method="post" id="articleIssue" name="articleIssue">
   	  <input name="news.id" id="news.id" type="hidden" value="${news.id}">
   	  <p>
   	  	标题：
    	  <input name="news.title" type="text" id="news.title" size="40" maxlength="50" required aria-required="true" value="${news.title}">
    	</p>
    	<p>
    	分类：
    	  <select name="typeId" id="typeId">
    	  	<s:iterator value="#request.typeList" var="type">
    	   	 <option value="${type.id}" ${news.type.id==type.id?'selected="selected"':''}>${type.name}</option>
    	    </s:iterator>
  	      </select>
    	发布时间：
          <input name="news.date" type="datetime-local" id="news.date" size="30" maxlength="30" value="${news.date}">
   	  </p>
      <p>
    	  正文：<br/>
          <textarea id="news.text" name="news.text"  cols="100" style="visibility:hidden;">${news.text}</textarea>
      </p>
        <p id="buttonblock"><input name="submit" type="submit" value="提交"></p>
    </form>
</div>