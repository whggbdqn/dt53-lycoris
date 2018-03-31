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
					  <li><a href="homepage.jsp">首页</a></li>
					  <li class="active"><a href="goCompany.do">浏览公司</a></li>
					</ol> 
		</div>
            <div id="page-inner">

                <div class="row">
                   <!-- 预留 -->
                </div>
                <!-- /. ROW  -->
                     <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            浏览所有公司
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>地区</th>
                                            <th>公司名称</th>
                                            <th>标签</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list }" var="c">
                                        <tr class="odd gradeX">
                                            <td>${c.areainfo }</td>
                                            <td>${c.companyname }</td>
                                             <td>
                                            <c:forEach items="${c.indexes }" var="i"  begin="0" end="4" step="1">
                                           		&lt; ${i.indexinfo } &gt;
                                            </c:forEach>
                                            </td>
                                            <td class="center"><a class='btn btn-primary ' href="CompanyDetil.do?id=${c.id }">详情</a></td>
                                        </tr>
                                      </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
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
    <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
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
    <!-- Custom Js -->
    <script src="assets/js/goCompany.js"></script>
      <script>
      </script>

</body>
</html>
