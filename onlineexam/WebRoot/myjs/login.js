$(function(){
		/*
		 *  得到所有的错误信息，循环遍历之。调用一个方法来确定是否显示错误信息！
		 */
		$(".errorClass").each(function() {
			showError($(this));//遍历每个元素，使用每个元素来调用showError方法
		});
 		/*
 		 *  输入框得到焦点隐藏错误信息
 		 */
 		$(".inputClass").focus(function() {
 			var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
 			$("#" + labelId).text("");//把label的内容清空！
 			showError($("#" + labelId));//隐藏没有信息的label
 		});
 		/*
 		 * 输入框失去焦点进行校验
 		 */
 		$(".inputClass").blur(function() {
 			var id = $(this).attr("id");//获取当前输入框的id
 			var funName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";//得到对应的校验函数名
 			eval(funName);//执行函数调用,把字符串当成js代码执行
 		});
 		
 		

 	});

function login(){
	var bool = true;//表示校验通过
	if(!validateLoginname()) {
		bool = false;
	}
	if(!validateLoginpass()) {
		bool = false;
	}
	if(!validateVerifyCode()){
		bool = false;
	}
	if(bool) {
		var loginname=$("#loginname").val();
		var loginpass=$("#loginpass").val();
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
			dataType: "json",
			data: {method: "loginValidate", login: loginname,password:loginpass},
			url: "/onlineexam/LoginStudentServlet",
			success: function(data) {
  				if(data.success){
  					if(data.successExam){
  						window.location.href="/onlineexam/demo.jsp";
  					}else{
  						window.location.href="/onlineexam/exam.jsp";
  					}
  					
  				}else{
  					$.messager.alert('警告',data.msg);
  				}
			}
		});
		
	}
	
}

/*
 * 校验登录名
 */
function validateLoginname() {
	var bool = true;
	$("#loginnameError").css("display", "none");
	var value = $("#loginname").val();
	if(!value) {// 非空校验
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("用户名不能为空！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("用户名长度必须在3 ~ 20之间！");
		bool = false;
	}
	return bool;
}


function validateLoginpass() {
	var bool = true;
	$("#loginpassError").css("display", "none");
	var value = $("#loginpass").val();
	if(!value) {// 非空校验
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("密码不能为空！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("密码长度必须在3 ~ 20之间！");
		bool = false;
	}
	return bool;
}

/*
 * 校验验证码
 */
function validateVerifyCode() {
	var bool = true;
	$("#verifyCodeError").css("display", "none");
	var value = $("#verifyCode").val();
	if(!value) {//非空校验
		$("#verifyCodeError").css("display", "");
		$("#verifyCodeError").text("验证码不能为空！");
		bool = false;
	} else if(value.length != 4) {//长度不为4就是错误的
		$("#verifyCodeError").css("display", "");
		$("#verifyCodeError").text("错误的验证码！");
		bool = false;
	} else {//验证码是否正确
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
			dataType: "json",
			data: {method: "ajaxValidateVerifyCode", verifyCode: value},
			url: "/onlineexam/LoginStudentServlet",
			success: function(flag) {
				if(!flag) {
					$("#verifyCodeError").css("display", "");
					$("#verifyCodeError").text("错误的验证码！");
					bool = false;					
				}
			}
		});
	}
	return bool;
}


/*
 * 判断当前元素是否存在内容，如果存在显示，不存在不显示！
 */
function showError(ele) {
	var text = ele.text();//获取元素的内容
	if(!text) {//如果没有内容
		ele.css("display", "none");//隐藏元素
	} else {//如果有内容
		ele.css("display", "");//显示元素
	}
}


/*
 * 换一张验证码
 */
function _hyz(){
	     var img=document.getElementById("imgVcode");
	     //需要给出一个参数，这个参数每次都不同，这样才不会因为浏览器的缓存，使得不能进行换一张
	     img.src="/onlineexam/VerifyCodeServlet?a="+new Date().getTime();
	  } 
