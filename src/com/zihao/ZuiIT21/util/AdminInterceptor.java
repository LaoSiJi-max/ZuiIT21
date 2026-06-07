package com.zihao.ZuiIT21.util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//ºóÌ¨µÇÂ¼µÄÀ¹½ØÆ÷
public class AdminInterceptor extends MethodFilterInterceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4563941001625431167L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception
	{
		Object loginAdmin = ServletActionContext.getRequest().getSession().getAttribute("loginAdmin");
		
		if(loginAdmin!=null)
		{
			return arg0.invoke();
		}
		
		return Action.LOGIN;
	}

}
