package com.zihao.ZuiIT21.dao.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.Admin;

public abstract	class AdminDao extends BaseDaoImpl<Admin>
{

	public abstract Admin loginSelect(String loginName, String epassword);
	public abstract List<Admin> getSelectPage(String where, String value, boolean isLike, int first, int size);
	public abstract int getSelectSize(String where,String value,boolean isLike);
	
}
