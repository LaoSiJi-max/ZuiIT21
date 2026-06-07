<%@ page pageEncoding="UTF-8"%>
<link href="css/manageIframe.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery.treeview.css" />

<div id="iframeInside">
<h1>欢迎使用</h1>
<ul id="browser" class="filetree">
                    	<s:if test="#session.perms>=0">
                        <li><span class="folder">文章管理</span>
                            <ul>
                                <li><span class="file"><a href="adNews_createOrUpdate" target="right">文章发布</a></span></li>
                                <li><span class="file"><a href="adNews" target="right">文章信息管理</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                        <s:if test="#session.perms>=1">
                        <li><span class="folder">用户管理</span>
                            <ul>
                                <li><span class="file"><a href="adUser" target="right">用户信息管理</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                        <s:if test="#session.perms>=2">
                        <li><span class="folder">管理员管理</span>
                            <ul>
                                <li><span class="file"><a href="admin_table" target="right">管理员信息管理</a></span></li>
                                <li><span class="file"><a href="admin_createOrUpdate" target="right">新建管理员</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                        <s:if test="#session.perms>=1">
                        <li><span class="folder">系统管理</span>
                            <ul>
                                <li><span class="file"><a href="adNews_type" target="right">分类信息管理</a></span></li>
                                <li><span class="file"><a href="adNews_COUType" target="right">新建分类</a></span></li>
                            </ul>
                        </li>
                        </s:if>
                    </ul>
</div>