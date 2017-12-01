<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Cache-Control","no-store");//HTTP 1.1  
response.setHeader("Pragma","no-cache");//HTTP 1.0  
response.setDateHeader("Expires",0);//prevents caching at the proxy server  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'batchFileUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/webuploader.css"/>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js" charset="UTF-8"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.validate.js"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.Jcrop.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/webuploader.nolog.js"></script>
	
	<script type="text/javascript">
		$(function(){
			//动态打开file标签
			$("#changeImg").click(function(){
				var files = document.getElementsByName("file");
				for(var i = 0;i<files.length;i++)
				{
					if($(files[i]).val()=='')
					{
						$(files[i]).click();
						break;
					}
				}
			});
		}); 
		
		//预览图事件
		function readURL(preFile,markId){
			var reader = new FileReader();
			reader.readAsDataURL(preFile.files[0]); 
			reader.onload = function(e){
				//循环判断为空
				var preImges = document.getElementsByName("preImg");
				for(var i =0;i<preImges.length;i++){
					if($(preImges[i]).attr("src")==''){
						$(preImges[i]).removeAttr("src");
						$(preImges[i]).removeAttr("markId");
						$(preImges[i]).attr("src",e.target.result);
						$(preImges[i]).attr("markId",markId);
						break;
					}
				}

				
			}
			
		}
	
		//删除预览图事件
		function deletePre(preId){
			$("#"+preId).removeAttr("src");
			$("#"+preId).attr("src",'');
			var tempMark = $("#"+preId).attr("markId");
			$("#"+tempMark).val('');
		}
	</script>

  </head>
  
  <body>
	<div style="margin-left: 35%;margin-top: 10%">
		<div  style="margin-left:5%;margin-top: 10%">简单的照片预览与批量上传</div>
		<form action=""  method="post" enctype="multipart/form-data" id = "imgFile">
    		<table cellpadding="10px" cellspacing="10px">
    			<tbody>
     				<tr>
    					<td>用户名：</td>
    					<td><input id="userName" name = "userName" type="text"></td>
    					<td>&nbsp;</td>
    				</tr>   			
    				<tr>
    					<td>相册：</td>
    					<td>&nbsp;</td>
    					<td>&nbsp;</td>
    				</tr>
					<tr>
    					<td><img alt="相片1" src="" style="width: 100px" id="preImg_1" name ="preImg"><a href="javascript:void(0);"onclick="deletePre('preImg_1')">删除</a></td>
    					<td><img alt="相片2" src="" style="width: 100px" id="preImg_2" name ="preImg"><a href="javascript:void(0);"onclick="deletePre('preImg_2')">删除</a></td>
    					<td><img alt="相片3" src="" style="width: 100px" id="preImg_3" name ="preImg"><a href="javascript:void(0);"onclick="deletePre('preImg_3')">删除</a></td>
    				</tr>
    			</tbody>
    		</table>
    		<div  style="margin-left:8%;margin-top:5%">
    			<input type="button" value = "选择图片" id="changeImg">&nbsp;&nbsp;<input type="submit" value ="     提  交     ">
    		</div>
    		<div>
    			<span>实际提交相片的File组件</span><br>
    			<br><br>
    			<input type="file" id = "fileId_1" name="file" onchange="readURL(this,'fileId_1')">
    			<input type="file" id = "fileId_2" name="file" onchange="readURL(this,'fileId_2')">
    			<input type="file" id = "fileId_3" name="file" onchange="readURL(this,'fileId_3')">
    		</div>
    	</form>
	
	</div>
  </body>
</html>
