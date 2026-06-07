/**
 * 
 */
	function delete_news(id)
	{
		if(confirm("是否要删除？"))
		{
			$.ajax({
			    url:'admin/adNews_delete',
			    type:'POST',
			    async:false,
			    data:
			    {
			        'id':id
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr)
			    {},
			    success:function(data,textStatus,jqXHR){
			        if(data=='true')
			        {
			        	alert('删除成功');
			        	location.reload();
			        }
			        else
			        {
			        	alert('删除记录失败');
			       	}
			    },
			    error:function(xhr,textStatus){
			    	alert('出现错误');
			    },
			    complete:function(){}
			})
		}
	}
	
	function delete_user(id)
	{
		if(confirm("是否要删除？"))
		{
			$.ajax({
			    url:'admin/adUser_delete',
			    type:'POST',
			    async:false,
			    data:
			    {
			        'id':id
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr)
			    {},
			    success:function(data,textStatus,jqXHR){
			        if(data=='true')
			        {
			        	alert('删除成功');
			        	location.reload();
			        }
			        else
			        {
			        	alert('删除记录失败');
			       	}
			    },
			    error:function(xhr,textStatus){
			    	alert('出现错误');
			    },
			    complete:function(){}
			})
		}
	}
	
	function delete_admin(id)
	{
		if(confirm("是否要删除？"))
		{
			$.ajax({
			    url:'admin/admin_delete',
			    type:'POST',
			    async:false,
			    data:
			    {
			        'id':id
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr)
			    {},
			    success:function(data,textStatus,jqXHR){
			        if(data=='true')
			        {
			        	alert('删除成功');
			        	location.reload();
			        }
			        else
			        {
			        	alert('删除记录失败');
			       	}
			    },
			    error:function(xhr,textStatus){
			    	alert('出现错误');
			    },
			    complete:function(){}
			})
		}
	}
	
	function delete_newsType(id)
	{
		if(confirm("是否要删除？"))
		{
			$.ajax({
			    url:'admin/adNews_deleteType',
			    type:'POST',
			    async:false,
			    data:
			    {
			        'id':id
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr)
			    {},
			    success:function(data,textStatus,jqXHR){
			        if(data=='true')
			        {
			        	alert('删除成功');
			        	location.reload();
			        }
			        else
			        {
			        	alert('删除记录失败');
			       	}
			    },
			    error:function(xhr,textStatus){
			    	alert('出现错误');
			    },
			    complete:function(){}
			})
		}
	}
	
	function updateState_user(id,state)
	{
		if(confirm("是否要更改？"))
		{
			$.ajax({
			    url:'admin/adUser_stateChange',
			    type:'POST',
			    async:false,
			    data:
			    {
			        'id':id,
			        'state':state
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr)
			    {},
			    success:function(data,textStatus,jqXHR){
			        if(data=='true')
			        {
			        	alert('状态更改成功');
			        	location.reload();
			        }
			        else
			        {
			        	alert('操作失败');
			       	}
			    },
			    error:function(xhr,textStatus){
			    	alert('出现错误');
			    },
			    complete:function(){}
			})
		}
	}
	
	function updateState_admin(id,state)
	{
		if(confirm("是否要更改？"))
		{
			$.ajax({
			    url:'admin/admin_stateChange',
			    type:'POST',
			    async:false,
			    data:
			    {
			        'id':id,
			        'state':state
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    beforeSend:function(xhr)
			    {},
			    success:function(data,textStatus,jqXHR){
			        if(data=='true')
			        {
			        	alert('状态更改成功');
			        	location.reload();
			        }
			        else
			        {
			        	alert('操作失败');
			       	}
			    },
			    error:function(xhr,textStatus){
			    	alert('出现错误');
			    },
			    complete:function(){}
			})
		}
	}