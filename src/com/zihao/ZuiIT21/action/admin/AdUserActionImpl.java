package com.zihao.ZuiIT21.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zihao.ZuiIT21.action.admin.ifs.AdUserAction;
import com.zihao.ZuiIT21.bean.User;
import com.zihao.ZuiIT21.service.ifs.UserService;
import com.zihao.ZuiIT21.util.Paging;

public class AdUserActionImpl extends ActionSupport implements AdUserAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 72619006547583608L;

	private UserService userService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();	//jsp的request
	private HttpServletResponse response = ServletActionContext.getResponse();	//jsp的response
	
	@Override
	public String execute() throws Exception	//用户表
	{
		String where = request.getParameter("where");	//查询条件
		String value = request.getParameter("value");	//关键字
		String page = request.getParameter("page");		//页码
		
		if(page==null)
		{
			page = "1";
		}
		
		if(where==null)
		{
			where="";
		}
		
		if(value==null)
		{
			value="";
		}
		
		Paging paging = new Paging(Integer.valueOf(page), 20,userService.getSelectSize(where,value));	//分页适配器
		List<User> list = userService.getSelectPage(where,value,paging);	//用户列表
		
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
		request.setAttribute("where", where);
		request.setAttribute("value", value);

		
		return "this";
	}
	
	@Override
	public String stateChange()	//修改登录状态
	{
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		
		if(userService.updateState(id,state))
		{
			try 
			{
				response.getWriter().write("true");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				response.getWriter().write("false");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		return NONE;
	}
	
	@Override
	public String delete()	//删除(ajax)
	{
		String id = request.getParameter("id");
		
		if(userService.delete(id))
		{
			try
			{
				response.getWriter().write("true");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				response.getWriter().write("false");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return NONE;
	}

	//getter和setter
	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
}
