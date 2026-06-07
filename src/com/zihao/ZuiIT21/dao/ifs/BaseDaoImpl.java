package com.zihao.ZuiIT21.dao.ifs;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

//数据访问类基类实现
public abstract class BaseDaoImpl<T> implements BaseDao<T>
{
	protected SessionFactory sessionFactory;	//hibernate的SessionFactory
	protected Class<T> beanType;				//这是用来描述数据访问类操作的目标类的类，这是一个泛型

	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Class<T> getBeanType() 
	{
		return beanType;
	}

	@Override
	public void setBeanType(Class<T> beanType) 
	{
		this.beanType = beanType;
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id)	//按照id查询并且返回一条"T"类数据
	{
		return (T)sessionFactory.getCurrentSession().get(beanType , id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll()			//获取"T"类所有数据并返回
	{
		String hql = "from "+beanType.getName();
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public boolean save(T bean)		//保存一个"T"类数据，成功返回true，出现异常返回false
	{
		try 
		{
			sessionFactory.getCurrentSession().save(bean);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(T bean)	//删除一个"T"类数据，成功返回true，出现异常返回false
	{
		try
		{
			sessionFactory.getCurrentSession().delete(bean);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(T bean)	//更新一个"T"类数据，成功返回true，出现异常返回false
	{
		try 
		{
			sessionFactory.getCurrentSession().update(bean);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
