package com.zihao.ZuiIT21.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zihao.ZuiIT21.action.admin.ifs.AdminAction;
import com.zihao.ZuiIT21.bean.Admin;
import com.zihao.ZuiIT21.enums.LoginState;
import com.zihao.ZuiIT21.service.ifs.AdminService;
import com.zihao.ZuiIT21.util.Paging;

public class AdminActionImpl extends ActionSupport implements AdminAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8300650199560535773L;

	private AdminService adminService;
	
	private Admin admin;
	
	private HttpServletRequest request = ServletActionContext.getRequest();	//jsp的request
	private HttpSession session = ServletActionContext.getRequest().getSession();	//jsp的session
	private HttpServletResponse response = ServletActionContext.getResponse();	//jsp的response
	
	@Override
	public String execute() throws Exception	//后台主页
	{
		Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");	//获取session中的登录者信息
		int perms = -1;	//权限等级，-1为异常情况，0是作者，1是系统管理员，2是超级管理员
		
		switch (loginAdmin.getLevel())
		{
			case 作者 :
				perms = 0;
				break;
				
			case 系统管理员 :
				perms = 1;
				break;
				
			case 超级管理员 :
				perms = 2;
				break;
	
			default:
				break;
			}

		session.setAttribute("perms", perms);
		
		return "this";
	}
	
	@Override
	public String login()	//后台登录
	{
		Object loginAdmin = session.getAttribute("loginAdmin");	//获取登录者信息
		
		if(loginAdmin==null)	//如果为空就是没有登陆
		{
			return SUCCESS;	//返回登录视图
		}
		else	//如果登陆了
		{
			try
			{
				response.sendRedirect("admin");	//跳转到后台主页
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return NONE;
	}
	
	@Override
	public String login_post()	//登录提交
	{
		Admin loginAdmin = adminService.adminLogin(admin.getLoginName(),admin.getPassword());	//获取登录信息
		
		response.setCharacterEncoding("gb18030");
		if(loginAdmin!=null)	//为空就是为查询到相关信息
		{
			if(loginAdmin.getState()==LoginState.正常)	//登录为正常时
			{
				try
				{
					session.setAttribute("loginAdmin", loginAdmin);	//保存登录者信息到session
					response.sendRedirect("admin");	//跳转到后台主页	
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
					response.getWriter().write("<script>alert('该用户已被禁用');window.location.href='/ZuiIT21/admin/admin_login';</script>");	//提示后回到登录页面
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			try
			{
				response.getWriter().write("<script>alert('登录失败！请检查登录名或者密码是否有误。');window.location.href='/ZuiIT21/admin/admin_login';</script>");	//提示
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
		return NONE;
	}
	
	public String table()	//管理员表
	{
		String where = request.getParameter("where");	//查询方式
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
		
		Paging paging = new Paging(Integer.valueOf(page), 20, adminService.getSelectSize(where,value));	//分页适配器
		List<Admin> list = adminService.getSelectPage(where,value,paging);	//新闻列表
		
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
		request.setAttribute("where", where);
		request.setAttribute("value", value);

		return SUCCESS;
	}
	
	@Override
	public String stateChange()	//改变状态(ajax方法)
	{
		String id = request.getParameter("id");		//id
		String state = request.getParameter("state");//获取状态参数
		
		if(adminService.updateState(id,state))	//操作如果成功
		{
			try 
			{
				response.getWriter().write("true");	//返回true
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
				response.getWriter().write("false");	//返回false
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		return NONE;
	}
	
	@Override
	public String createOrUpdate()	//创建或者修改
	{
		String id = request.getParameter("id");	//获取id参数
		
		if(id!=null)	//如果id值为空，就是修改此id的记录
		{
			Admin admin = adminService.get(id);	//按照id获取信息
			request.setAttribute("admin", admin);
		}
		else	//如果id值不为空，就是创建新记录
		{
			Admin admin = new Admin();	//创建一个空的对象，否则视图会报错
			request.setAttribute("admin", admin);
		}
		
		return SUCCESS;
	}
	
	@Override
	public String createOrUpdate_post()	//创建或者修改提交
	{
		String id = request.getParameter("admin.id");	//获取隐藏域的值
		boolean result = false;	//结果
		
		
		if(id.equals("0"))	//如果为0就是创建
		{
			result = adminService.createAdmin(admin);
		}
		else	//不为0就是修改
		{
			result = adminService.updateAdmin(admin);
		}
		
		
		response.setCharacterEncoding("UTF-8");
		if(result)
		{
			try
			{	
				response.getWriter().write("<script>alert('信息保存成功');window.location.href='/ZuiIT21/admin/admin_table';</script>");	//提示后跳转
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
				response.getWriter().write("<script>alert('出现异常，信息提交失败')</script>");
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
		
		if(adminService.delete(id))
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
	public String logout()	//退出登录
	{
		session.setAttribute("loginAdmin", null);	//设置session中loginAdmin的值为空，以取消关联
		session.setAttribute("perms", null);	//设置session中perms的值为空，以取消关联
		
		response.setCharacterEncoding("gb18030");
		try
		{	
			response.sendRedirect("admin_login");	//跳转到登录页面
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return NONE;
	}
	
	@Override
	public String index()
	{
		return SUCCESS;
	}
	
	//getter和setter
	public AdminService getAdminService()
	{
		return adminService;
	}

	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}

	public Admin getAdmin()
	{
		return admin;
	}

	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}
	
	
}
