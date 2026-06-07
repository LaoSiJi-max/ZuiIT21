package com.zihao.ZuiIT21.action.admin.ifs;

public interface AdminAction
{
	public String login();	//登录页面
	public String login_post();	//登录页面提交
	public String stateChange();	//状态更改
	public String createOrUpdate();	//增加或者删除
	public String createOrUpdate_post();	//增加或者删除操作提交
	public String delete();	//删除(ajax)
	public String logout();	//推出登陆
	public String index();
}
