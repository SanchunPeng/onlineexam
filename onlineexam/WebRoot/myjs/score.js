
$(function(){
			var editRow=undefined;
			$('#datagridScore').datagrid({
			url:'/onlineexam/ScoreServlet',
			pagination:true,
			pagesize:10,
			pageList:[10,20,30,40],
			fit:true,
			fitColumns:true,
			idField:'uid',
			queryParams: {
				method:'datagridScore'
			},
			columns:[[{
				title:'ID',
				field:'id',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入ID'
					}
				}
			},{
				title:'用户名',
				field:'studentName',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入用户名'
					}
				}
			},{
				title:'成绩',
				field:'score',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入成绩'
					}
				}
			},{
				title:'选择题成绩',
				field:'selectScore',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入选择题成绩'
					}
				}
			},{
				title:'判断题成绩',
				field:'judge',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入判断题成绩'
					}
				}
			},{
				title:'填空题成绩',
				field:'cloze',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入填空题成绩'
					}
				}
			},{
				title:'程序题成绩',
				field:'program',
				width:70,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入程序题成绩'
					}
				}
			}]],
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				handler: function(){
					if(editRow!=undefined){
						$('#datagridScore').datagrid('endEdit',editRow);
					}else{
						$('#datagridScore').datagrid('insertRow',{
							index: 0,	// 索引从0开始
							row: {
								id: '',
								studentName: '',
								score: ''
							}
						});
						$('#datagridScore').datagrid('beginEdit',0);
						editRow=0;
						
					}
					

				}
			},'-',
			{
				text:'删除',
				iconCls:'icon-remove',
				handler: function(){
					var rows=$('#datagridScore').datagrid('getSelections');
					if(rows.length>0){
						$.messager.confirm('确认','您确定要删除所选择的记录吗？',function(r){    
						    if (r){  
						    	var ids=[];
						    	for(var i=0;i<rows.length;i++){
						    		ids.push(rows[i].uid);
						    	}
						    	//console.info(ids.join());
						        //alert('确认删除');
						    	$.ajax({
									cache: false,
									async: false,
									type: "POST",
									dataType: "json",
									data: {method: "removeScore", uidString: ids.join()},
									url: "/onlineexam/ScoreServlet",
									success: function(flag) {
										$('#datagridScore').datagrid('load');			
									}
								});
						    }    
						}); 
					}else{
						$.messager.alert('提示','请选择要删除的记录','error');
					}
				}
			},'-',
			{
				text:'修改',
				iconCls:'icon-edit',
				handler: function(){
					var rows=$('#datagridScore').datagrid('getSelections');
					if(rows.length==1){
						if(editRow!=undefined){
							$('#datagridScore').datagrid('endEdit',editRow);
						}else{
							var rowIndex=$('#datagridScore').datagrid('getRowIndex',rows[0]);
							$('#datagridScore').datagrid('beginEdit',rowIndex);
							editRow=rowIndex;	
							$('#datagridScore').datagrid('unselectAll');
						}
					}
				}
			},'-',
			{
				text:'保存',
				iconCls:'icon-save',
				handler: function(){
					$('#datagridScore').datagrid('endEdit',editRow);//关闭编辑状态
				}
			},'-',
			{
				text:'取消编辑',
				iconCls:'icon-redo',
				handler: function(){
					editRow=undefined;
					$('#datagridScore').datagrid('rejectChanges');
					$('#datagridScore').datagrid('unselectAll');
				}
			},'-',
			{
				text:'60分以下',
				iconCls:'icon-add',
				handler: function(){
					$('#datagridScore').datagrid(                                                                                                                                                                                                       'load', {    
					    method:'query',
					    changeString:"score<60"
					});  
					
				}
			},'-',
			{
				text:'60分-70分',
				iconCls:'icon-add',
				handler: function(){
					$('#datagridScore').datagrid(                                                                                                                                                                                                       'load', {    
					    method:'query',
					    changeString:"score between 60 and 70"
					});  
				}
			},'-',
			{
				text:'70分-80分',
				iconCls:'icon-add',
				handler: function(){
					$('#datagridScore').datagrid(                                                                                                                                                                                                       'load', {    
					    method:'query',
					    changeString:"score between 70 and 80"
					});  
				}
			},'-',
			{
				text:'80分-90分',
				iconCls:'icon-add',
				handler: function(){
					$('#datagridScore').datagrid(                                                                                                                                                                                                       'load', {    
					    method:'query',
					    changeString:"score between 80 and 90"
					});  
				}
			},'-',
			{
				text:'90分-100分',
				iconCls:'icon-add',
				handler: function(){
					$('#datagridScore').datagrid(                                                                                                                                                                                                       'load', {    
					    method:'query',
					    changeString:"score between 90 and 100"
					});  
				}
			},'-',
			{
				text:'全部',
				iconCls:'icon-add',
				handler: function(){
					$('#datagridScore').datagrid(                                                                                                                                                                                                       'load', {    
					    method:'datagridScore'
					});  
				}
			},'-'],
			onAfterEdit:function(rowIndex, rowData, changes){
				console.info(rowData.uid);
				editRow=undefined;
				$.ajax({
					cache: false,
					async: false,
					type: "POST",
					dataType: "json",
					data: {method: "addScore", id: rowData.id,studentName:rowData.studentName,score:rowData.score},
					url: "/onlineexam/ScoreServlet",
					success: function(flag) {
						$.messager.show({
	  		  				title:'提示',
	  		  				msg:'添加成功'
	  		  				});			
					}
				});
			},
			onDblClickRow:function(rowIndex, rowData){
				if(editRow!=undefined){
					$('#datagridScore').datagrid('endEdit',editRow);
				}else{
					$('#datagridScore').datagrid('beginEdit',rowIndex);
					editRow=rowIndex;
					
				}
			}
		
			});
			$("#search").click(function(){
				$('#datagridScore').datagrid('load', {    
				    id:$('#formScore').find('[name=id]').val(),
				    method:'findById'
				}); 
				
			});
			$("#clear").click(function(){  
		        	$('#datagridScore').datagrid('load',{}); 
		        	$("#formScore").find('input').val('');
		        	$('#datagridScore').datagrid('load',{
		        		method:'datagridScore'
		        	});
		    });
	});

