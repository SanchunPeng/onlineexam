<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
   <div id="cc" class="easyui-layout" fit="true">   
    <div data-options="region:'center',title:'首页'" >
    	<script type="text/javascript"></script>
		<h1>欢迎使用汇编程序在线考试后台管理系统</h1>
		<ul style="font-size:16px">
			<span>系统功能</span>
			<li>1.试卷类别管理</li>
			    <ul>
			        <li>选择题管理：可以进行按钮添加，修改，删除，也可以进行双击修改，在修改删除的时候必须进行选择，修改后保存。也可以在选择后进行试卷制定。</li>		    
			    	<li>判断题管理：可以进行按钮添加，修改，删除，也可以进行双击修改，在修改删除的时候必须进行选择，修改后保存。也可以在选择后进行试卷制定。</li>	
			    	<li>填空题管理：可以进行按钮添加，修改，删除，也可以进行双击修改，在修改删除的时候必须进行选择，修改后保存。也可以在选择后进行试卷制定。</li>	
			    </ul>
			<li>2.试卷制定</li>
				<ul>
			      	<li>试卷制定：可以进行题型和难易程度，章节以及分数的选择进行组卷。
			      	</li> 	    
			    </ul>
			<li>3.用户管理</li>
				<ul>
			      	<li>用户管理：对学生的信息进行添加，修改，删除，查询，学生的密码统一设置为123456</li> 	    
			    </ul>
			<li>4.用户成绩管理</li>
				<ul>
			      	<li>用户成绩管理：前台学生登录后考试成绩会在这里显示。可以进行成绩分析，不同分数段的选择</li> 	    
			    </ul>
			<li>5.已提交的程序题管理</li>
				<ul>
			      	<li>用户成绩管理：学生考试提交后学生的程序题会显示在这里，老师可以根据学生提交的答案进行打分。</li> 	    
			    </ul>
		</ul>
    </div>   
  </body>
</html>
