<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>管理客户</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="keywords" content="" />
<meta name="description" content="" />
<

<link href="css/css.css" rel="stylesheet" />
<script src="js/jquery-1.9.1.min.js"></script>
<link href="css/animate.min.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet"/>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script language="JavaScript" type="text/javascript" src="js/souye.js"></script>
<script src="echarts/echarts.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
  
  <body>
    <div id="table1" style="width: 60%; float: left; margin-left:20%;margin-top:50px">
		<table class="table table-hover">
	<caption>
		
		<div class="box-body">
		     
              <div class="row" style="float: left; margin-left:25%;">
              <div class="col-xs-3">
               <button type="button" class="btn btn-info btn-sm" id="shoucang">收藏公司</button> 
             </div>
                <div class="col-xs-3"> 
                	班级:  
                	<br/>      
                   <select style="width: 100%;height: 33px">
                      <option>DT53</option>
                      <option>DT52</option>
                   </select>      
                </div>
                <div class="col-xs-3">
                	用户姓名:
                  <input type="text" class="form-control" placeholder="用户姓名">
                </div>
                <div class="col-xs-3">
                	用户ID:
                  <input type="text" class="form-control" placeholder="用户ID">
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
		    <th><input type="checkbox" name="checkbox" id="checkbox" />全选</th>
			<th>用户ID</th>
			<th>用户姓名</th>
			<th>用户电话</th>
			<th>用户邮箱</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		    <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>武汉天成有限公司</td>
			<td>武汉</td>
			<td>ssm,js,java</td>
			<td>详情</td>
			<td>收藏</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>深圳天成有限公司</td>
			<td>深圳</td>
			<td>ssm,js,SpringBoot</td>
			<div><td>详情</td></div>
			<td>收藏</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>560001</td>
			<td>560001</td>
			<td>411027</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
		<tr>
		 <td><input type="checkbox" name="checkbox" id="checkbox" /></td>
			<td>Uma</td>
			<td>Pune</td>
			<td>411027</td>
			<td>560001</td>
			<td>560001</td>
		</tr>
	</tbody>
   </table>
</div>
  </body>
</html>
