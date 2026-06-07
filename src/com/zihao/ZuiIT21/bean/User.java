package com.zihao.ZuiIT21.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.zihao.ZuiIT21.enums.LoginState;
import com.zihao.ZuiIT21.enums.Sex;

//用户类
@Entity
@Table(name="u_user")
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;				//id
	@Column(length=20,nullable=false,unique=true)
	private String loginName;	//登录名
	@Column(length=20)
	private String password;	//密码
	@Column(length=20,nullable=false,unique=true)
	private String nickName;	//昵称
	private Sex sex;			//性别，枚举
	@Column(length=30)
	private String phone;		//电话
	@Column(length=30)
	private String email;		//邮箱
	private Date birthday;		//生日
	@Column(length=200)
	private String sign;		//签名
	@Column(length=50)
	private String icon;		//图标
	@Enumerated(EnumType.ORDINAL)
	private LoginState state;	//状态，枚举

	public User()
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public LoginState getState() {
		return state;
	}
	public void setState(LoginState state) {
		this.state = state;
	}
}
