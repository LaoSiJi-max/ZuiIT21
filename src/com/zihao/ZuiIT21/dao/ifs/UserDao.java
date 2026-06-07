package com.zihao.ZuiIT21.dao.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.User;

public abstract class UserDao extends BaseDaoImpl<User>
{
	public abstract User loginSelect(String loginName, String password);
	public abstract List<User> getSelectPage(String where,String value,boolean isLike,int first,int size);
	public abstract int getSelectSize(String where,String value,boolean isLike);
}
