package com.zihao.ZuiIT21.service;

import java.util.List;

import com.zihao.ZuiIT21.bean.Admin;
import com.zihao.ZuiIT21.dao.ifs.AdminDao;
import com.zihao.ZuiIT21.enums.LoginState;
import com.zihao.ZuiIT21.service.ifs.AdminService;
import com.zihao.ZuiIT21.util.EncryptDES;
import com.zihao.ZuiIT21.util.Paging;

public class AdminServiceImpl implements AdminService
{
	private AdminDao adminDao;
	
	private EncryptDES encryptDES;
	
	@Override
	public Admin adminLogin(String loginName, String password)	//管理员登录的验证 loginName是登录名，password是密码
	{
		return adminDao.loginSelect(loginName,encryptDES.encrytor(password));	//按照登录名和密码获取，密码按照算法加密
	}
	
	@Override
	public List<Admin> getSelectPage(String where, String value, Paging paging)	//获取查询结果一页的数据	where是查询条件，value是关键字，paging是分页适配器
	{
		if(where.equals("") || value.equals(""))	//两个值都不能为空字符串
		{
			return null;
		}
		else
		{
			boolean isLike = false;	//是否使用模糊查询
			
			switch (where)
			{
				case "id":
					isLike = false;
					break;
	
				case "loginName":
				case "name":
					isLike = true;
					break;
					
				default:
					break;
			}
			
			return adminDao.getSelectPage(where, value, isLike, paging.startNum(), paging.getPageSize());	//返回结果
		}
	}
	
	@Override
	public int getSelectSize(String where, String value)	//获取getSelectPage方法查询结果的条数，用于数据库分页
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
			
			return adminDao.getSelectSize(where, value, isLike);
		}
	}
	
	@Override
	public boolean updateState(String id, String state)	//修改登录状态	id是管理员的id，state是希望修改的状态0正常，1禁用
	{
		Admin admin = adminDao.get(Integer.valueOf(id));	//按照id获取管理员信息
		
		switch (state)
		{
			case "0":
				admin.setState(LoginState.正常);
				break;
				
			case "1":
				admin.setState(LoginState.禁用);
				break;
	
			default:
				admin.setState(LoginState.正常);		
				break;
		}
		
		return adminDao.update(admin);
	}
	
	@Override
	public boolean delete(String id)	//删除管理员 id是管理员的id
	{
		Admin admin = adminDao.get(Integer.valueOf(id));
		
		return adminDao.delete(admin);
	}

	@Override
	public Admin get(String id)	//获取管理员信息 id是管理员的id
	{
		return adminDao.get(Integer.valueOf(id));
	}
	
	@Override
	public boolean createAdmin(Admin admin)	//创建管理员 admin是用户提交的管理员信息
	{
		admin.setPassword(encryptDES.encrytor(admin.getPassword()));	//密码的值需加密
		admin.setState(LoginState.正常);	//状态设置为正常
		
		return adminDao.save(admin);
	}
	
	@Override
	public boolean updateAdmin(Admin admin)	//修改管理员 admin是用户提交的管理员信息
	{
		Admin old = adminDao.get(admin.getId());	//先查询到此id的管理员原来的数据
		
		//将所有值逐个设置
		old.setLevel(admin.getLevel());
		old.setLoginName(admin.getLoginName());
		old.setName(admin.getName());
		
		return adminDao.update(old);
	}
	
	//getter和setter
	public AdminDao getAdminDao()
	{
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao)
	{
		this.adminDao = adminDao;
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
