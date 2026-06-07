package com.zihao.ZuiIT21.service.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.NewsType;

public interface NewsTypeService
{
	public NewsType getType(String type);
	public List<NewsType> getAll();
	public NewsType get(String id);
	public boolean createType(NewsType newsType);
	public boolean updateType(NewsType newsType);
	public boolean delete(String id);
}
