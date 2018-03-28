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
<script src="js/jquery-1.9.1.min.js"></script>
<link href="css/index.css" rel="stylesheet"/>
<link href="css/bootstrap.css" rel="stylesheet"/>
 <script src="echarts/echarts.js"></script>
 <script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/homepage.js"></script>
</head>
	<body>
	<!-- 导航条 -->
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
	    <div class="container-fluid" id="nav-main">
	    <div class="navbar-header">
	        <a class="navbar-brand" href="homepage.jsp">面试宝典</a>
	    </div>
    <div>
        <ul class="nav navbar-nav">
             <li class="dropdown">
                <a href="company.jsp" class="dropdown-toggle" >浏览企业 </a>
            </li>
             <li class="dropdown">
                <a href="recommend.jsp" class="dropdown-toggle" data-toggle="dropdown">推荐企业 </a>
            </li>
            <li class="dropdown">
                <a href="personal.jsp" class="dropdown-toggle" data-toggle="dropdown">个人资料</a>
            </li>
             <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">教员菜单 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="admin.jsp">管理用户信息</a></li>
                    <li class="divider"></li>
                    <li><a href="#">管理公司信息</a></li>
                </ul>
            </li>       
        </ul>
    </div>
    </div>
    <button type="button" class="btn btn-block btn-success btn-lg" id="but-login">注册</button>
</nav>
<!-- 导航条回 -->
<!-- 图表 -->
<div class="mainPage">
	<div id="wrapper">
		<div style="margin-top: 30px;height: 500px;">
				<div class="maininfo">
							关于校区学员在各个城市的面试记录,当然并不是面试通过的结果,
							而是每次学员面试的记录,所以这里只能告诉你目前大家都去了哪里面试
							尝试的次数又是多少,很可惜我们并没有统计学员的信息,所以没有更多的
							信息啦!
				</div>
				<div id="main" class="mainCharts"></div>
		</div>
		<div style="margin-top: 30px;height: 500px;">
				<div class="maininfo">
							关于在面试时的会被问道的技术问题,大体上我们都搜集到了,
						    但是同学们似乎对记录信息并不感冒,有很多没有任何价值的记录哦.
						    不过我们还是能从中找到一些端倪,看看目前在面试时各位都会被问
						    到什么问题吧!
				</div>
				<div id="main1" class="mainCharts"></div>
		</div>
		<div style="margin-top: 30px;height: 500px;">
				<div class="maininfo">
							关于在面试时,面试公司的非技术性信息,也包括一些对应聘者
							的要求,对于青鸟的学员们,学历自然是最头疼的问题,然而似乎面试
							公司也很喜欢去查学历呢!同时过往的工作经验几乎都是虚假的,怎么
							处理能够通过面试呢?
				</div>
				<div id="main2" class="mainCharts"></div>
		</div>
	</div>
<div id="userinfo">
	<div id="login-no" style="text-align: center;">
	<h2>您还未登录！</h2>
	<br />
	<button type="button" class="btn btn-block btn-success btn-lg" id="but-login1" data-toggle="modal" data-target="#myModal">登录</button>
	<button type="button" class="btn btn-block btn-success btn-lg" id="but-login2">
	<a href="Register.jsp" style="color: white;text-decoration: none;">注册</a></button>
</div>

<div id="userinfo2"  style="display: none;">
<div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="" alt="User profile picture">
              <h3 class="profile-username text-center">Nina Mcintire</h3>
              <p class="text-muted text-center">Software Engineer</p>
              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>Followers</b> <a class="pull-right">1,322</a>
                </li>
                <li class="list-group-item">
                  <b>Following</b> <a class="pull-right">543</a>
                </li>
                <li class="list-group-item">
                  <b>Friends</b> <a class="pull-right">13,287</a>
                </li>
              </ul>
              <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
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
</div>
<!-- mainPage -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					登陆
				</h4>
			</div>
			<div class="modal-body">
<form class="form-horizontal" role="form" method="post" action="Login.do">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="userid" value="请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
       <input type="password" class="form-control" name="password" value="请输入密码">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox">请记住我
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" >登录</button>
    </div>
  </div>
</form>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>	
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

	</body>
</html>