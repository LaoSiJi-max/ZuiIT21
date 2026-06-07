package com.zihao.ZuiIT21.action.home;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zihao.ZuiIT21.action.home.ifs.UserAction;
import com.zihao.ZuiIT21.bean.User;
import com.zihao.ZuiIT21.enums.LoginState;
import com.zihao.ZuiIT21.service.ifs.UserService;

public class UserActionImpl extends ActionSupport implements UserAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1264129340455331610L;

	private UserService userService;
	
	private User user;
	
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	@Override
	public String execute() throws Exception	//个人中心
	{
		return "this";
	}
	
	@Override
	public String register()	//注册
	{
		return SUCCESS;
	}
	
	@Override
	public String register_post()	//注册提交
	{
		if(userService.userRegister(user))
		{
			response.setCharacterEncoding("gb18030");
			try
			{
				response.getWriter().write("<script>alert('注册成功！');window.location.href='/ZuiIT21/home/index';</script>");
				return NONE;
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
				response.getWriter().write("<script>alert('注册失败！系统出现异常。');window.location.href='/ZuiIT21/home/user_register';</script>");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return NONE;
		}
		return NONE;
	}
	
	@Override
	public String login()	//登录
	{
		Object loginUser = session.getAttribute("loginUser");	//获取session中的loginUser,就是登陆用户的信息
		
		if(loginUser==null)	//如果loginUser是空的，就是没有登陆
		{
			return SUCCESS;	//返回登陆视图
		}
		else	//如果登陆了
		{
			try
			{
				response.sendRedirect("index");	//返回主页
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
		User loginUser = userService.getUserLogin(user.getLoginName(),user.getPassword());	//获取登录的信息
		
		if(loginUser!=null)	//如果loginUser是空的，就是没有登陆
		{
			response.setCharacterEncoding("gb18030");
			if(loginUser.getState()==LoginState.正常)	//如果状态为正常
			{
				session.setAttribute("loginUser", loginUser);	//把用户信息保存到session
				try
				{
					response.sendRedirect("index");	//跳到主页
					return NONE;
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
					response.getWriter().write("<script>alert('该用户被禁用');window.location.href='/ZuiIT21/home/user_login';</script>");	//弹窗提示
					return NONE;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			return NONE;
		}
		return NONE;
	}
	
	@Override
	public String logout()	//退出登陆
	{
		session.setAttribute("loginUser", null);	//把loginUser设置为null，以清空loginUser的关联
		try 
		{
			response.sendRedirect("index");	//跳到主页
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return NONE;
	}
	
	@Override
	public String updateName()	//修改名字
	{
		User loginUser = (User)session.getAttribute("loginUser");
		
		loginUser = userService.updateName(loginUser.getId(),user.getNickName());
		session.setAttribute("loginUser", loginUser);
		try
		{
			response.sendRedirect("user#horizontalTab1");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return NONE;
	}
	
	@Override
	public String updateUser()	//修改资料
	{
		User loginUser = (User)session.getAttribute("loginUser");
		
		loginUser = userService.updateUser(loginUser.getId(), user);
		session.setAttribute("loginUser", loginUser);
		try
		{
			response.sendRedirect("user#horizontalTab2");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
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

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
}