<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserMassage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<table>
  	   <tr>
  	   	<td width="90">课程名称：</td>
  	   	<td>汇编语言</td>
  	   </tr>
  	   <tr>
  	   	<td width="90">授课老师：</td>
  	   	<td>XX老师</td>
  	   </tr>
  	   <tr>
  	   	<td width="90">授课时间：</td>
  	   	<td>星期XX的第XX节课</td>
  	   </tr>
  	   <tr>
  	   	<td width="90">考试时间：</td>
  	   	<td>2016年X月X日</td>
  	   </tr>
  	</table>
    
  </body>
</html>
