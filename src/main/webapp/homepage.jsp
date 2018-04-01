<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
                        <a class="active-menu" href="homepage.jsp"style="font-size: 1.7em"><i class="fa fa-dashboard"></i> 首页</a>
                    </li>
                    <li>
                        <a href="goCompany.do" style="font-size: 1.7em"><i class="fa fa-desktop"></i> 浏览公司</a>
                    </li>
					<li>
                        <a href="homepage.jsp"style="font-size: 1.7em"><i class="fa fa-bar-chart-o"></i> 推荐公司</a>
                    </li>
                    <li>
                        <a href="homepage.jsp"style="font-size: 1.7em"><i class="fa fa-qrcode"></i>个人信息</a>
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
					  <li class="active"><a href="homepange.jsp">首页</a></li>
					</ol> 
		</div>
            <div id="page-inner">
             <!-- 第一行展示公司统计 -->
                <div class="row">
						 <div class="col-md-6">
                        <div class="panel panel-primary text-center no-boder blue">
                            <div class="panel-left pull-left blue">
                                <i class="fa fa-eye fa-5x"></i>
                            </div>
                            <div class="panel-right">
								<h3  class="datacount"></h3>
                               <strong style="font-size: 1.7em"> 总记录数: 目前插入数据库记录数量</strong>
                            </div>
                        </div>
                    </div>
						  <div class="col-md-6">
                        <div class="panel panel-primary text-center no-boder blue">
                            <div class="panel-left pull-left blue">
                                <i class="fa fa-users fa-5x"></i>
                            </div>
                            <div class="panel-right">
							<h3 class="companycount"> </h3>
                             <strong style="font-size: 1.7em">公司统计: 目前检索出公司的数量</strong>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /第一行展示公司统计 -->
                	<hr>
                <!-- 第二行展示公司统计 -->
				<div class="row">
					<!-- 饼图介绍 -->
					<div class="col-md-12">
	                    <div class="panel panel-danger">
	                        <div class="panel-heading"style="font-size: 1.7em">
	                          公司统计
	                        </div>
	                        <div class="panel-body">
	                        <div class="col-md-6">
	                            <p style="text-indent: 30px;font-size: 1.7em;line-height: 2em;margin-top: 15%;">上方数据是目前添加的记录条数与总的公司统计,如果在录入的时候有的公司名称打
	                            	错了或者不全面,可能会造成展示的信息有误!
	                            	右侧饼图是关于校区学员在各个城市的面试记录,当然并不是面试通过的结果,
									而是每次学员面试的记录,所以这里只能告诉你目前大家都去了哪里面试
									尝试的公司又是多少,很可惜我们并没有统计学员的信息,所以没有更多的信息啦!</p>
	                         </div>
	                         <!-- 饼图 -->
	                          <div class="col-md-6">
		                           <div class="panel panel-default" style="width: 100%;border-color: white;">
			                            <div class="panel-heading" style="width: 100%"></div>
				                            <div class="panel-body">
				                                <div id="companyCount" style="height: 60%;width: 60%;position: relative;left:25%;'"></div>
				                            </div>
			                       	 </div>
		                         </div>
		                         <!-- /饼图 -->
	                        </div>
	                        <div class="panel-footer">
	                            目前可以插入北京、上海、武汉、深圳地区的数据
	                        </div>
	                    </div>
	                </div>
	                <!--/ 饼图介绍 -->
					
					
				 </div>
				  <!-- /第二行展示公司统计 -->
				  	<hr>
				  <!-- 第三行展示技术统计 -->
				<div class="row">
			<!-- 条形图介绍 -->
					<div class="col-md-12">
	                    <div class="panel panel-danger">
		                        <div class="panel-heading"style="font-size: 1.7em">
		                          技术统计
		                        </div>
		                        <div class="panel-body">
			                            <p style="text-indent: 30px;font-size: 1.7em;line-height: 2em;">关于在面试时的会被问道的技术问题,大体上我们都搜集到了, 但是同学们似乎对记录信息并不感冒,有很多没有任何价值的记录哦. 不过我们还是能从中找到一些端倪,看看目前在面试时各位都会被问 到什么问题吧!</p>
								
										<div class="panel panel-default" style="width: 100%;border-color: white;">
				                            <div class="panel-heading" style="width: 100%"></div>
				                            <div class="panel-body">
				                                <div id="Skillchart" style="height: 60%;width: 100%" ></div>
				                  	</div>
								</div>
								
                        </div>
	                        <div class="panel-footer">
	                            目前展示的为所有地区的数据统计
	                        </div>
	                    </div>
	                </div>
	                <!-- /条形图介绍 -->
						
				</div> 
				<!-- /第三行展示技术统计 -->
				<hr/>
				<!-- 第四行展示面试统计 -->
			 <div class="row">
			 <!-- 条形图介绍 -->
					<div class="col-md-12">
	                    <div class="panel panel-danger">
	                        <div class="panel-heading"style="font-size: 1.7em">
	                          面试统计
	                        </div>
	                        <div class="panel-body">
	                            <p style="text-indent: 30px;font-size: 1.7em;line-height: 2em;">关于在面试时,面试公司的非技术性信息,也包括一些对应聘者
								的要求,对于青鸟的学员们,学历自然是最头疼的问题,然而似乎面试
								公司也很喜欢去查学历呢!同时过往的工作经验几乎都是虚假的,怎么
								处理能够通过面试呢?</p>
								<div class="panel panel-default" style="width: 100%;border-color: white;">
	                            <div class="panel-heading" style="width: 100%"></div>
	                            <div class="panel-body">
	                                <div id="Backgroundchart" style="height: 60%;width: 100%" ></div>
	                            </div>
						</div>
	                        </div>
	                        <div class="panel-footer">
	                            目前展示的为所有地区的数据统计
	                        </div>
	                    </div>
	                </div>
	                <!-- /条形图介绍 -->
							
				</div> 
					<!-- /第四行展示面试统计 -->
				
                <div class="row">
                   <!-- 预留 -->
                </div>
                <!-- /. ROW  -->
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
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	 <script src="echarts/echarts.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

      <script>
    
      </script>

</body>
</html>
