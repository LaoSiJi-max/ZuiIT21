package com.zihao.ZuiIT21.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//文章分类
@Entity
@Table(name="n_type")
public class NewsType
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;			//id
	@Column(length=20)
	private String name;	//分类名称
	@OneToMany(targetEntity=News.class,mappedBy="type")	//双向关系，1-N
	private List<News> news;//属于分类的文章的集合

	public NewsType()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	
}
