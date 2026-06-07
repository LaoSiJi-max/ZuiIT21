package com.zihao.ZuiIT21.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//文章类
@Entity
@Table(name="n_news")
public class News
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;			//id
	@Column(length=50)
	private String title;	//标题
	@Lob
	@Column(columnDefinition="TEXT",nullable=true,length=5000)
	private String text;	//正文
	@ManyToOne(targetEntity=Admin.class)	//单向关系，N-1
	@JoinColumn(name="author",nullable=false)
	private Admin author;	//作者
	private Date date;		//发布时间
	private int click;		//点击量
	private int hot;		//热度
	@ManyToOne(targetEntity=NewsType.class)	//双向关系，N-1
	@JoinColumn(name="type",referencedColumnName="id",nullable=false)
	private NewsType type;	//分类
	

	public News()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Admin getAuthor() {
		return author;
	}

	public void setAuthor(Admin author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public int getLike() {
		return hot;
	}

	public void setLike(int hot) {
		this.hot = hot;
	}

	public NewsType getType() {
		return type;
	}

	public void setType(NewsType type) {
		this.type = type;
	}
}
