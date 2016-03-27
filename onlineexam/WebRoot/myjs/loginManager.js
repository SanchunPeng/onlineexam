var login;
var loginInputForm;
  	$(function(){
  		loginInputForm=$('#loginInputForm').form({
  			url:"/onlineexam/LoginManagerServlet",
  			success:function(data){				
  				var data = eval("(" + data + ")");  
  				if(data.success){
  					login.dialog('close');
  					$.messager.show({
  		  				title:'提示',
  		  				msg:data.msg
  		  				});
  					window.location.href="/onlineexam/main.jsp";
  				}else{
  					$.messager.alert('警告',data.msg);
  				}
  			}
 			
  		});
  		login=$('#login').dialog({
  			closable:false,
  			buttons:[
  			      {
  			    	iconCls:'icon-ok',
  			    	text:'登录',
  					handler:function(){
  						loginInputForm.submit();
  					}
  			      },
  			      {
  			    	iconCls:'icon-reload',
  			    	text:'重置',
  			    	handler:function(){
  			    		$('#loginInputForm').form('reset');
  			    	}
  			    	  
  			      }
  			         
  			]
  		});
  		
  	});