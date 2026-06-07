package com.zihao.ZuiIT21.dao;

import java.io.Serializable;
import java.util.List;

import com.zihao.ZuiIT21.bean.Admin;
import com.zihao.ZuiIT21.dao.ifs.AdminDao;

public class AdminDaoImpl extends AdminDao
{
	public AdminDaoImpl()
	{
		beanType = Admin.class;
	}
	
	@Override
	public Admin get(Serializable id)
	{
		return super.get(id);
	}

	@Override
	public List<Admin> getAll()
	{
		return super.getAll();
	}

	@Override
	public boolean save(Admin bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(Admin bean)
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(Admin bean)
	{
		return super.update(bean);
	}
	
	@Override
	public Admin loginSelect(String loginName, String epassword)	//登陆查询
	{
		String hql = "from "+beanType.getName()+" where loginName=? and password=?";	//按照登录名和密码查询
		@SuppressWarnings("unchecked")
		List<Admin> result = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, loginName)
				.setParameter(1, epassword)
				.list();
		if(result.size()>0)
		{
			return result.get(0);
		}
		else
		{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getSelectPage(String where,String value,boolean isLike, int first, int size)	//获取搜索结果
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
