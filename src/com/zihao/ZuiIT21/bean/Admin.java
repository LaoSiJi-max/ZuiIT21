package com.zihao.ZuiIT21.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zihao.ZuiIT21.enums.AdminLevel;
import com.zihao.ZuiIT21.enums.LoginState;

//管理员类，后台的管理员
@Entity
@Table(name="a_admin")
public class Admin
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;				//id
	@Column(length=20,nullable=false,unique=true)
	private String loginName;	//登录名
	@Column(length=20)
	private String password;	//密码
	@Column(length=20,nullable=false,unique=true)
	private String name;		//名称
	@Enumerated(EnumType.ORDINAL)
	private AdminLevel level;	//管理员等级：作者，系统管理员，超级管理员
	@Enumerated(EnumType.ORDINAL)
	private LoginState state;	//登录状态：正常，禁用
	
	public Admin()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AdminLevel getLevel() {
		return level;
	}
	public void setLevel(AdminLevel level) {
		this.level = level;
	}
	public LoginState getState() {
		return state;
	}
	public void setState(LoginState state) {
		this.state = state;
	}

}
