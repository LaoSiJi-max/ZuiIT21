package com.zihao.ZuiIT21.dao;

import java.io.Serializable;
import java.util.List;

import com.zihao.ZuiIT21.bean.NewsType;
import com.zihao.ZuiIT21.dao.ifs.NewsTypeDao;

public class NewsTypeDaoImpl extends NewsTypeDao
{
	public NewsTypeDaoImpl()
	{
		beanType = NewsType.class;
	}

	@Override
	public NewsType get(Serializable id)
	{
		return super.get(id);
	}

	@Override
	public List<NewsType> getAll()
	{
		return super.getAll();
	}

	@Override
	public boolean save(NewsType bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(NewsType bean)
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(NewsType bean)
	{
		return super.update(bean);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NewsType> getTypes(int first, int max)
	{
		String hql = "from "+beanType.getName();
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setFirstResult(first)
				.setMaxResults(max).list();
	}
}
