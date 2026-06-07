package com.zihao.ZuiIT21.service.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.News;
import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.util.Paging;

public interface NewsService
{
	public List<News> getRecent();
	public List<News> getPopular();
	public List<News> getHomeNews(int type);
	public News getNews(int id);
	public List<News> getPage(String type,Paging paging);
	public int getTypeSize(String type);
	public int getSelectSize(String where, String value);
	public List<News> getSelectPage(String where, String value, Paging paging);
	public boolean createNews(News news,int authorId,int typeId);
	public boolean updateNews(News news,int typeId);
	public News get(String id);
	public boolean delete(String id);
	public List<NewsType> getTypes(int count);
	public News newsAccess(String id);
	public boolean addLike(String id);
}
