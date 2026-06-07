package com.zihao.ZuiIT21.service;

import java.util.List;

import com.zihao.ZuiIT21.bean.News;
import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.dao.ifs.AdminDao;
import com.zihao.ZuiIT21.dao.ifs.NewsDao;
import com.zihao.ZuiIT21.dao.ifs.NewsTypeDao;
import com.zihao.ZuiIT21.service.ifs.NewsService;
import com.zihao.ZuiIT21.util.Paging;

public class NewsServiceImpl implements NewsService
{
	private NewsDao newsDao;
	private NewsTypeDao newsTypeDao;
	private AdminDao adminDao;

	@Override
	public List<News> getRecent()	//获取前10条最新新闻
	{
		return newsDao.getRecent();
	}

	@Override
	public List<News> getPopular()	//获取前10条最热新闻
	{
		return newsDao.getPopular();
	}

	@Override
	public List<News> getHomeNews(int type)	//按照类别获取最新10条新闻，type为分类id
	{
		return newsDao.getNewsByType(type, 0, 10);
	}
	
	@Override
	public News getNews(int id)	//按照id获取一条新闻
	{
		return newsDao.get(id);
	}
	
	@Override
	public List<News> getPage(String type, Paging paging)	//获取一页的新闻
	{
		if(type.equals("0"))
		{
			return newsDao.getNews(paging.startNum(), paging.getPageSize());
		}
		else
		{
			return newsDao.getNewsByType(Integer.valueOf(type), paging.startNum(), paging.getPageSize());
		}
	}
	
	@Override
	public int getSelectSize(String where, String value)	//获取搜索结果的数量(与AdminServiceImpl中的类似)
	{
		if(where.equals("") || value.equals(""))
		{
			return newsDao.getAllSize();
		}
		else
		{
			boolean isLike = false;
		
			switch (where)
			{
				case "id":
					isLike = false;
					break;
	
				case "loginName":
				case "nickName":
					isLike = true;
					break;
					
				default:
					break;
			}
			
			return newsDao.getSelectSize(where, value, isLike);
		}
	}
	
	@Override
	public List<News> getSelectPage(String where, String value, Paging paging)	//获取一页的搜索结果(与AdminServiceImpl中的类似)
	{
		if(where.equals("") || value.equals(""))
		{
			return newsDao.getNews(paging.startNum(), paging.getPageSize());
		}
		else
		{
			boolean isLike = false;
			
			switch (where)
			{
				case "id":
					isLike = false;
					break;
	
				case "title":
				case "author.name":
				case "text":
				case "type.name":
					isLike = true;
					break;
					
				default:
					break;
			}
			
			return newsDao.getSelectPage(where, value, isLike, paging.startNum(), paging.getPageSize());
		}
	}
	
	@Override
	public int getTypeSize(String type)	//获取新闻条数
	{
		if(type.equals("0"))	//如果没有指定分类
		{
			return newsDao.getAllSize();	//返回所有记录的数量
		}
		else	//如果有指定
		{
			return newsDao.getTypeSize(Integer.valueOf(type));	//返回指定类拥有的记录数量
		}
	}
	
	@Override
	public boolean createNews(News news,int authorId,int typeId)	//创建新闻
	{
		news.setAuthor(adminDao.get(authorId));
		news.setType(newsTypeDao.get(typeId));
		news.setClick(0);
		news.setLike(0);
		
		return newsDao.save(news);
	}
	
	@Override
	public boolean updateNews(News news, int typeId)	//更新新闻
	{
		int id = news.getId();
		News old = newsDao.get(id);
		old.setDate(news.getDate());
		old.setText(news.getText());
		old.setTitle(news.getTitle());
		old.setType(newsTypeDao.get(typeId));
		
		return newsDao.update(old);
	}
	
	@Override
	public boolean delete(String id)	//删除新闻
	{	
		News news = newsDao.get(Integer.valueOf(id));
		
		return newsDao.delete(news);
	}
	
	@Override
	public List<NewsType> getTypes(int count)	//获取前多少个分类  count是要获取的数量
	{
		return newsTypeDao.getTypes(0,count);
	}
	
	@Override
	public News get(String id)	//获取一条新闻
	{
		return newsDao.get(Integer.valueOf(id));
	}
	
	@Override
	public News newsAccess(String id)	//新闻访问	id是访问新闻的id
	{
		News news = newsDao.get(Integer.valueOf(id));	//获取此id的新闻
		news.setClick(news.getClick()+1);	//设置点击量+1
		news.setLike(news.getLike()+1);		//设置热度+1
		newsDao.update(news);				//保存数据
		
		return news;	//返回新闻信息
	}
	
	@Override
	public boolean addLike(String id)	//点赞 id是点赞的新闻id
	{
		News news = newsDao.get(Integer.valueOf(id));	//获取此id的新闻
		news.setLike(news.getLike()+1);					//设置热度+1
		newsDao.update(news);				//保存数据
		
		return true;
	}
	
	
	//getter和setter
	public NewsDao getNewsDao()
	{
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao)
	{
		this.newsDao = newsDao;
	}
	
	public NewsTypeDao getNewsTypeDao()
	{
		return newsTypeDao;
	}

	public void setNewsTypeDao(NewsTypeDao newsTypeDao)
	{
		this.newsTypeDao = newsTypeDao;
	}

	public AdminDao getAdminDao()
	{
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao)
	{
		this.adminDao = adminDao;
	}
}
