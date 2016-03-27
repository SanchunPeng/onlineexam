
$(function(){
			var editRow=undefined;
			$('#datagridCloze').datagrid({
			url:'/onlineexam/ClozeServlet',
			pagination:true,
			pagesize:10,
			pageList:[10,20,30,40],
			fit:true,
			fitColumns:true,
			nowrap:false,
			idField:'id',
			queryParams: {
				method:'datagridCloze'
			},
			columns:[[{
				title:'编号',
				field:'id',
				width:30
			},{
				title:'题干',
				field:'question',
				width:170,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入题干'
					}
				}
			},{
				title:'答案',
				field:'answer',
				width:40,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'正确答案'
					}
				}
			},{
				title:'知识点',
				field:'chapter',
				width:40,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'知识点所在章节'
					}
				}
			},{
				title:'难易程度',
				field:'grade',
				width:40,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入难易程度'
					}
				}
			},{
				title:'分数',
				field:'point',
				width:40,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入分数'
					}
				}
			}
			]],
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				handler: function(){
					if(editRow!=undefined){
						$('#datagridCloze').datagrid('endEdit',editRow);
					}else{
						$('#datagridCloze').datagrid('insertRow',{
							index: 0,	// 索引从0开始
							row: {
								uid: '',
								loginname: '',
								loginpass: '123456'
							}
						});
						$('#datagridCloze').datagrid('beginEdit',0);
						editRow=0;
						
					}
					

				}
			},'-',
			{
				text:'删除',
				iconCls:'icon-remove',
				handler: function(){
					var rows=$('#datagridCloze').datagrid('getSelections');
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
									data: {method: "removeCloze", idString: ids.join()},
									url: "/onlineexam/ClozeServlet",
									success: function(flag) {
										$('#datagridCloze').datagrid('load');			
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
					var rows=$('#datagridCloze').datagrid('getSelections');
					if(rows.length==1){
						if(editRow!=undefined){
							$('#datagridCloze').datagrid('endEdit',editRow);
						}else{
							var rowIndex=$('#datagridCloze').datagrid('getRowIndex',rows[0]);
							$('#datagridCloze').datagrid('beginEdit',rowIndex);
							editRow=rowIndex;	
							$('#datagridCloze').datagrid('unselectAll');
						}
					}
				}
			},'-',
			{
				text:'保存',
				iconCls:'icon-save',
				handler: function(){
					$('#datagridCloze').datagrid('endEdit',editRow);//关闭编辑状态
				}
			},'-',
			{
				text:'取消编辑',
				iconCls:'icon-redo',
				handler: function(){
					editRow=undefined;
					$('#datagridCloze').datagrid('rejectChanges');
					$('#datagridCloze').datagrid('unselectAll');
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
					data: {method: "addCloze", question:rowData.question,optionA:rowData.optionA
						,optionB:rowData.optionB,optionC:rowData.optionC,optionD:rowData.optionD,answer:rowData.answer
						,grade:rowData.grade,point:rowData.point},
					url: "/onlineexam/ClozeServlet",
					success: function(flag) {
						$.messager.show({
	  		  				title:'提示',
	  		  				msg:'添加成功'
	  		  				});	
						$('#datagridCloze').datagrid('load'); 
					}
				});
			},
			onDblClickRow:function(rowIndex, rowData){
				if(editRow!=undefined){
					$('#datagridCloze').datagrid('endEdit',editRow);
				}else{
					$('#datagridCloze').datagrid('beginEdit',rowIndex);
					editRow=rowIndex;
					
				}
			}
		
			});
			$("#search").click(function(){
				$('#datagridCloze').datagrid('load', {    
				    id:$('#formCloze').find('[name=id]').val(),
				    method:'findById'
				}); 
				
			});
			$("#clear").click(function(){  
		        	$('#datagridCloze').datagrid('load',{}); 
		        	$("#formCloze").find('input').val('');
		        	$('#datagridCloze').datagrid('load',{
		        		method:'datagridCloze'
		        	});
		    });
	});