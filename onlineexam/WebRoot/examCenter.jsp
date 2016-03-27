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
    
    <title>开始考试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style> 
	.table-a table{border:2px solid #5CACEE} 

	#nav { width:150px; height: 200px; border: 2px solid #5CACEE; position:fixed;left:0;top:60% }


	</style>
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.min.js"></script> 
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script> 
 <script type="text/javascript" src="myjs/clock.js"></script>

  
  <script type="text/javascript" src="myjs/examCenter.js"></script>
  </head>
  
  <body>
  <div id="nav">
  	<h3>距离考试还剩时间：</h3>
  	<input style="font-size:30px" type="button" name="mss" id="mss"/>
  </div>

    <h2 style="margin-left:200px">一.选择题（每题3分，共30分）</h2>
    <div class="table-a">
    <form action="<c:url value='/ExamServlet'/>" id="examForm">
    <input type="hidden" name="method" value="count"/>
	<table border="0" width="70%" align="center">

	<c:forEach items="${requestScope.selectList}" var="select" varStatus="num">
	<tr height="40px">
		<td align="left">${num.index +1 }.${select.question }</td>
	</tr>
	<tr height="40px">
		<td align="left">
			<input type="radio" name="selectOption${num.index+1}" value="A" id="optionA"/>
			<label for="optionA">${select.optionA }</label>
			
			<input type="radio" name="selectOption${num.index+1}" value="B" id="optionB"/>
			<label for="optionB">${select.optionB }</label>
			
			<input type="radio" name="selectOption${num.index+1}" value="C" id="optionC"/>
			<label for="optionC">${select.optionC }</label>
			
			<input type="radio" name="selectOption${num.index+1}" value="D" id="optionD"/>
			<label for="optionD">${select.optionD }</label>
		
		
		</td>
	</tr>
	</c:forEach>
	</table>
	
	</div>
	
	<h2 style="margin-left:200px">二.判断题（每题3分，共30分）</h2>
	<div class="table-a">
	<table border="0" width="70%" align="center"  cellpadding="0" cellspacing="1">

	<c:forEach items="${requestScope.judgeList}" var="judge" varStatus="num">
	<tr height="40px">
		<td align="left">${num.index +1 }.${judge.question }</td>
	</tr>
	<tr height="40px">
		<td align="left">
			<input type="radio" name="judgeOption${num.index+1}" value="one" id="optionOne"/>
			<label for="optionOne">对</label>
			
			<input type="radio" name="judgeOption${num.index+1}" value="two" id="optionTwo"/>
			<label for="optionTwo">错</label>	
		</td>
	</tr>
	</c:forEach>
	</table>

	</div>
	
	<h2 style="margin-left:200px">三.填空题（每题5分，共30分）</h2>
	<div class="table-a">
	<table border="0" width="70%" align="center">

	<c:forEach items="${requestScope.clozeList}" var="cloze" varStatus="num">
	<tr>
		<td align="left" height="40px" name="cloze">${num.index +1 }.${cloze.question }</td>
		<td align="left" height="40px">
			<input type="text" name="clzoe${num.index+3}"/>
		</td>
	</tr>
	</c:forEach>
	</table>
	</div>
	
	<h2 style="margin-left:200px">四.程序题（每题10分，共10分）</h2>
	<div class="table-a">
	<table border="0" width="70%" align="center">

	<c:forEach items="${requestScope.programList}" var="program" varStatus="num">
	<tr>
		<td align="left" height="40px" name="program">${num.index +1 }.${program.question }</td>
	</tr>
	<tr>
		<td>答案：</td>
	</tr>
	<tr>
		<td align="left" height="40px">
			<textarea rows="10" cols="110" name="program${num.index+1}"></textarea>
		</td>
	</tr>
	</c:forEach>
	</table>
	</form>
	</div>
	
	
	
	<table style="margin-left:200px;font-size:30px">
	<tr height="15px"></tr>
	  <tr >
	  	<td ><input type="image"  value="提交"  src="<c:url value='/image/submit.jpg'/>" onclick="submit()"/></td>
	  </tr>
	</table> 

  </body>
</html>
