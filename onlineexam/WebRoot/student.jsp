<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student.jsp' starting page</title>
    
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
    <div data-options="region:'north',split:false,title:'查询过滤'" style="height:70px;">
    	<form id="formUser">
		<table class="tableForm datagrid-toolbar">
		   <tr>
		   	<td align="right" height="30" width="50">账号</td>
		   	<td><input type="text" name="uid" id="uid"/></td>
		   	<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-search',plain:true" id="search">查询</a>
		   		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-clear',plain:true" id="clear">清空</a>
		   	</td>
		   </tr>
		</table>
		</form>
    </div>   

    <div data-options="region:'center',title:'用户列表'" >
    	<script type="text/javascript" src="myjs/student.js"></script>
  		<table id="datagridUser" >
 		 </table>	
    
    </div>   
</div> 
 
 
 
  
  
  
  
	<!--  
	<div id="toolbar">
		<form id="formUser">
		<table>
		   <tr>
		   	<td align="right" height="30" width="50">账号</td>
		   	<td><input type="text" name="uid" id="uid"/></td>
		   	<td align="right" height="30" width="60">用户名</td>
		   	<td><input type="text" name="loginname" id="loginname"/></td>
		   	<td align="right" height="30" width="50">密码</td>
		   	<td><input type="password" name="loginpass" id="loginpass"/></td>
		   </tr>
		</table>
		</form>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-add',plain:true" onClick="javascript:add();">增加</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-remove',plain:true" onClick="javascript:removeUser();">删除</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-edit',plain:true" onClick="javascript:update();">修改</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-search',plain:true"  onClick="javascript:search();">查询</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="selected:true,iconCls:'icon-clear',plain:true" onClick="javascript:clear();">清空</a>
	
	</div>
  -->
  
  </body>
</html>
