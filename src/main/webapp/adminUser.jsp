<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>青鸟管理员页面</title>
    
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
                        <a href="homepage.jsp"style="font-size: 1.7em"><i class="fa fa-qrcode"></i>个人信息</a>
                    </li>
                    
                    <li>
                        <a href="adminUser.jsp"style="font-size: 1.7em" class="active-menu" ><i class="fa fa-table"></i> 管理员入口</a>
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
					  <li ><a href="homepage.jsp">首页</a></li>
					  <li class="active"><a href="adminUser.jsp">管理员页面</a></li>
					</ol> 
		</div>
            <div id="page-inner">

                <!-- /. ROW  -->
	
		<div class="row">
			
		</div><!--/.row-->
			
		
                <div class="row">
                 	<div class="uploadContext"  style=" width: 750px">
                 	<h3>
                	请点击选择文件选择填写好的面试反馈表.xlxs进行上传，提交时数据库会自动将表中数据对
                	应写入数据库，如Excel不对或文件格式不对将无法上传，请注意！</h3><br>
                	</div>
                <!-- 文件上传板块 -->
                   <form action=uploadExcel.do method="post" enctype="multipart/form-data" id="form1">
			            <input id="excel_file" type="file" name="pfile" accept="xlsx" size="30" /><br>	${info }<br><br>	
			             <button  id="excel_button" type="submit" class="btn btn-default">导入Excel</button>
			            <!-- <input id="excel_button" type="submit" value="导入Excel" /> -->
    				</form>
                </div>
				
				<div class="row">
				<!-- 文件下载板块 -->
					 <a href=downloadExcel.do class="btn btn-primary btn-lg">模板下载</a>
					<a onclick="dataGo()" class="btn btn-primary btn-lg">开始数据处理</a><span class="info" style="font-size: 24px;color: red;"></span>
				</div> <br><br><br><br>
			
				
                <div class="row">
                   <div class="col-md-4 col-sm-4">
                        <div  style="font-size: 20px">
                        	上图是下载表格示例，其中每一列分别为:<br><br>
                			公司名称(必填，请填写公司全名)<br>
                			特点(选填，填写面试情况，具体见表中示例)<br>
                			公司地区(必填，公司所在地名称)<br>
                			邮箱(选填，公司的企业真实邮箱)<br><br>
                			填写后将该文件上传即可！
                        </div>
                        <div class="panel-footer">
						<img  src="img/a.png" width="1100px">
                        </div>
                    </div>
                </div>
                
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
    <!-- Custom Js -->
    <script src="assets/js/adminUser.js"></script>

      <script>
    
      </script>

</body>
</html>
