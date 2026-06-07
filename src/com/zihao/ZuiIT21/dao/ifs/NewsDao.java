package com.zihao.ZuiIT21.dao.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.News;

public abstract class NewsDao extends BaseDaoImpl<News>
{
	public abstract List<News> getNews(int first,int max);	//所有新闻(不按类别)进行分页查询方法
	public abstract List<News> getNewsByType(int type,int first,int max);	//按照某个类别进行分页查询方法
	public abstract int getAllSize();	//获取所有新闻的条数
	public abstract int getTypeSize(int type);	//获取某个类别新闻的条数
	public abstract List<News> getRecent();
	public abstract List<News> getPopular();
	public abstract List<News> getSelectPage(String where, String value, boolean isLike, int first, int size);
	public abstract int getSelectSize(String where, String value, boolean isLike);
}
