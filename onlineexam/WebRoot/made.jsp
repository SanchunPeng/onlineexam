<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'made.jsp' starting page</title>
    
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

    <div data-options="region:'north',collapsible:true,title:'单选题'"  style="height:420px">
    	<script type="text/javascript" src="myjs/made.js"></script>
  		<table id="datagridSelectMade" >
  		</table>
    </div>  
     <div data-options="region:'center',collapsible:false,title:'判断题'" style="height:300px" >
    	<script type="text/javascript" src="myjs/made.js"></script>
  		<table id="datagridJudgeMade"  >
  		</table>
    </div>   
     <div data-options="region:'south',collapsible:true,title:'填空题'" style="height:420px" >
    	<script type="text/javascript" src="myjs/made.js"></script>
  		<table id="datagridClozeMade"  >
  		</table>
    </div> 
</div>   
    
    
  </body>
</html>
