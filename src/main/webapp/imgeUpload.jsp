<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'face.jsp' starting page</title>
    
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
  </head>
  	<script type="text/javascript">
  		$(function(){
  			/* 创建上传对象 */
  			var uploader = WebUploader.create({
  				pick: {
  				     id: '#picker',
  		            label: '点击选择图片'
  				},
  			    dnd: '#uploader .uploader-list',
  			 	paste: document.body,
  			 	swf: '<%=basePath%>static/js/Uploader.swf'
  			});
  			
  			
  			
  		});
  			
  			
  	
  	
  	
  	
  	
  	</script>
  
  
  
  
  
<body>
	<div style="margin-left: 30%">
		<div id="uploader" class="wu-example">
    		<!--用来存放文件信息-->
    		<div id="thelist" class="uploader-list" id = "listId"></div>
    			<div class="btns">
        			<div id="picker"></div>
    			</div>
		</div>
	</div>
<button id="ctlBtn" class="btn btn-default">开始上传</button>
	
	
</body>
</html>