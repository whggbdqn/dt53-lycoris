<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">

</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html"><strong>TeamLycoris</strong></a>

			<div id="sideNav" href="">
				<i class="fa fa-caret-right"></i>
			</div>
		</div>

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#" aria-expanded="false"> <i
					class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> 登出</a></li>
				</ul> <!-- /.dropdown-user --></li>
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
                        <a href="userProfile.jsp"style="font-size: 1.7em"><i class="fa fa-qrcode"></i>个人信息</a>
                    </li>
                   <li>
                        <a href="#" style="font-size: 1.7em"><i class="fa fa-sitemap"></i> 管理员入口<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
		                            <li>
		                                <a href="adminUser.jsp"  class="active-menu">数据导入</a>
		                            </li>
		                            <li>
		                                <a href="getCompanyForM.do" >数据管理</a>
		                            </li>
	                           </ul>
                      </li>
			</ul>

		</div>

		</nav>
		<!-- /. NAV SIDE  -->

		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">北大青鸟</h1>
				<ol class="breadcrumb">
					<li><a href="homepage.jsp">首页</a></li>
					<li class="active"><a href="adminUser.jsp">管理员页面</a></li>
				</ol>
			</div>
			<div id="page-inner">

				<!-- /. ROW  -->

				<div class="row"></div>
				<!--/.row-->


				<div class="row">
					<!-- 第一個表格 -->
					<div class="col-md-12 ">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3>表格操作说明</h3>
							</div>
							<div class="panel-body">
								<h3>请点击选择文件选择填写好的面试反馈表.xlxs进行上传，提交时数据库会自动将表中数据对 应写入数据库。</h3>
								<br> <br>
								<!-- 文件上传板块 -->
								<form action=uploadExcel.do method="post"
									enctype="multipart/form-data" id="form1">
									<input id="excel_file" type="file" name="pfile" accept="xlsx"
										size="30" /><br>
									<div class="alert alert-success">
										<strong style="font-size: 22px;" >操作状态：</strong><span style="font-size: 22px;" class="info"> ${info }</span>
									</div>
									<button id="excel_button" type="submit"
										class="btn btn-default btn-lg">导入Excel</button>
								</form>
								<!-- 文件下载板块 -->
								<a onclick="dataGo()" class="btn btn-success btn-lg">开始数据处理</a><span
									 style="font-size: 24px;color: red;"></span> <a
									href=downloadExcel.do class="btn btn-danger btn-lg"
									style="position: relative;left:65%;">模板下载</a>
							</div>
							<div class="panel-footer">
								<span style="color: red">注意:不同类型的文件无法上传！</span>
							</div>
						</div>
					</div>

					<!-- 第二個表格 -->
					<div class="col-md-12 ">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3>Excel模板示例</h3>
							</div>
							<div class="panel-body">
								<!--    Striped Rows Table  -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h3>下图是下载表格示例，其中每一列分别为:</h3>
									</div>
									<div class="panel-body">
										<div class="table-responsive">
											<table class="table table-striped">
												<tbody>
													<tr>
														<td>①公司名称</td>
														<td>(必填，请填写公司全名)</td>
													</tr>
													<tr>
														<td>②特点</td>
														<td>(选填，填写面试情况，具体见表中示例)</td>
													</tr>
													<tr>
														<td>③公司地区</td>
														<td>(必填，公司所在地名称)</td>
													</tr>
													<tr>
														<td>④邮箱</td>
														<td>(选填，公司的企业真实邮箱)</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<span style="font-size: 25px;">示例：</span>
					<div class="picture">
						<img src="img/a.png" width="1100px"
							style="position: relative;left: 10%;">
					</div>



					<div class="row">
						<!-- 预留 -->
					</div>
					<!-- /. ROW  -->


				</div>
				<footer>
				<p>Copyright &copy; 2018.By TeamLycoris</p>
				</footer>
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
