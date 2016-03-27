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
    
    <title>My JSP 'logintwo.jsp' starting page</title>
    
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
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script> 

  <script type="text/javascript" src="myjs/loginManager.js"></script></head>
  
  <body>
    <div id="login" title="管理员登录" style="width:300px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true">   
	  <form action="" id="loginInputForm" method="post">
	  <table>
	  <tr>
			<th ><label class="errorClass" id="msg">${msg }</label></th>
			<td >
				
			</td>	
		</tr>
	  	<tr>
			<th align="right" height="60" width="80">用户名</th>
			<td >
				<input type="text" id="name" name="name" value="${name}"/>
			</td>	
		</tr>
		<tr>
			<th align="right"  height="40" width="80">密码</th>
			<td >
				<input type="password" id="password" name="password" value="${password }"/>
			</td>		
		</tr>
	  </table>
	  
	  </form>
  
  </div>  
  </body>
</html>
