
$(function(){
			var editRow=undefined;
			$('#datagridUser').datagrid({
			url:'/onlineexam/LoginStudentServlet',
			pagination:true,
			pagesize:10,
			pageList:[10,20,30,40],
			fit:true,
			fitColumns:true,
			idField:'uid',
			queryParams: {
				method:'datagridStudent'
			},
			columns:[[{
				title:'编号',
				field:'uid',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入账号'
					}
				}
			},{
				title:'用户名',
				field:'loginname',
				width:100,
				editor:{
					type:'validatebox',
					options:{
						required:true,
						missingMessage:'请输入用户名'
					}
				}
			},{
				title:'密码',
				field:'loginpass',
				width:100
			}]],
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				handler: function(){
					if(editRow!=undefined){
						$('#datagridUser').datagrid('endEdit',editRow);
					}else{
						$('#datagridUser').datagrid('insertRow',{
							index: 0,	// 索引从0开始
							row: {
								uid: '',
								loginname: '',
								loginpass: '123456'
							}
						});
						$('#datagridUser').datagrid('beginEdit',0);
						editRow=0;
						
					}
					

				}
			},'-',
			{
				text:'删除',
				iconCls:'icon-remove',
				handler: function(){
					var rows=$('#datagridUser').datagrid('getSelections');
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
									data: {method: "removeStudent", uidString: ids.join()},
									url: "/onlineexam/LoginStudentServlet",
									success: function(flag) {
										$('#datagridUser').datagrid('load');			
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
					var rows=$('#datagridUser').datagrid('getSelections');
					if(rows.length==1){
						if(editRow!=undefined){
							$('#datagridUser').datagrid('endEdit',editRow);
						}else{
							var rowIndex=$('#datagridUser').datagrid('getRowIndex',rows[0]);
							$('#datagridUser').datagrid('beginEdit',rowIndex);
							editRow=rowIndex;	
							$('#datagridUser').datagrid('unselectAll');
						}
					}
				}
			},'-',
			{
				text:'保存',
				iconCls:'icon-save',
				handler: function(){
					$('#datagridUser').datagrid('endEdit',editRow);//关闭编辑状态
				}
			},'-',
			{
				text:'取消编辑',
				iconCls:'icon-redo',
				handler: function(){
					editRow=undefined;
					$('#datagridUser').datagrid('rejectChanges');
					$('#datagridUser').datagrid('unselectAll');
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
					data: {method: "addStudent", uid: rowData.uid,loginname:rowData.loginname,loginpass:rowData.loginpass},
					url: "/onlineexam/LoginStudentServlet",
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
					$('#datagridUser').datagrid('endEdit',editRow);
				}else{
					$('#datagridUser').datagrid('beginEdit',rowIndex);
					editRow=rowIndex;
					
				}
			}
		
			});
			search=function(){
				$('#datagridUser').datagrid('load', {    
				    uid:$('#formUser').form().find('[name=uid]'),
				    loginname:$('#formUser').form().find('[name=loginname]'),
				    loginpass:$('#formUser').form().find('[name=loginpass]')
				}); 
			};
			clear=function(){
				$('#datagridUser').datagrid('load', {}); 
				$('#formUser').form().find('input').val('');
				//$('#formUser').form('reset');
			}
	});
	$("#search").click(function(){
		$('#datagridUser').datagrid('load', {    
		    id:$('#formUser').find('[name=uid]').val(),
		    method:'findById'
		}); 
		
	});
	$("#clear").click(function(){  
	    	$('#datagridUser').datagrid('load',{}); 
	    	$("#formUser").find('input').val('');
	    	$('#datagridUser').datagrid('load',{
	    		method:'datagridStudent'
	    	});
	}); 	
/*
function search(){
	$('#datagridUser').datagrid('load', {    
	    uid:$('#formUser').form().find('[name=uid]'),
	    loginname:$('#formUser').form().find('[name=loginname]'),
	    loginpass:$('#formUser').form().find('[name=loginpass]')
	}); 
}
function clear(){
	$('#datagridUser').datagrid('load', {}); 
	$('#formUser').form().find('input').val('');
	//$('#formUser').form('reset');
}*/