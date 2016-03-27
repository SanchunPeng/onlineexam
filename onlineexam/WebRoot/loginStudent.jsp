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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	 <style type="text/css">    
	 body{    
      background-image:url(image/bg.jpg); 
      background-repeat: repeat-x;
   	 }  
   	 .top{
   	  height:250px;
   	  width:750px;
   	  margin-top:1px;
   	  margin-left:280px;
   	  background-image:url(image/logo.jpg);
   	 }  
 	</style>
 <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.min.js"></script> 
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/icon.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script> 
 
 
 
 
  <script type="text/javascript" src="myjs/login.js"></script></head>
  
<body>
<div class="mian">
<div class="top">
</div>
<div class="bottom">
<form action="<c:url value='/LoginStudentServlet'/>" method="post" id="formLogin">
<!-- 向Servlet传递一个method参数，其值表示servlet调用那个方法 -->
<input type="hidden" name="method" value="loginValidate"/> 

<table border="0"  height="100px" width="750px" style="background-color:#5CACEE;margin-left:280px;margin-top:15px">
	<tr>
		 <td width="50"></td>
         <td><label class="errorClass" id="msg">${msg }</label></td>
         <td></td>
       
	</tr>
	<tr>
		<td width="290" align="right">用户名</td>
		<td ><input class="inputClass" type="text" name="loginname" id="loginname" value="${student.loginname }"/></td>
		<td ><label class="errorClass" id="loginnameError" >${errors.loginname }</label></td>
	</tr>
	<tr height="15"></tr>
	<tr>	
		<td width="290" align="right">密码</td>
		<td ><input class="inputClass" type="password" name="loginpass" id="loginpass" value="${student.loginpass }"/></td>		
		<td><label class="errorClass" id="loginpassError">${errors.loginpass }</label></td>
	</tr>
	<tr height="15"></tr>
	<tr>				
		<td width="290" align="right">验证码</td>
		<td ><input class="inputClass" type="text" name="verifyCode" id="verifyCode" value="${student.verifyCode }"/></td>
		<td><label class="errorClass" id="verifyCodeError">${errors.verifyCode}</label> </td>
	</tr>
	<tr height="15"></tr>
	<tr>
		<td width="290" align="right"></td>
		<td><img id="imgVcode" src="/onlineexam/VerifyCodeServlet"/><a  href="javascript:_hyz()">换一张</a></td>
		<td></td>	
		
	</tr>
	<tr height="15"></tr>
	<tr>
		<td width="290" align="right"></td>
		<td><input type="button"  value="登录" id="submit" onclick="javascript:login()"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置"/>
		</td>	
	</tr>
</table>

</form>
</div>
</div>      
</body>
</html>
