package com.zihao.ZuiIT21.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zihao.ZuiIT21.action.admin.ifs.AdNewsAction;
import com.zihao.ZuiIT21.bean.Admin;
import com.zihao.ZuiIT21.bean.News;
import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.service.ifs.NewsService;
import com.zihao.ZuiIT21.service.ifs.NewsTypeService;
import com.zihao.ZuiIT21.util.Paging;

public class AdNewsActionImpl extends ActionSupport implements AdNewsAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4426002429813967582L;
	
	private NewsService newsService;
	private NewsTypeService newsTypeService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();	//jsp的request
	private HttpSession session = ServletActionContext.getRequest().getSession();	//jsp的session
	private HttpServletResponse response = ServletActionContext.getResponse();	//jsp的response
	
	private News news;
	private NewsType newsType;
	
	@Override
	public String execute() throws Exception	//新闻表
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
		
		Paging paging = new Paging(Integer.valueOf(page), 20, newsService.getSelectSize(where,value));	//分页适配器
		List<News> list = newsService.getSelectPage(where,value,paging);	//新闻列表
		
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
		request.setAttribute("where", where);
		request.setAttribute("value", value);

		return "this";
	}
	
	@Override
	public String createOrUpdate()	//创建或者更新(与AdminActionImpl中的类似)
	{
		String id = request.getParameter("id");
		
		if(id!=null)
		{
			News news = newsService.get(id);
			request.setAttribute("news", news);
		}
		else
		{
			News news = new News();
			NewsType type = new NewsType();
			type.setId(0);
			news.setType(type);
			request.setAttribute("news", news);
		}
		
		List<NewsType> typeList = newsTypeService.getAll();
		
		request.setAttribute("typeList", typeList);
		
		return SUCCESS;
	}
	
	@Override
	public String createOrUpdate_post()	//创建或者更新的提交(与AdminActionImpl中的类似)
	{
		String id = request.getParameter("news.id");
		boolean result = false;
		
		if(id.equals("0"))
		{
			Admin author = (Admin)session.getAttribute("loginAdmin");
			int typeId = Integer.valueOf(request.getParameter("typeId"));
			
			result = newsService.createNews(news,author.getId(),typeId);
		}
		else
		{
			int typeId = Integer.valueOf(request.getParameter("typeId"));
			result = newsService.updateNews(news, typeId);
		}
		
		
		response.setCharacterEncoding("gb18030");
		if(result)
		{
			try
			{	
				response.getWriter().write("<script>alert('文章发布成功');window.location.href='/ZuiIT21/admin/adNews';</script>");
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
				response.getWriter().write("<script>alert('出现异常，文章发布失败')</script>");
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
		
		if(newsService.delete(id))
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
	public String type()	//分类表
	{
		List<NewsType> list = newsTypeService.getAll();	//获取所有分类
		request.setAttribute("list", list);
		
		return SUCCESS;
	}
	
	@Override
	public String COUType()	//创建或者更新分类(与AdminActionImpl中的类似)
	{
		String id = request.getParameter("id");
		
		if(id!=null)
		{
			NewsType newsType = newsTypeService.get(id);
			request.setAttribute("newsType", newsType);
		}
		else
		{
			NewsType newsType = new NewsType();
			request.setAttribute("newsType", newsType);
		}
		
		return SUCCESS;
	}
	
	@Override
	public String COUType_post()	//创建或者删除分类提交(与AdminActionImpl中的类似)
	{
		String id = request.getParameter("newsType.id");
		boolean result = false;
		
		
		if(id.equals("0"))
		{
			result = newsTypeService.createType(newsType);
		}
		else
		{
			result = newsTypeService.updateType(newsType);
		}
		
		
		response.setCharacterEncoding("UTF-8");
		if(result)
		{
			try
			{	
				response.getWriter().write("<script>alert('信息保存成功');window.location.href='/ZuiIT21/admin/admin_type';</script>");
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
	public String deleteType()	//删除分类(ajax)
	{
		String id = request.getParameter("id");
		
		if(newsTypeService.delete(id))
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
	public NewsService getNewsService()
	{
		return newsService;
	}

	public void setNewsService(NewsService newsService)
	{
		this.newsService = newsService;
	}

	public News getNews()
	{
		return news;
	}

	public void setNews(News news)
	{
		this.news = news;
	}

	public NewsTypeService getNewsTypeService()
	{
		return newsTypeService;
	}

	public void setNewsTypeService(NewsTypeService newsTypeService)
	{
		this.newsTypeService = newsTypeService;
	}

	public NewsType getNewsType()
	{
		return newsType;
	}

	public void setNewsType(NewsType newsType)
	{
		this.newsType = newsType;
	}
	
	
}
