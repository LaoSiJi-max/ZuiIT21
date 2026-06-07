package com.zihao.ZuiIT21.service;

import java.util.List;

import com.zihao.ZuiIT21.bean.User;
import com.zihao.ZuiIT21.dao.ifs.UserDao;
import com.zihao.ZuiIT21.enums.LoginState;
import com.zihao.ZuiIT21.service.ifs.UserService;
import com.zihao.ZuiIT21.util.EncryptDES;
import com.zihao.ZuiIT21.util.Paging;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	
	private EncryptDES encryptDES;
	
	@Override
	public boolean userRegister(User user)	//用户注册 user是提交来的信息
	{
		user.setNickName(user.getLoginName());	//昵称设置为登录名，新用户注册后默认昵称为登录名
		user.setPassword(encryptDES.encrytor(user.getPassword()));	//密码需加密后提交
		user.setState(LoginState.正常);	//状态设置为正常
		
		return userDao.save(user);
	}
	
	@Override
	public User getUserLogin(String loginName, String password)	//获取用户登录信息
	{	
		return userDao.loginSelect(loginName,encryptDES.encrytor(password));
	}
	
	@Override
	public List<User> getSelectPage(String where, String value, Paging paging)	//获取一页的搜索结果(与AdminServiceImpl中的类似)
	{
		if(where.equals("") || value.equals(""))
		{
			return null;
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
			
			return userDao.getSelectPage(where, value, isLike, paging.startNum(), paging.getPageSize());
		}
	}
	
	@Override
	public int getSelectSize(String where, String value)	//获取搜索结果的条数(与AdminServiceImpl中的类似)
	{
		if(where.equals("") || value.equals(""))
		{
			return 0;
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
			
			return userDao.getSelectSize(where, value, isLike);
		}
	}
	
	@Override
	public boolean updateState(String id, String state)	//修改状态(与AdminServiceImpl中的类似)
	{
		User user = userDao.get(Integer.valueOf(id));
		
		switch (state)
		{
			case "0":
				user.setState(LoginState.正常);
				break;
				
			case "1":
				user.setState(LoginState.禁用);
				break;
	
			default:
				user.setState(LoginState.正常);		
				break;
		}
		
		return userDao.update(user);
	}
	
	@Override
	public boolean delete(String id)	//删除(ajax)
	{
		User user = userDao.get(Integer.valueOf(id));
		
		return userDao.delete(user);
	}
	
	@Override
	public User updateName(int id,String name)	//修改用户名
	{
		User old = userDao.get(id);
		old.setNickName(name);

		if(userDao.update(old))
		{
			return old;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public User updateUser(int id,User user)	//修改资料
	{
		User old = userDao.get(id);
		old.setSex(user.getSex());
		old.setBirthday(user.getBirthday());
		old.setEmail(user.getEmail());
		old.setPhone(user.getPhone());
		
		if(userDao.update(old))
		{
			return old;
		}
		else
		{
			return null;
		}
	}

	
	//getter和setter
	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public EncryptDES getEncryptDES()
	{
		return encryptDES;
	}

	public void setEncryptDES(EncryptDES encryptDES)
	{
		this.encryptDES = encryptDES;
	}
}