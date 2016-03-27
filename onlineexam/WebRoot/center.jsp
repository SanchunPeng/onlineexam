<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'center.jsp' starting page</title>
    
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
<script type="text/javascript" src="myjs/center.js"></script>
<div class="easyui-tabs" id="centerTabs" fit="true">
	<div title="首页" href="index.jsp" ></div>
    <div title="单选题管理" href="singleSelect.jsp" closable=true></div>
    <div title="判断题管理" href="judge.jsp" closable=true></div>
    <div title="填空题管理" href="cloze.jsp" closable=true></div>
    <div title="程序题管理" href="program.jsp" closable=true></div>
    <div title="试卷制定" href="made1.jsp" closable=true></div>
	<div title="用户管理" href="student.jsp" closable=true></div>
    <div title="用户成绩管理" href="score.jsp"  closable=true> </div>
    <div title="已提交程序题管理" href="programSubmit.jsp" closable=true> </div>
</div>
    

  </body>
</html>
