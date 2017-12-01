<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("_path", path);
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath%>static/css/bootstrap.css"/>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js" charset="UTF-8"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.validate.js"></script> 
	<script type="text/javascript">

		var path = "${_path}";
		$(function(){
			$("#ELTest01").click(function(){
				alert("a");
				var a = "A";
				for(var i = 0; i<1;i++){
					a+=a;
				}
				$("#textId").val(a);
				//document.getElementById("textId").value = b;
			});
			$("#upload").click(function() {

				$("#userId").validate({
					rules:{
						password:{
							required: "#sexRaido1:checked"
						}
					},
					message:{
						password: { 
							required: "please select sex"
							}
					}
				});
			});
			
			
			/* 重置Form表单功能 */
			$("#clean").click(function(){
				document.getElementById("user").reset();
				$("#userName").attr("value","");
				$("#password").attr("value","");
				$("#name").attr("value","");
				$("#sex").attr("value","");
				$("#file").attr("value","");
			});
			
			/* begin 附件上功能 */
			$("#choose").click(function(){
				$("#fileUpload").click();
			});
			$("#fileUpload").change(function(){
				$("#file").attr("value",$("#fileUpload").val());
				$.ajaxFileUpload({  
				    type: "POST",  
				    url: path+"/fileUpload.do",  
				    data:{fileName:$("#fileUpload").val()},//要传到后台的参数，没有可以不写  
				    secureuri : false,//是否启用安全提交，默认为false  
				    fileElementId:'fileUpload',//文件选择框的id属性  
				    dataType: 'json',//服务器返回的格式  
				    async : false,  
				    success: function(mes){  
				       if(mes.message=="OK"){
				    	   alert("附件上传成功");
				       }
				       if(mes.message=="NG"){
				    	   alert("附件上传失败");
				       }
				    },  
				    error: function (){  
				    	alert("附件上传失败");
				    }  
				});
			});
			/* end 附件上功能 */
			
			$("#ELTest01").blur(function(){
				var test01 = $("#ELTest01").val();
				var test02 = $("#ELTest02").val();
				if(test01!=null &&test01!=""){
					$.ajax({
						url:"ajaxTest.do",
						data:{ELTest01:test01,ELTest02:test02},
						success:function(data){
							$("#selectId").html(data.key);
						}
					});
				}

			});
			$("#ELTest02").blur(function(){
				var test01 = $("#ELTest01").val();
				var test02 = $("#ELTest02").val();
				if(test01!=null &&test01!=""){
					$.ajax({
						url:"ajaxTest.do",
						data:{ELTest01:test01,ELTest02:test02},
						success:function(data){
							$("#selectId").html(data.key);
						}
					});
				}
			});
			
		});
		
		function closeBtn()
		{
			$("#upload").attr("disabled", true);
		}
		
		
		
	</script>
  </head>
  
  <body>
  <jsp:include page="test/include.jsp"></jsp:include>
  <div class="container" style="width: 100%" >
  	<div>&nbsp;</div>
  	<div class="row">
  		<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
  		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1" >注册页面</div>
  	</div>
   <div>&nbsp;</div>
   <div class="row">
   		<form:form id = "userId" commandName="user" action="${_path }/register.do"  method="post" enctype="multipart/form-data">
   		<input id = "textId" name = "sss">
   			<div  class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
  			<div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1" style="text-align:right">账号：</div>
  			<form:input path="userName" type = "text" value = "" class="input-large"/>
  			<div>&nbsp;</div>
  			<div  class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
  			<div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1" style="text-align:right">密码：</div>
  			<form:input path="password" type = "password" class="input-large"/>
  			<div>&nbsp;</div>
  			<div  class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
  			<div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1" style="text-align:right">姓名：</div>
  			<form:input path="name" type = "text" value = "" class="input-large"/>
  			<div>&nbsp;</div>
  			<div  class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
  			<div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1" style="text-align:right">性别：</div>
  		    <form:input path="sex" type = "text" value = "" class="input-large"/>
  			<div>&nbsp;</div>
  			<div  class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
  			<div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1" style="text-align:right">附件：</div>
  		    <input id = "fileUpload" name = "fileUpload" type = "file"  style=" display: none">
  		    <form:input type ="text" class="input-large" path= "file" />
  		    <input id ="choose" type="button" value = "选择" class="btn btn-primary btn-xs"/>
  			<div>&nbsp;</div>
  			<div  class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
  			<div  class="col-lg-2 col-md-2 col-sm-2 col-xs-2" style="text-align:right">
  				<input id = "upload" type = "submit" value = "提交" class="btn btn-default btn-sm" onclick="closeBtn()"/>
  				&nbsp;&nbsp;&nbsp;&nbsp;
  				<input id ="clean" type="button" value = "清除" class="btn btn-default btn-sm"/>
  			</div>
  			<input type = 'text' id = 'ELTest01' value = "" name  = 'ELTest01'>
  			<input type = 'text' id = 'ELTest02' value = "" name  = 'ELTest02'>
  			<select id = "selectId"></select>
  			<input name = "sexRaido" id = "sexRaido1" type= "radio" value = "1">男 <input id = "sexRaido2"  name = "sexRaido" type= "radio" value = "2" >女
  		</form:form>
    </div>
  </div>
  </body>
</html>
