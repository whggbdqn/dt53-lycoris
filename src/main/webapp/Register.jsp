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
<
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/css.css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js"></script>
<link href="css/animate.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet"/>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/souye.js"></script>
<script type="text/javascript">
     $(function(){  //加载
        $(".userid").onblur(function(){
           // alert("我要验证用户名");
           //如何发送异步请求到服务器
           //$.post("服务器地址",给服务器的参数,function(data){回调函数}[,"json"]);
           var userid=$(".userid").val(); //取值
           alert(userid);
           $.post("Register.do",{"userid":userid},function(data){
               //data表示服务器返回数据
               //alert(data);
               if(data==1)
               {
               $("#cha").text("已存在");
               }
               else{
                $("#cha").text("可用");
               }
           });
        });
        })
</script>
</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid" id="nav-main">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">面试宝典</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
             <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    浏览企业<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">查看所有企业</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
             <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    推荐企业 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    个人资料 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
             <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    教员菜单 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>        
        </ul>

    </div>
    </div>
     <button type="button" class="btn btn-block btn-success btn-lg" id="but-login">登录</button>

</nav>

<div style="width: 800px; margin: 20px auto; background: ;">
	<div style="height: 50px; background: white; border-bottom:5px solid #C9CCCF; ">
		<button type="button" class="btn btn-block btn-default btn-lg" style="width: 150px;">基本信息</button>
	</div>
	
	<div style="width: 600px;height: 600px; background: Beige; clear: both;margin: 20px auto;">
		<form class="form-horizontal" role="form" style="padding: 50px;" method="post" onsubmit="return checkAll();" action="Register.do">
			
			
			 <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="images/111.jpg" alt="User profile picture" style="width: 100px;margin: 0px 30px;">
<div class="form-group"style="display: block ;margin:0px 0px 30px 50px;">
    <input type="file" id="inputfile">
  </div>
            </div>
			
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="userid" value="请输入用户名">
       <span id="cha"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">姓名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="username" value="请输入姓名">
    </div>
  </div>

   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
       <input type="password" class="form-control" name="password" value="请输入密码">
    </div>
  </div>
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-10">
       <input type="password" class="form-control" name="userpwd" value="请输入密码">
    </div>
  </div>
   <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">选择下拉</label>
    <div class="col-sm-10">
       <select style="width: 100px; height: 30px;" name="idgrade">
  	<option value="2">2</option>
  </select>
    </div>
  </div>
     <div>	
		<button type="submit" id="but1" class="btn btn-block btn-default btn-lg" style="width: 100px; float: right; margin: 5px 10px;">保存</button>
	</div>
</form>
		
	</div>
</div>



	</body>
</html>
