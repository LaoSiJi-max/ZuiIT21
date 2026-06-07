<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>个人中心</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style_user.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>

<body>
	<div class="main">
	  <div class="content">
		  <div class="sap_tabs">
			<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
						<script type="text/javascript">
							$(document).ready(function () {
								$('#horizontalTab').easyResponsiveTabs({
									type: 'default', //Types: default, vertical, accordion           
									width: 'auto', //auto or any width like 600px
									fit: true,   // 100% fit in a container
									closed: 'accordion', // Start closed if in accordion view
									activate: function(event) { // Callback function if tab is switched
										var $tab = $(this);
										var $info = $('#tabInfo');
										var $name = $('span', $info);
										$name.text($tab.text());
										$info.show();
									}
								});

								$('#verticalTab').easyResponsiveTabs({
									type: 'vertical',
									width: 'auto',
									fit: true
								});
							});
						</script>
						<div >
							<div class="port-left">
								<ul class="resp-tabs-list">
									  <!--<img src="images/1.jpg" alt="" />-->
									  <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>登录信息</span></li>
									  <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>个人信息</span></li>
								</ul>		
							</div>
							
							<div class="port-right">
								
									<div class="resp-tabs-container">
									
		<!-- Tab 0 -->					<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
											<div class="profile-content">
												<h3>个人中心</h3>									
												<h4>用户ID</h4>
												<div class="email-group">
														<div class="email-form">
															${session.loginUser.id}
														</div>
														<div class="clear"></div>
												</div>
												<h4>用户登录名</h4>
												<div class="email-group">
														<div class="email-form">
															${session.loginUser.loginName}
														</div>
														<div class="clear"></div>
												</div>
                                                <h4>用户名<s:if test="#session.loginUser.loginName==#session.loginUser.nickName"> <a href="javascript:editName();" id="edit_a">修改</a></s:if></h4>
												<div class="email-group">
														<div class="email-form" id="nickName">
                                                        	<span id="name_value">${session.loginUser.nickName}</span>
															<span id="editName_form"><form action="user_updateName" name="editName" method="post"><input name="user.nickName" id="user.nickName" value="${session.loginUser.nickName}" size="16" maxlength="20"/><input type="submit" value="修改"/><input type="button" value="取消" onClick="editName_cancel()"/></form></span>
												  </div>
														<div class="clear"></div>
												</div>		
				</div>
											</div>
							  </div>
										
										
	<!-- Tab 1 -->					    <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
											<div class="profile-content">
												<h3>个人中心</h3>	
                                                
                                                <span id="user_value">								
												<h4>性别</h4>
												<div class="email-group">
														<div class="email-form">
															${session.loginUser.sex}	
														</div>
														<div class="clear"></div>
												</div>
                                                <h4>生日</h4>
												<div class="email-group">
														<div class="email-form">
															${session.loginUser.birthday}	
														</div>
														<div class="clear"></div>
												</div>
                                                <h4>联系电话</h4>
												<div class="email-group">
														<div class="email-form">
															${session.loginUser.phone}	
														</div>
														<div class="clear"></div>
												</div>
                                                <h4>邮箱</h4>
												<div class="email-group">
														<div class="email-form">
															${session.loginUser.email}
														</div>
														<div class="clear"></div>
												</div>	
                                                <p><a href="javascript:editUser();" id="edit_a_user">修改</a></p>
                                                </span>
                                                <span id="editUser_form">
                                                <form action="user_updateUser" name="editUser" method="post">	
                                                <h4>性别</h4>
												<div class="email-group">
														<div class="email-form">
														  <p>
															  <label>
															    <input type="radio" name="user.sex" value="男" id="user.sex0" ${session.loginUser.sex=='男'?'checked="checked"':''}>
															    男</label>
															  <br>
															  <label>
															    <input type="radio" name="user.sex" value="女" id="user.sex1" ${session.loginUser.sex=='女'?'checked="checked"':''}>
															    女</label>
															  <br>
														  </p>
                                                        </div>
														<div class="clear"></div>
												</div>						
												<h4>生日</h4>
												<div class="email-group">
														<div class="email-form">
															<input id="user.birthday" name="user.birthday" type="date" class="fb-ico" value="${session.loginUser.birthday}">	
														</div>
														<div class="clear"></div>
												</div>
												<h4>电话</h4>
												<div class="email-group">
														<div class="email-form">
															<input id="user.phone" name="user.phone" type="text" class="fb-ico" value="${session.loginUser.phone}">	
														</div>
														<div class="clear"></div>
												</div>
                                                <h4>邮箱</h4>
												<div class="email-group">
														<div class="email-form">
															<input id="user.email" name="user.email" type="text" class="fb-ico" value="${session.loginUser.email}">	
														</div>
														<div class="clear"></div>
												</div>
                                                <input type="submit" value="修改"/><input type="button" value="取消" onClick="editUser_cancel()"/>
                                                </form>
                                                </span>
                                                
			  </div>
											</div>
						  </div>
								
			  </div>	
							<div class="clear"></div>
						</div>
						
			</div>
		</div>

		</div>
		<p class="footer">XXXXXXXX - XXX<a href="index" target="_blank">返回首页</a></p>
		</div>


</body>
</html>