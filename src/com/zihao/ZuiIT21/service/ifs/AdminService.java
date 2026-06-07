package com.zihao.ZuiIT21.service.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.Admin;
import com.zihao.ZuiIT21.util.Paging;

public interface AdminService
{

	public Admin adminLogin(String loginName, String password);
	public List<Admin> getSelectPage(String where, String value, Paging paging);
	public int getSelectSize(String where, String value);
	public boolean updateState(String id, String state);
	public Admin get(String id);
	public boolean createAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean delete(String id);
	
}
