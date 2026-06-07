package com.zihao.ZuiIT21.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//配置参数类，此类为键值对应的形式，保存管理系统的配置参数
@Entity
@Table(name="s_setting")
public class Setting 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=20)
	private String sKey;	//参数的名称，就是键
	@Column(length=20)
	private String sValue;	//参数所保存的值，就是值
	
	public Setting()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsKey() {
		return sKey;
	}
	public void setsKey(String sKey) {
		this.sKey = sKey;
	}
	public String getsValue() {
		return sValue;
	}
	public void setsValue(String sValue) {
		this.sValue = sValue;
	}

}
