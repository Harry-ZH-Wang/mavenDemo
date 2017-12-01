$(function() {
	$("#SubConmit").click(function() {

		// 用户登录界面验证码非空判断
		var imgcode = $(".authcode").val();
		if (imgcode == "") {
			$(".authcode").css("background-color", "red");
		} else {
			$(".authcode").css("background-color", "white");
		}
		// 用户登录界面用户名非空判断
		var username = $("#creditNum").val();
		if (username == "") {
			$("#creditNum").css("background-color", "red");
		} else {
			$("#creditNum").css("background-color", "white");
		}
		// 用户登录界面密码非空判断
		var pwd = $("#password").val();
		if (pwd == "") {
			$("#password").css("background-color", "red");
		} else {
			$("#password").css("background-color", "white");
		}

		// 如果3个条件都是非空，才允许提交
		if (imgcode != "" && username != "" && pwd != "") {
			$("#SubConmit").submit;
		} else {
			return false;
		}
	});

	$("#ManageConmit").click(function() {
		// 用户登录界面用户名非空判断
		var Musername = $("#managerNum").val();
		if (Musername == "") {
			$("#managerNum").css("background-color", "red");

		} else {
			$("#managerNum").css("background-color", "white");
		}
		// 用户登录界面密码非空判断
		var Mpwd = $("#managerPwd").val();
		if (Mpwd == "") {
			$("#managerPwd").css("background-color", "red");
		} else {
			$("#managerPwd").css("background-color", "white");
		}

		// 如果2个条件都是非空，才允许提交
		if (Musername != "" && Mpwd != "") {
			$("#ManageConmit").submit;
		} else {
			return false;
		}
	});

	$("#SubCannel").click(function() {
		// 用户登陆界面的取消按钮
		location.href = "jsp/Login/MainLogin.jsp";
	});

	$("#ManageCannel").click(function() {
		// 用户登陆界面的取消按钮
		location.href = "jsp/Login/MainLogin.jsp";
	});

	// 这个是会导致页面整体刷新的验证码
	function changeImg() {
		var imgSrc = $("#imgObj");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	// 时间戳
	// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = url.substring(0, 17);
		if ((url.indexOf("&") >= 0)) {
			url = url + "×tamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}

	// 这个是登录日志的模糊查询条件输入
	$("#LoginSubConmit").click(function() {

		$('#refer').datagrid("load", {

			loginNum : $("#loginNum").val(),
			loginBeginTime : $("#loginBeginTime").val(),
			loginOutTime : $("#loginOutTime").val()
		});
	});

	
	
	
	//这个是操作日志的模糊查询条件输入
	$("#OperationConmit").click(function() {
		//这里是判断JSP页面的操作类型框的长度是否为0
		var typenum=$("#operationType").val();
		
		//如果长度为0，即无输入值，则重新给他赋值0
		if(typenum == null || typenum == ""){
			typenum=0;
		}
		if(typenum =="添加"){
			typenum=1;
		}
		if(typenum =="删除"){
			typenum=2;
		}
		if(typenum =="修改"){
			typenum =3;
		}
		$('#Operation').datagrid("load", {
			//:之前的是bean中的属性，#后面的是来自JSP页面的ID值
			operationConte:$("#operationConte").val(),
			operationModel : $("#operationModel").val(),
			operationNum : $("#operationNum").val(),
			operationTime:$("#operationTime").val(),
			operationType : typenum
				
		});
	});

	
	$("#GetOutSystem").click(function() {
		$.ajax({
			type:"post",
			url:"LoginLog/UserOutSystemTime",
			success:function(data){
				if(data == "success"){
					location.href="/netctoss/jsp/Login/MainLogin.jsp"; 
				}else{
					alert("退出不成功!");
				}
			}
		});
	});

});

$(function() {
	$(".authcode").on("focus",function(){
		$(".authcode").css("background-color", "white");
	});
	
	$("#creditNum").on("focus",function(){
		$("#creditNum").css("background-color", "white");
	});
	
	$("#password").on("focus",function(){
		$("#password").css("background-color", "white");
	});
	
	$("#managerNum").on("focus",function(){
		$("#managerNum").css("background-color", "white");
	});
	$("#managerPwd").on("focus",function(){
		$("#managerPwd").css("background-color", "white");
	});
	
	
});
