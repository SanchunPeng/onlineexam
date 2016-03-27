$(function(){
			var editRow=undefined;
			$('#datagridSelect').datagrid({
			url:'/onlineexam/SingleSelectServlet',
			pagination:true,
			pagesize:10,
			pageList:[10,20,30,40],
			fit:true,
			fitColumns:true,
			nowrap:false,
			idField:'id',
			queryParams: {
				method:'datagridSelect'
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
				title:'选项A',
				field:'optionA',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入A选项'
					}
				}
			},{
				title:'选项B',
				field:'optionB',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入B选项'
					}
				}
			},{
				title:'选项C',
				field:'optionC',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入C选项'
					}
				}
			},{
				title:'选项D',
				field:'optionD',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入D选项'
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
						$('#datagridSelect').datagrid('endEdit',editRow);
					}else{
						$('#datagridSelect').datagrid('insertRow',{
							index: 0,	// 索引从0开始
							row: {
								uid: '',
								loginname: '',
								loginpass: '123456'
							}
						});
						$('#datagridSelect').datagrid('beginEdit',0);
						editRow=0;
						
					}
					

				}
			},'-',
			{
				text:'删除',
				iconCls:'icon-remove',
				handler: function(){
					var rows=$('#datagridSelect').datagrid('getSelections');
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
									data: {method: "removeSelect", idString: ids.join(',')},
									url: "/onlineexam/SingleSelectServlet",
									success: function(flag) {
										$('#datagridSelect').datagrid('load');			
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
					var rows=$('#datagridSelect').datagrid('getSelections');
					if(rows.length==1){
						if(editRow!=undefined){
							$('#datagridSelect').datagrid('endEdit',editRow);
						}else{
							var rowIndex=$('#datagridSelect').datagrid('getRowIndex',rows[0]);
							$('#datagridSelect').datagrid('beginEdit',rowIndex);
							editRow=rowIndex;	
							$('#datagridSelect').datagrid('unselectAll');
						}
					}
				}
			},'-',
			{
				text:'保存',
				iconCls:'icon-save',
				handler: function(){
					$('#datagridSelect').datagrid('endEdit',editRow);//关闭编辑状态
				}
			},'-',
			{
				text:'取消编辑',
				iconCls:'icon-redo',
				handler: function(){
					editRow=undefined;
					$('#datagridSelect').datagrid('rejectChanges');
					$('#datagridSelect').datagrid('unselectAll');
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
					data: {method: "addSelect", question:rowData.question,optionA:rowData.optionA
						,optionB:rowData.optionB,optionC:rowData.optionC,optionD:rowData.optionD,answer:rowData.answer
						,grade:rowData.grade,point:rowData.point},
					url: "/onlineexam/SingleSelectServlet",
					success: function(flag) {
						$.messager.show({
	  		  				title:'提示',
	  		  				msg:'添加成功'
	  		  				});	
						$('#datagridSelect').datagrid('load'); 
					}
				});
			},
			onDblClickRow:function(rowIndex, rowData){
				if(editRow!=undefined){
					$('#datagridSelect').datagrid('endEdit',editRow);
				}else{
					$('#datagridSelect').datagrid('beginEdit',rowIndex);
					editRow=rowIndex;
					
				}
			}
		
			});
			$("#search").click(function(){
				$('#datagridSelect').datagrid('load', {    
				    id:$('#formSelect').find('[name=id]').val(),
				    method:'findById'
				}); 
				
			});
			$("#clear").click(function(){  
		        	$('#datagridSelect').datagrid('load',{}); 
		        	$("#formSelect").find('input').val('');
		        	$('#datagridSelect').datagrid('load',{
		        		method:'datagridSelect'
		        	});
		    });
	});