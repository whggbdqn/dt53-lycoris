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
                        <li><a href=""><i class="fa fa-user fa-fw"></i> 登录</a>
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
                        <a href="#" style="font-size: 1.7em"><i class="fa fa-sitemap"></i> 管理员入口<span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level">
		                            <li>
		                                <a href="adminUser.jsp">数据导入</a>
		                            </li>
		                            <li>
		                                 <a href="CompanyManage.jsp" class="active-menu" >数据管理</a>
		                            </li>
	                           </ul>
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
		                            Primary Panel
		                        </div>
		                        <div class="panel-body">
		                           <!-- 个人信息 -->
									              	 	<div class="col-md-3">
										                    <div class="panel panel-default">
												                        <div class="panel-heading">
												                          我的信息
												                        </div>
														                        <div class="panel-body">
															                        <div class="col-md-4 col-md-offset-4">
															                       		  <div class="form-group">
												                                          	  <p class="form-control-static">姓名</p>
												                                          	   <p class="form-control-static">邮箱</p>
												                                          	    <p class="form-control-static">班级</p>
												                                          	     <p class="form-control-static">意向城市</p>
											                                       		 </div>
											                                       		 	<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
																							    修改信息
																							</button>
											                                       	</div>
														                        </div>
										                        <div class="panel-footer">
										                            Panel Footer
										                        </div>
				                   						 </div>
            		   			</div>
				                   			<!-- /个人信息 -->		
            		   			<!-- 表格-->	
				                   				<div class="col-md-8">
					                   				<div class="panel panel-default">
					                   					 <div class="panel-heading"> 收藏的公司</div>
					                   					   <div class="panel-body">
					                   					   		  <div class="table-responsive">
                              									  <table class="table table-striped table-bordered table-hover" id="dataTables-example">
								                                  <thead>
								                                        <tr>
								                                            <th>Rendering engine</th>
								                                            <th>Browser</th>
								                                            <th>Platform(s)</th>
								                                            <th>Engine version</th>
								                                            <th>CSS grade</th>
								                                        </tr>
								                                    </thead>
								                                    <tbody>
								                                        <tr class="odd gradeX">
								                                            <td>Trident</td>
								                                            <td>Internet Explorer 4.0</td>
								                                            <td>Win 95+</td>
								                                            <td class="center">4</td>
								                                            <td class="center">X</td>
								                                        </tr>
								                                    </tbody>
                                								</table>
                           									 </div>
					                   					   </div>
					                   				</div>
				                   				</div>
				                   			<!-- /表格 -->
		                        </div>
		                    </div>
              	 
			                        	
              	 			</div>
	                </div>





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
 <!-- Custom Js -->
    <script src="assets/js/goCompany.js"></script>
       <script>
            $(document).ready(function () {
                 $('#dataTables-example').dataTable({
"sScrollX": "100%",   //表格的宽度
  "sScrollXInner": "110%",   //表格的内容宽度
  "bScrollCollapse": true,  //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false) 
"bPaginate": true,  //是否显示分页
  "bLengthChange": true,  //每页显示的记录数
  "bFilter": true, //搜索栏
  "bInfo": true, //显示表格信息
  "bAutoWidth": true,  //自适应宽度
  "aoColumns": [
      null,
      null,
      null,
      {
          "bSearchable": false, //参与搜索
      }
  ], //列设置，表有几列，数组就有几项
   "bStateSave": true, //保存状态到cookie *************** 很重要 ， 当搜索的时候页面一刷新会导致搜索的消失。使用这个属性就可避免了
  "sPaginationType": "full_numbers", //分页，一共两种样式，full_numbers和two_button(默认)
  "oLanguage": {
      "sLengthMenu": "每页显示 _MENU_ 条记录",
      "sZeroRecords": "对不起，查询不到任何相关数据",
      "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
      "sInfoEmtpy": "找不到相关数据",
      "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
      "sProcessing": "正在加载中...",
      "sSearch": "搜索",
      "oPaginate": {
          "sFirst":    "第一页",
          "sPrevious": " 上一页 ",
          "sNext":     " 下一页 ",
          "sLast":     " 最后一页 "
      }
  }, //多语言配置
 "bJQueryUI": false, //可以添加 jqury的ui theme  需要添加css
       "aLengthMenu": [[10, 25, 50, -1, 0], ["每页10条", "每页25条", "每页50条", "显示所有数据", "不显示数据"]]  //设置每页显示记录的下拉菜单
    });
});
    </script>
</body>
</html>
