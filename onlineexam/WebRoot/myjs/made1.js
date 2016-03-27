$(function(){
	
	
});
function submit(){
	if(confirm("你确定要重新组卷吗？")){
		var editRow=undefined;
		$('#datagridMade').datagrid({
		url:'/onlineexam/Made1Servlet',
		pagination:true,
		fit:true,
		fitColumns:true,
		nowrap:false,
		idField:'type',
		queryParams: {
			method:'datagridMade'
		},
		columns:[[{
			title:'题目类型',
			field:'type',
			width:30
		},{
			title:'题目ID列表',
			field:'idString',
			width:30
		}
		]]
	});
  		/*$.ajax({
			cache: false,
			async: false,
			type: "POST",
			dataType: "json",
			data: $('#examForm').serialize(),
			url: "/onlineexam/Made1Servlet",
			success:function(data){				
  				if(data.success){
  					$.messager.alert('结果',data.msg,function(r){
  						if(r){
  							window.location.href="/onlineexam/loginStudent.jsp";
  						}
  						
  					});
  				}
  			}
		});*/
  	} 

}
