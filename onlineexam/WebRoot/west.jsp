<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'west.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body id="indexLayout" class="easyui-layout">
   	<ul id="tt" style="font-size:16px"></ul>  
   	<script type="text/javascript">
   	  $(function (){
   		  	var data=[{    
   		    "id": 1,    
   		    "text": "试卷类别管理",    
   		    "state": "open",    
   		    "children": [{    
   		        "id": 11,    
   		        "text": "单选题管理" ,
   		     	"attributes":{
   		     		url:"/question/singleSelect.jsp"
   		     	}
   		    },{    
   		        "id": 12,    
   		        "text": "判断题管理" ,
   		     "attributes":{
		     		url:"judge.jsp"
		     	}
   		    },{    
		        "id": 13,    
		        "text": "填空题管理" ,
		        "attributes":{
   		     		url:"cloze.jsp"
   		     	}
		    },{    
		        "id": 13,    
		        "text": "程序题管理" ,
		        "attributes":{
   		     		url:"program.jsp"
   		     	}
		    }]    
   		},{    
   		    "id": 2,    
   		    "text": "试卷制定",    
   		    "state": "open",
   		 	"children": [{    
		        "id": 21,    
		        "text": "试卷制定",
		        "attributes":{
   		     		url:"made1.jsp"
   		     	}
		    }]
   		},{    
   		    "id": 3,    
   		    "text": "用户管理",    
   		    "state": "open",
   		 	"children": [{    
		        "id": 31,    
		        "text": "用户管理",
		        "attributes":{
   		     		url:"student.jsp"
   		     	}
		    },{    
		        "id": 32,    
		        "text": "用户成绩管理" ,
		        "attributes":{
   		     		url:"score.jsp"
   		     	}
		    }]
   		},{    
   		    "id": 4,    
   		    "text": "已提交程序题管理",    
   		    "state": "open",
   		 	"children": [{    
		        "id": 41,    
		        "text": "已提交程序题管理",
		        "attributes":{
   		     		url:"programSubmit.jsp"
   		     	}
		    }]
   		}];  
   		$('#tt').tree();
   		$('#tt').tree({
   			data:data,
   			onClick: function(node){
   				//alert(node.text);
   				addTab(node);  // 在用户点击的时候提示
   			}

   		});
   	  });
   	
   	</script>
   	
   	
   	
  </body>
</html>
