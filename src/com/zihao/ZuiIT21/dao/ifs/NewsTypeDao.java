package com.zihao.ZuiIT21.dao.ifs;

import java.util.List;

import com.zihao.ZuiIT21.bean.NewsType;

public abstract class NewsTypeDao extends BaseDaoImpl<NewsType>
{
	public abstract List<NewsType> getTypes(int first, int max);
	
}
