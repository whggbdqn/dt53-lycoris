<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>青鸟面试数据分析</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	   <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 

  </head>
  
 <body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><strong>TeamLycoris</strong></a>
				
		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                 <ul class="nav" id="main-menu">

                    <li>
                        <a href="homepage.jsp"style="font-size: 1.7em"><i class="fa fa-dashboard"></i> 首页</a>
                    </li>
                    <li>
                        <a href="goCompany.do" style="font-size: 1.7em"><i class="fa fa-desktop"></i> 浏览公司</a>
                    </li>
					<li>
                        <a href="homepage.jsp"style="font-size: 1.7em"><i class="fa fa-bar-chart-o"></i> 推荐公司</a>
                    </li>
                    <li>
                        <a href="userProfile.jsp"style="font-size: 1.7em"  class="active-menu" ><i class="fa fa-qrcode"></i>个人信息</a>
                    </li>
                    
                    <li>
                        <a href="adminUser.jsp"style="font-size: 1.7em"><i class="fa fa-table"></i> 管理员入口</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
		<div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            北大青鸟 
                        </h1>
					<ol class="breadcrumb">
					  <li ><a href="homepange.jsp">首页</a></li>
					   <li class="active"><a href="userProfile.jsp">个人信息</a></li>
					</ol> 
		</div>
            <div id="page-inner">
              	 <div class="row">
              	 	 <div class="col-md-12">
              	 	 	 <div class="panel panel-primary">
	                        <div class="panel-heading">
	                           个人信息
	                        </div>
	                        <div class="panel-body">
			                        	<!-- 个人信息 -->
			              	 	<div class="col-md-4 col-sm-4">
				                    <div class="panel panel-default">
				                        <div class="panel-heading">
				                           ${user }
				                        </div>
				                        <div class="panel-body">
				                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
				                        </div>
				                        <div class="panel-footer">
				                            Panel Footer
				                        </div>
				                    </div>
                </div>
	                        </div>
                 	   </div>
              	 	</div>
              	 </div>
              <h2>创建模态框（Modal）</h2>
				<!-- 按钮触发模态框 -->
				<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
				    添加
				</button>
				<button class="btn btn-primary btn-lg" onclick="update_info(8)" data-toggle="modal" data-target="#myModal">
				    编辑
				</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                	 修改信息
                </h4>
            </div>
            <div class="modal-body">
                <div class="row">
              	 <div class="col-md-8 col-md-offset-2">
              	 	<div class="panel panel-default">
	                        <div class="panel-body">
								                        	 		<div class="col-md-12">
								                        	 			<form action="">
												                        	 		<div class="form-group">
											                                            <label>账号</label>
										                                           		 <p class="form-control-static">***账号***</p>
											                                            <label>姓名</label>
											                                           	 <input class="form-control" placeholder="请输入姓名">
											                                           	 <label>邮箱</label>
													                        	 		<input class="form-control" placeholder="请输入邮箱">
													                        	 			 <label>电话</label>
										                                           	 <input class="form-control" placeholder="请输入邮箱">
										                                           	 <label>班级</label>
											                                            <select class="form-control">
											                                                <option value="1">1</option>
											                                            </select>
											                                            <label>意向城市</label>
											                                            <select class="form-control">
											                                                <option value="1">1</option>
											                                            </select>
											                                            <div class="col-md-4  col-md-offset-4">
											                                             <button type="submit" class="btn btn-default" style="margin-top: 30px;" >确认</button>
											                                             </div>
								                                     				</div>
								                                     		 </form>		
								                                     	</div>
				                        	 </div>
	                         </div>
	                </div>
              	 </div>
              </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
		
		                           
				<footer><p>Copyright &copy; 2018.By TeamLycoris </p></footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
	 
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	 <script src="echarts/echarts.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/CompanyDetil.js"></script>

      <script>
    
      </script>

</body>
</html>
