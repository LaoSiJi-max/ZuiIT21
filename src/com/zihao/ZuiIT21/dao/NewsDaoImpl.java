package com.zihao.ZuiIT21.dao;

import java.io.Serializable;
import java.util.List;

import com.zihao.ZuiIT21.bean.News;
import com.zihao.ZuiIT21.dao.ifs.NewsDao;

public class NewsDaoImpl extends NewsDao
{
	public NewsDaoImpl()
	{
		beanType = News.class;
	}

	@Override
	public News get(Serializable id)
	{
		return super.get(id);
	}

	@Override
	public List<News> getAll()
	{
		return super.getAll();
	}

	@Override
	public boolean save(News bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(News bean)
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(News bean)
	{
		return super.update(bean);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNews(int first, int max)
	{
		String hql = "from "+beanType.getName()+" order by date desc";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setFirstResult(first)
				.setMaxResults(max).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNewsByType(int type, int first, int max)	//按照类别获取新闻，并且实现数据库分页，type是分类id，first是开始元素，max是元素数量
	{
		String hql = "from "+beanType.getName()+" where type.id=? order by date desc";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, type)
				.setFirstResult(first)
				.setMaxResults(max).list();
	}
	
	@Override
	public int getAllSize()	//获取所有新闻一共的条数
	{
		String hql = "select count(id) from "+beanType.getName();
		return Integer.valueOf(sessionFactory.getCurrentSession().createQuery(hql).uniqueResult().toString());	
	}
	
	@Override
	public int getTypeSize(int type)	//获取目标分类下有多少条数据，type是分类id
	{
		String hql = "select count(id) from "+beanType.getName()+" where type.id=?";
		return Integer.valueOf(sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, type).uniqueResult().toString());			
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getPopular()	//获取最热10条新闻
	{
		String hql = "from "+beanType.getName()+" order by hot desc";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(10).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getRecent()	//获取最新10条新闻
	{
		String hql = "from "+beanType.getName()+" order by date desc";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(10).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getSelectPage(String where,String value,boolean isLike, int first, int size)	//获取搜索结果
	{
		StringBuffer hql = new StringBuffer("from ");
		hql.append(beanType.getName());
		hql.append(" where ");
		hql.append(where);
		hql.append(isLike?" like '%"+value+"%'":"='"+value+"'");
		
		return sessionFactory.getCurrentSession().createQuery(hql.toString())
				.setFirstResult(first)
				.setMaxResults(size)
				.list();
	}
	
	@Override
	public int getSelectSize(String where,String value,boolean isLike)		//获取搜索结果条数
	{
		StringBuffer hql = new StringBuffer("select count(id) from ");
		hql.append(beanType.getName());
		hql.append(" where ");
		hql.append(where);
		hql.append(isLike?" like '%"+value+"%'":"='"+value+"'");
		
		return Integer.valueOf(sessionFactory.getCurrentSession().createQuery(hql.toString())
				.uniqueResult().toString());
	}
}
