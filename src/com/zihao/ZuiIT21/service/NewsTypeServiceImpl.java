package com.zihao.ZuiIT21.service;

import java.util.List;

import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.dao.ifs.NewsTypeDao;
import com.zihao.ZuiIT21.service.ifs.NewsTypeService;

public class NewsTypeServiceImpl implements NewsTypeService
{
	private NewsTypeDao newsTypeDao;

	@Override
	public NewsType getType(String type)	//获取分类
	{
		if(type.equals("0"))
		{
			NewsType newsType = new NewsType();
			newsType.setId(0);
			newsType.setName("所有分类");
			
			return newsType;
		}
		else
		{
			return newsTypeDao.get(Integer.valueOf(type));
		}
	}

	@Override
	public List<NewsType> getAll()	//获取所有分类
	{
		return newsTypeDao.getAll();
	}
	
	@Override
	public NewsType get(String id)	//获取一个分类
	{
		return newsTypeDao.get(Integer.valueOf(id));
	}
	
	@Override
	public boolean createType(NewsType newsType)	//创建分类
	{
		return newsTypeDao.save(newsType);
	}
	
	@Override
	public boolean updateType(NewsType newsType) 	//更新分类
	{
		return newsTypeDao.update(newsType);
	}
	
	@Override
	public boolean delete(String id)	//删除分类
	{
		NewsType newsType = newsTypeDao.get(Integer.valueOf(id));
		
		return newsTypeDao.delete(newsType);
	}
	
	
	//getter和setter
	public NewsTypeDao getNewsTypeDao()
	{
		return newsTypeDao;
	}

	public void setNewsTypeDao(NewsTypeDao newsTypeDao)
	{
		this.newsTypeDao = newsTypeDao;
	}

}
