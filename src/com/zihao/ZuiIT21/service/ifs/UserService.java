package com.zihao.ZuiIT21.service.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.User;
import com.zihao.ZuiIT21.util.Paging;

public interface UserService
{

	public boolean userRegister(User user);
	public User getUserLogin(String loginName, String password);
	public int getSelectSize(String where, String value);
	public List<User> getSelectPage(String where, String value, Paging paging);
	public boolean updateState(String id, String state);
	public boolean delete(String id);
	public User updateName(int id,String name);
	public User updateUser(int id,User user);
}
