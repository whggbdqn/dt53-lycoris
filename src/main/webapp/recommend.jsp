<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="css/css.css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js"></script>
<link href="css/animate.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet"/>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script language="JavaScript" type="text/javascript" src="js/souye.js"></script>
 <script src="echarts/echarts.js"></script>
 <script src="js/bootstrap.min.js"></script>
 <script src="js/jquery-1.9.1.min.js"></script>
</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid" id="nav-main">
    <div class="navbar-header">
        <a class="navbar-brand" href="homepage.jsp">面试宝典</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
             <li class="dropdown">
                <a href="company.jsp" class="dropdown-toggle" data-toggle="dropdown"> 浏览企业</a>
            </li>
             <li class="dropdown">
                <a href="recommend.jsp" class="dropdown-toggle" data-toggle="dropdown">推荐企业 </a>
            </li>
            <li class="dropdown">
                <a href="personal.jsp" class="dropdown-toggle" data-toggle="dropdown">个人资料</a>     
            </li>
             <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 教员菜单 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="admin.jsp">管理用户信息</a></li>
                    <li class="divider"></li>
                    <li><a href="usercompany.jsp">管理公司信息</a></li>
                </ul>
            </li>          
        </ul>
    </div>
    </div>
     <button type="button" class="btn btn-block btn-success btn-lg" id="but-login" style="float: right; margin-right:50px;">返回登录</button>

</nav>

	<div id="table1" style="width: 60%; float: left; margin-left:10%;margin-top:50px">
		<table class="table table-hover">
	<caption>
		
		<div class="box-body">
              <div class="row" style="float: left;">
                <div class="col-xs-3">
                	地区:  
                	<br/>      
                   <select style="width: 100%;height: 33px">
                      <option>武汉</option>
                      <option>深圳</option>
                   </select>      
                </div>
                <div class="col-xs-3">
                	公司名称:
                  <input type="text" class="form-control" placeholder="公司名称">
                </div>
                <div class="col-xs-3">
                	特点:
                  <input type="text" class="form-control" placeholder="特点">
                </div>
                <div class="col-xs-3">
                  <button type="button" class="btn btn-block btn-default btn-lg" style="width: 100px;float:right; margin-top:10px;">
                  <span class="glyphicon glyphicon-search"></span>查询</button>
                </div>
              </div>
            
                  
            </div>
	</caption>
	<thead>
		<tr>
			<th>公司名称</th>
			<th>地区</th>
			<th>特点</th>
			<th>操作</th>
			<th>收藏</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>武汉天成有限公司</td>
			<td>武汉</td>
			<td>ssm,js,java</td>
			<td>详情</td>
			<td>收藏</td>
		</tr>
		<tr>
			<td>深圳天成有限公司</td>
			<td>深圳</td>
			<td>ssm,js,SpringBoot</td>
			<div><td>详情</td></div>
			<td>收藏</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>560001</td>
			<td>560001</td>
			<td>411027</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
	</tbody>
</table>
		</div>
		
		
		
		
		
		
		
		<div id="userinfo" style="display: none;">
	<div id="login-no" style="text-align: center;">
	<h1>您还未登录！</h1>
	<br />
	<button type="button" class="btn btn-block btn-success btn-lg" id="but-login1">登录</button>
	<button type="button" class="btn btn-block btn-success btn-lg" id="but-login2">注册</button>
</div>
<div>
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
</div>
	</div>
	
<div id="userinfo2" >
<div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="img/111.jpg" alt="User profile picture">

              <h2 class="profile-username text-center">钟浩</h2>

              <p class="text-muted text-center">软件工程师</p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>意向城市</b> <a class="pull-right">深圳</a>
                </li>
                <li class="list-group-item">
                  <b>意向工作</b> <a class="pull-right">软件工程师</a>
                </li>
                <li class="list-group-item">
                  <b>个人邮箱</b> <a class="pull-right">zhonghao123@qq.com</a>
                </li>
              </ul>

              <a href="#" class="btn btn-primary btn-block"><b>个人标签</b></a>
            </div>
            <!-- /.box-body -->
          </div>
<div style="margin: 5px;">
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
	<button type="button" class="btn btn-info btn-sm">小的信息按钮</button>  
</div>
</div>
		



	</body>
</html>
