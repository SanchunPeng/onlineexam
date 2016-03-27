
$(function(){
			var editRow=undefined;
			$('#datagridProgram').datagrid({
			url:'/onlineexam/ProgramServlet',
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
				title:'题干',
				field:'question',
				width:100,
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
				width:100,
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
				width:25,
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
				width:25,
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
				width:25,
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
						$('#datagridProgram').datagrid('endEdit',editRow);
					}else{
						$('#datagridProgram').datagrid('insertRow',{
							index: 0,	// 索引从0开始
							row: {
								uid: '',
								loginname: '',
								loginpass: '123456'
							}
						});
						$('#datagridProgram').datagrid('beginEdit',0);
						editRow=0;
						
					}
					

				}
			},'-',
			{
				text:'删除',
				iconCls:'icon-remove',
				handler: function(){
					var rows=$('#datagridProgram').datagrid('getSelections');
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
									url: "/onlineexam/ProgramServlet",
									success: function(flag) {
										$('#datagridProgram').datagrid('load');			
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
					var rows=$('#datagridProgram').datagrid('getSelections');
					if(rows.length==1){
						if(editRow!=undefined){
							$('#datagridProgram').datagrid('endEdit',editRow);
						}else{
							var rowIndex=$('#datagridProgram').datagrid('getRowIndex',rows[0]);
							$('#datagridProgram').datagrid('beginEdit',rowIndex);
							editRow=rowIndex;	
							$('#datagridProgram').datagrid('unselectAll');
						}
					}
				}
			},'-',
			{
				text:'保存',
				iconCls:'icon-save',
				handler: function(){
					$('#datagridProgram').datagrid('endEdit',editRow);//关闭编辑状态
				}
			},'-',
			{
				text:'取消编辑',
				iconCls:'icon-redo',
				handler: function(){
					editRow=undefined;
					$('#datagridProgram').datagrid('rejectChanges');
					$('#datagridProgram').datagrid('unselectAll');
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
					url: "/onlineexam/ProgramServlet",
					success: function(flag) {
						$.messager.show({
	  		  				title:'提示',
	  		  				msg:'添加成功'
	  		  				});	
						$('#datagridProgram').datagrid('load'); 
					}
				});
			},
			onDblClickRow:function(rowIndex, rowData){
				if(editRow!=undefined){
					$('#datagridProgram').datagrid('endEdit',editRow);
				}else{
					$('#datagridProgram').datagrid('beginEdit',rowIndex);
					editRow=rowIndex;
					
				}
			}
		
			});
			search=function(){
				$('#datagridProgram').datagrid('load', {    
				    uid:$('#formProgram').form().find('[name=id]'),
				    loginname:$('#formProgram').form().find('[name=question]')
				}); 
			};
			clear=function(){
				$('#datagridProgram').datagrid('load', {}); 
				$('#formProgram').form().find('input').val('');
				//$('#formUser').form('reset');
			}
	});