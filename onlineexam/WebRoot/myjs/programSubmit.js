
$(function(){
			var editRow=undefined;
			$('#datagridProgramSubmit').datagrid({
			url:'/onlineexam/ProgramSubmitServlet',
			pagination:true,
			pagesize:10,
			pageList:[10,20,30,40],
			fit:true,
			fitColumns:true,
			nowrap:false,
			idField:'id',
			queryParams: {
				method:'datagridProgram'
			},
			columns:[[{
				title:'编号',
				field:'id',
				width:25
			},{
				title:'学生姓名',
				field:'studentName',
				width:30,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'学生姓名'
					}
				}
			},{
				title:'题干',
				field:'question',
				width:150,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'程序题题目'
					}
				}
			},{
				title:'学生答案',
				field:'studentAnswer',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'学生提交的答案'
					}
				}
			},{
				title:'分数',
				field:'getScore',
				width:25,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'该题的得分'
					}
				}
			}
			]],
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				handler: function(){
					if(editRow!=undefined){
						$('#datagridProgramSubmit').datagrid('endEdit',editRow);
					}else{
						$('#datagridProgramSubmit').datagrid('insertRow',{
							index: 0,	// 索引从0开始
						});
						$('#datagridProgramSubmit').datagrid('beginEdit',0);
						editRow=0;
						
					}
					

				}
			},'-',
			{
				text:'删除',
				iconCls:'icon-remove',
				handler: function(){
					var rows=$('#datagridProgramSubmit').datagrid('getSelections');
					if(rows.length>0){
						$.messager.confirm('确认','您确定要删除所选择的记录吗？',function(r){    
						    if (r){  
						    	var ids=[];
						    	for(var i=0;i<rows.length;i++){
						    		ids.push(rows[i].id);
						    	}
						    	//console.info(ids.join());
						        //alert('确认删除');
						    	$.ajax({
									cache: false,
									async: false,
									type: "POST",
									dataType: "json",
									data: {method: "removeProgram", idString: ids.join()},
									url: "/onlineexam/ProgramSubmitServlet",
									success: function(flag) {
										$('#datagridProgramSubmit').datagrid('load');			
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
					var rows=$('#datagridProgramSubmit').datagrid('getSelections');
					if(rows.length==1){
						if(editRow!=undefined){
							$('#datagridProgramSubmit').datagrid('endEdit',editRow);
						}else{
							var rowIndex=$('#datagridProgramSubmit').datagrid('getRowIndex',rows[0]);
							$('#datagridProgramSubmit').datagrid('beginEdit',rowIndex);
							editRow=rowIndex;	
							$('#datagridProgramSubmit').datagrid('unselectAll');
						}
					}
				}
			},'-',
			{
				text:'保存',
				iconCls:'icon-save',
				handler: function(){
					$('#datagridProgramSubmit').datagrid('endEdit',editRow);//关闭编辑状态
				}
			},'-',
			{
				text:'取消编辑',
				iconCls:'icon-redo',
				handler: function(){
					editRow=undefined;
					$('#datagridProgramSubmit').datagrid('rejectChanges');
					$('#datagridProgramSubmit').datagrid('unselectAll');
				}
			},'-'],
			onAfterEdit:function(rowIndex, rowData, changes){
				console.info(rowData.id);
				editRow=undefined;
				$.ajax({
					cache: false,
					async: false,
					type: "POST",
					dataType: "json",
					data: {method: "addProgram", question:rowData.question,optionA:rowData.optionA
						,optionB:rowData.optionB,optionC:rowData.optionC,optionD:rowData.optionD,answer:rowData.answer
						,grade:rowData.grade,point:rowData.point},
					url: "/onlineexam/ProgramSubmitServlet",
					success: function(flag) {
						$.messager.show({
	  		  				title:'提示',
	  		  				msg:'添加成功'
	  		  				});	
						$('#datagridProgramSubmit').datagrid('load'); 
					}
				});
			},
			onDblClickRow:function(rowIndex, rowData){
				if(editRow!=undefined){
					$('#datagridProgramSubmit').datagrid('endEdit',editRow);
				}else{
					$('#datagridProgramSubmit').datagrid('beginEdit',rowIndex);
					editRow=rowIndex;
					
				}
			}
		
			});
		
	});