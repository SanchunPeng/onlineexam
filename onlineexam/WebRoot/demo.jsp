<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
    td{
    width:100px;
    height:30px;
    }
    </style>
    <title>My JSP 'demo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.min.js"></script> 
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
  <link id="easyuiTheme" rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script> 
  <!-- cookie插件 -->
  <script type="text/javascript" src="js/jquery.cookie.js"></script>
  
  <script type="text/javascript" src="myjs/pf.js"></script>
  
  
  
  <script type="text/javascript">
  	$(function(){
  		$('#layout').layout();
  	});
  </script>
  </head>
  


  
 <body id="layout">   
    <div data-options="region:'north',split:false,collapsible:false,href:'north.jsp'" style="height:100px;">
    </div>  
    
     
    <div data-options="region:'south',split:false,collapsible:false" style="height:35px;">
    	<p align="center">版权声明-浙江理工大学</p>
    </div>  
    
       
    <div data-options="region:'west',title:'用户信息',split:false"  style="width:250px;">
    	<table>
  	   <tr>
  	   	<td width="90" >课程名称：</td>
  	   	<td>汇编语言</td>
  	   </tr>
  	   <tr>
  	   	<td width="90" >授课老师：</td>
  	   	<td>XX老师</td>
  	   </tr>
  	   <tr>
  	   	<td width="90" >授课时间：</td>
  	   	<td>星期XX的第XX节课</td>
  	   </tr>
  	   <tr>
  	   	<td width="90" >考试时间：</td>
  	   	<td>2016年X月X日</td>
  	   </tr>
  	</table>
    </div>  
    
    
    <div data-options="region:'east',title:'成绩信息',split:false"  style="width:250px;">
    	<table>
  	   <tr>
  	   	<td width="100" align="right">课程名称：</td>
  	   	<td>汇编语言</td>
  	   </tr>
  	   <tr>
  	   	<td width="100" align="right">学生姓名：</td>
  	   	<td>${sessionScope.sessionStudent.loginname}</td>
  	   </tr>
  	   <tr>
  	   	<td width="100" align="right">总分：</td>
  	   	<td>${sessionScope.sessionScore.score}</td>
  	   </tr>
  	   <tr>
  	   	<td width="100" align="right">选择题分数：</td>
  	   	<td>${sessionScope.sessionScore.selectScore}</td>
  	   </tr>
  	   <tr>
  	   	<td width="100" align="right">判断题分数：</td>
  	   	<td>${sessionScope.sessionScore.judge}</td>
  	   </tr>
  	   <tr>
  	   	<td width="100" align="right">填空题分数：</td>
  	   	<td>${sessionScope.sessionScore.cloze}</td>
  	   </tr>
  	   <tr>
  	   	<td width="100" align="right">程序题分数：</td>
  	   	<td>${sessionScope.sessionScore.program}</td>
  	   </tr>
  	</table>
    </div>
    
    
    <div data-options="region:'center',iconCls:'icon-large-clipart',title:'欢迎你。。。${sessionScope.sessionStudent.loginname}'" style="overflow:hidden;">
    	<h2 style="margin-left:140px">欢迎同学们登录汇编程序在线考试系统</h2>
  		<h2 style="margin-left:140px;margin-top:30px">你已完成考试，请在右侧查看成绩信息</h2>
 

    </div>   
</body> 
</html>
