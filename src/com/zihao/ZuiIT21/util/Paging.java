package com.zihao.ZuiIT21.util;

//分页适配器
public class Paging 
{
	private int thisPage;	//当前页数
	private int maxPage;	//最大页数
	private int pageSize;	//每页显示多少个元素
	private int maxItem;	//元素总数
	
	public Paging(int thisPage,int pageSize,int maxItem)
	{
		this.pageSize = pageSize;
		this.maxItem = maxItem;
		
		if(maxItem % pageSize == 0)
		{
			maxPage = maxItem / pageSize;
		}
		else
		{
			maxPage = maxItem / pageSize + 1;
		}
		
			
		if(thisPage>0 && thisPage<=maxPage)
		{
			this.thisPage = thisPage;
		}
		else if(thisPage<=0)
		{
			this.thisPage = 1;
		}
		else if(thisPage>maxPage)
		{
			this.thisPage = maxPage;
		}
		else
		{
			this.thisPage = 1;
		}
	}
	
	public int startNum()	//开始的元素数
	{
		return (thisPage-1) * pageSize;
	}
	
	public int endNum()		//结束的元素数
	{
		int endItem = thisPage * pageSize - 1;
		
		if(endItem>=maxItem)
		{
			return maxItem - 1;
		}
		else
		{
			return endItem;
		}
	}
	
	public int getThisPage()
	{
		return thisPage;
	}
	public void setThisPage(int thisPage)
	{
		this.thisPage = thisPage;
	}
	public int getMaxPage()
	{
		return maxPage;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public int getMaxItem()
	{
		return maxItem;
	}
}
