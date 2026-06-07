package com.zihao.ZuiIT21.action.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zihao.ZuiIT21.action.home.ifs.NewsAction;
import com.zihao.ZuiIT21.bean.News;
import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.service.ifs.NewsService;
import com.zihao.ZuiIT21.service.ifs.NewsTypeService;
import com.zihao.ZuiIT21.util.Paging;

public class NewsActionImpl extends ActionSupport implements NewsAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4881302048528871315L;
	
	private NewsService newsService;
	private NewsTypeService newsTypeService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();	//jsp的request
	private HttpServletResponse response = ServletActionContext.getResponse();	//jsp的response

	@Override
	public String execute() throws Exception	//新闻列表
	{
		String type = request.getParameter("type");	//分类
		String page = request.getParameter("page");	//页码
		
		if(type==null)
		{
			type = "0";
		}
		
		if(page==null)
		{
			page = "1";
		}
		
		Paging paging = new Paging(Integer.valueOf(page), 15, newsService.getTypeSize(type));	//分页适配器
		List<News> list = newsService.getPage(type, paging);	//获取一页的新闻
		NewsType newsType = newsTypeService.getType(type);		//获取当前的分类
		List<NewsType> typeList = newsTypeService.getAll();		//获取所有分类
		
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
		request.setAttribute("newsType", newsType);
		request.setAttribute("typeList", typeList);
		
		return "this";
	}

	@Override
	public String article()	//文章页
	{
		String id = request.getParameter("id");	//id
		
		News news = newsService.newsAccess(id);	//新闻访问的方法
		List<NewsType> typeList = newsTypeService.getAll();	//所有分类列表
		
		request.setAttribute("news", news);
		request.setAttribute("typeList", typeList);
		
		return SUCCESS;
	}
	
	@Override
	public String like()	//点赞
	{
		String id = request.getParameter("id");
		
		newsService.addLike(id);	//点赞的方法

		try 
		{
			response.sendRedirect("news_article?id="+id);	//完成后返回文章页
		} catch (IOException e)
		{
			e.printStackTrace();
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

	public NewsTypeService getNewsTypeService()
	{
		return newsTypeService;
	}

	public void setNewsTypeService(NewsTypeService newsTypeService)
	{
		this.newsTypeService = newsTypeService;
	}
	
}
