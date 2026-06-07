package com.zihao.ZuiIT21.dao;

import java.io.Serializable;
import java.util.List;

import com.zihao.ZuiIT21.bean.Setting;
import com.zihao.ZuiIT21.dao.ifs.SettingDao;

public class SettingDaoImpl extends SettingDao 
{
	public SettingDaoImpl()
	{
		setBeanType(Setting.class);
	}
	
	@Override
	public Setting get(Serializable id)
	{
		return super.get(id);
	}

	@Override
	public List<Setting> getAll()
	{
		return super.getAll();
	}

	@Override
	public boolean save(Setting bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(Setting bean)
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(Setting bean)
	{
		return super.update(bean);
	}
	
}
