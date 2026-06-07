package com.zihao.ZuiIT21.dao.ifs;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

//数据访问类基类接口
public interface BaseDao<T>
{
	//必备的get和set
	public SessionFactory getSessionFactory();		//SessionFactory的getter
	public void setSessionFactory(SessionFactory sessionFactory);	////SessionFactory的setter 
	public Class<T> getBeanType();		//Class的getter，“T”一个泛型
	public void setBeanType(Class<T> beanType);	//Class的setter，“T”一个泛型
	//所有数据访问类都有的基本方法
	public T get(Serializable id);		//按照id查一条数据
	public List<T> getAll();			//获取所有数据
	public boolean save(T bean);		//保存一条数据
	public boolean delete(T bean);		//删除一条数据
	public boolean update(T bean);		//更新一条数据
}
