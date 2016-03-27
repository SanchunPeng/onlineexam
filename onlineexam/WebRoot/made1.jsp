<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'made1.jsp' starting page</title>
    
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
   <div id="cc" class="easyui-layout" fit="true">   
   <div data-options="region:'north'" style="height:250px"> 
    <table>
    	<tr>
    		<td>选择题：</td>
    		<td>
    		<input id="selectGrade" class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'programEsay',value: '易'},{label: 'programDefficult',value: '难'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?grade='+value+'&method=changeFromSelectGrade';    
						$('#select').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>分数：</td>
    		<td>
    		<select name="selectScore" class="easyui-combobox" style="width:100px;">
				  <option value="score1">0</option>
				  <option value="score2">30</option>
				  <option value="score3">40</option>
				  <option value="score4">50</option>
			</select>
    		</td>
    		<td width="30px"></td>
    		<td>知识点：</td>
    		<td>
    		<input id="program1"  class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'chapter1',value: '第一章'},{label: 'chapter2',value: '第二章'},{label: 'chapter3',value: '第三章'},{label: 'chapter4',value: '第四章'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?chapter='+value+'&method=changeFromSelectChapter';    
						$('#select').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>题目：</td>
    		<td>
    		<input id="select" class="easyui-combobox" data-options="valueField:'id',textField:'question'"  style="width:450px;"/>  
    		</td>
    	</tr>
    	<tr height="15px"></tr>
    	<tr>
    		<td>判断题：</td>	
    		<td>
    		<input id="judgeGrade" class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'programEsay',value: '易'},{label: 'programDefficult',value: '难'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?grade='+value+'&method=changeFromJudgeGrade';    
						$('#judge').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>分数：</td>
			<td>
    		<select name="judgeScore" class="easyui-combobox" style="width:100px;">
				  <option value="score1">0</option>
				  <option value="score2">30</option>
				  <option value="score3">40</option>
				  <option value="score4">50</option>
			</select>
    		</td>
    		<td width="30px"></td>
    		<td>知识点：</td>
    		<td>
    		<input id="program1"  class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'chapter1',value: '第一章'},{label: 'chapter2',value: '第二章'},{label: 'chapter3',value: '第三章'},{label: 'chapter4',value: '第四章'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?chapter='+value+'&method=changeFromJudgeChapter';    
						$('#judge').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>题目：</td>
    		<td>
    		<input id="judge" class="easyui-combobox" data-options="valueField:'id',textField:'question'"  style="width:450px;"/>  
    		</td>
    	</tr>
    	<tr height="15px"></tr>
    	<tr>
    		<td>填空题：</td>
			<td>
    		<input id="clozeGrade" class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'programEsay',value: '易'},{label: 'programDefficult',value: '难'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?grade='+value+'&method=changeFromClozeGrade';    
						$('#cloze').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>分数：</td>
    		<td>
    		<select name="clozeScore" class="easyui-combobox" style="width:100px;"> 
				  <option value="score1">0</option>
				  <option value="score2">30</option>
				  <option value="score3">40</option>
				  <option value="score4">50</option>
			</select>
    		</td>
    		<td width="30px"></td>
    		<td>知识点：</td>
    		<td>
    		<input id="clozeChapter" class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'chapter1',value: '第一章'},{label: 'chapter2',value: '第二章'},{label: 'chapter3',value: '第三章'},{label: 'chapter4',value: '第四章'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?chapter='+value+'&method=changeFromClozeChapter';    
						$('#cloze').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>题目：</td>
    		<td>
    		<input id="cloze" class="easyui-combobox" data-options="valueField:'id',textField:'question'"  style="width:450px;"/>  


    		</td>
    	</tr>
    	<tr height="15px"></tr>
    	<tr>
    		<td>程序题：</td>
			<td>
    		<input id="programScore1" class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'programEsay',value: '易'},{label: 'programDefficult',value: '难'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?grade='+value+'&method=changeFromScore';    
						$('#program2').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>分数：</td>
    		<td>
    		<select name="programScore" class="easyui-combobox" style="width:100px;"> 
				  <option value="score1">0</option>
				  <option value="score2">10</option>
			</select>
    		</td>
    		<td width="30px"></td>
    		<td>知识点：</td>
    		<td>
    		<input id="program1" name="program" class="easyui-combobox" style="width:100px;" data-options="valueField:'label',textField:'value',
    				data: [{label: 'chapter1',value: '第一章'},{label: 'chapter2',value: '第二章'},{label: 'chapter3',value: '第三章'},{label: 'chapter4',value: '第四章'}],
    				onSelect: function(rec){
    				    var value=rec.label;     				    
          			  	var url = '/onlineexam/SelectChangeServlet?chapter='+value+'&method=change';    
						$('#program2').combobox('reload', url); 
       		 		}  
        	"
    		/>
    		</td>
    		<td width="30px"></td>
    		<td>题目：</td>
    		<td>
    		<input id="program2" class="easyui-combobox" data-options="valueField:'id',textField:'question'"  style="width:450px;"/>  
    		</td>
    	</tr>
    </table>
    
    <table style="margin-left:20px;font-size:40px">
	<tr height="20px"></tr>
	  <tr >
	  	<td ><input type="button"  value="组卷" onclick="submit()"/></td>
	  </tr>
	  <tr height="20px">
	  </tr>
	</table> 
	
	</div>
	<div data-options="region:'center'"  style="height:200px">
  		<table id="datagridMade" >
 		</table>	
    </div>  
     <script type="text/javascript" src="myjs/made1.js"></script>
      </div>  
  </body>
</html>
