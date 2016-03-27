<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'north.jsp' starting page</title>
    
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
<h1 align="center">汇编语言在线考试系统</h1>
<table style="margin-top:10px;margin-left:800px;">
 <tr>
  <td width="80px"><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onClick="changeTheme('bootstrap');">灰色皮肤</a></td>
  <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onClick="changeTheme('red');">红色皮肤</a></td>
  <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onClick="changeTheme('orange');">橘色皮肤</a></td>
  <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onClick="changeTheme('black');">黑色皮肤</a></td>
  <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onClick="changeTheme('green');">绿色皮肤</a></td>
  <td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"  onClick="changeTheme('default');">默认皮肤</a></td>
 </tr>
</table>
  </body>
</html>
