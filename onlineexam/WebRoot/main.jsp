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
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    <div data-options="region:'west',title:'用户目录',split:false,href:'west.jsp'"  style="width:220px;"></div>   
    <div data-options="region:'center',iconCls:'icon-large-clipart',title:'欢迎你。。。',href:'center.jsp'" style="overflow:hidden;"></div>   
</body> 
</html>
