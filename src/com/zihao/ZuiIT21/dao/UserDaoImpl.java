package com.zihao.ZuiIT21.dao;

import java.io.Serializable;
import java.util.List;

import com.zihao.ZuiIT21.bean.User;
import com.zihao.ZuiIT21.dao.ifs.UserDao;

public class UserDaoImpl extends UserDao
{
	public UserDaoImpl()
	{
		beanType = User.class;
	}

	@Override
	public User get(Serializable id)
	{
		return super.get(id);
	}

	@Override
	public List<User> getAll() 
	{
		return super.getAll();
	}

	@Override
	public boolean save(User bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(User bean)
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(User bean)
	{
		return super.update(bean);
	}
	
	@Override
	public User loginSelect(String eloginName, String epassword)	//登录查询
	{
		String hql = "from "+beanType.getName()+" where loginName=? and password=?";
		@SuppressWarnings("unchecked")
		List<User> result = sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter(0, eloginName)
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
	public List<User> getSelectPage(String where, String value, boolean isLike, int first, int size)	//获取一页查询结果
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
	public int getSelectSize(String where, String value, boolean isLike)	//获取查询结果的条数
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
