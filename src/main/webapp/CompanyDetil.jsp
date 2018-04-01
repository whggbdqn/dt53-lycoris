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
                        <a href="goCompany.do" style="font-size: 1.7em" class="active-menu" ><i class="fa fa-desktop"></i> 浏览公司</a>
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
					  <li ><a href="homepange.jsp">首页</a></li>
					   <li class="active"><a href="goCompany.do">浏览公司</a></li>
					</ol> 
		</div>
            <div id="page-inner">

                <!-- /. ROW  -->
	
		<div class="row">
                <div class="col-md-12">
                    <div class="jumbotron">
                        <h2>${company.companyname } 
                       			  <c:if test="${not empty company.companyemail }">
                        				<a style="font-size: 16px;cursor: pointer;">${company.companyemail }</a>
                    			  </c:if>
                       			 <c:if test="${empty company.companyemail }">
                        				<a style="font-size: 16px;cursor: pointer;">暂无公司邮箱</a>
                    			  </c:if>
                       </h2>
                       <c:if test="${not empty company.companyinfo }">
                        	<p style="text-indent: 36px;font-size: 18px;">${company.companyinfo }</p>
                       </c:if>
                        <c:if test="${empty company.companyinfo }">
                        	<p style="text-indent: 36px;font-size: 18px;">暂无公司详细信息</p>
                       </c:if>
                         	<input type="hidden" value="${company.id }" id="companyid">
                             <div class="panel panel-default" style="width: 100%;border-color: white;">
		                            <div class="panel-heading" style="width: 100%;font-size: 20px;">这是该公司在过往的面试中会问的问题哦!</div>
	                              		<div id="companyDetilCharts" style="height: 600px;width: 100%;margin-bottom: 50px;border-color: white;"></div>
	                           		</div>
                              </div>
                    </div>
                </div>
                 
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
