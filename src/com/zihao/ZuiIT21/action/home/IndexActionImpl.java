package com.zihao.ZuiIT21.action.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zihao.ZuiIT21.action.home.ifs.IndexAction;
import com.zihao.ZuiIT21.bean.News;
import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.service.ifs.NewsService;

public class IndexActionImpl extends ActionSupport implements IndexAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 72231986325698359L;

	private NewsService newsService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();	//jsp的request

	@Override
	public String execute() throws Exception	//主页
	{
		List<News> recent = newsService.getRecent();	//获取最新新闻列表
		List<News> popular = newsService.getPopular();	//获取最热新闻列表
		List<NewsType> types = newsService.getTypes(8);	//获取分类
		List<List<News>> lists = new ArrayList<List<News>>();	//各分类新闻的集合
		
		for (NewsType newsType : types)
		{
			lists.add(newsService.getHomeNews(newsType.getId()));	//获取每个分类的列表
		}

		request.setAttribute("recent", recent);
		request.setAttribute("popular", popular);
		request.setAttribute("types", types);
		request.setAttribute("lists", lists);
		
		return "this";
	}
	
	@Override
	public String about()	//关于我们
	{
		return SUCCESS;
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
}
