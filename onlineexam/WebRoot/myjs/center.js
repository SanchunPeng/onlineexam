var centerTabs;
$(function(){
	centerTabs=$('#centerTabs').tabs({
		fit:true,
		border:false
		
	});
});
function addTab(node){
	if(centerTabs.tabs('exists',node.text)){
		//如果tabs已存在，则选中
		centerTabs.tabs('select',node.text);
	}else{
			centerTabs.tabs('add',{
			title:node.text,
			closable:true,
			href:''+node.attributes.url+'',	
			/*tools:[{    
			        iconCls:'icon-mini-refresh',    
			        handler:function(){    
			        	href:''+node.attributes.url+'' 
			        }    
			    }]*/
			});
		}
	
	
}