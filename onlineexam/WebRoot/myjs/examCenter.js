   function submit(){
	  	if(confirm("你确定要提交吗？")){
	  		$.ajax({
				cache: false,
				async: false,
				type: "POST",
				dataType: "json",
				data: $('#examForm').serialize(),
				url: "/onlineexam/ExamServlet",
				success:function(data){							
	  				if(data.success){
	  					 if(confirm(data.msg)){
	  						window.location.href="/onlineexam/demo.jsp";
	  					 }
	  				}else{
	  					if(confirm(data.msg)){
	  						window.location.href="/onlineexam/loginStudent.jsp";
	  					 }
	  					
	  				}
	  			}
			});
	  	} 
	}


window.onload=function(){ 	     
     daojishi();
};

    var counttime=120*60;//总秒数
    function daojishi(){
      	if(counttime>=0){
          var ms = counttime%60;//秒数
          var mis = Math.floor(counttime/60);//分钟
           if(mis>=60){
              var hour=Math.floor(mis/60);//小时
    		   mis=Math.floor((counttime-hour*60*60)/60);
              document.getElementById("mss").value=hour+":"+mis+":"+ms;
           }else if(mis>=1){
              document.getElementById("mss").value="00"+mis+":"+ms; 
           }else{
              document.getElementById("mss").value="00"+"00"+ms; 
           }
		    counttime--;
           vartt =  window.setTimeout("daojishi()",1000);
   	}else{
       window.clearTimeout(vartt);
       window.confirm("考试时间结束,请单击提交"); 
       tijiao();   
   }  
   }
   function tijiao(){
      document.forms[0].submit();
   }
   
   
   
