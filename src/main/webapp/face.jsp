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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%-- 	<link rel="stylesheet" href="<%=basePath%>static/css/bootstrap.css"/> --%>
	<link rel="stylesheet" href="<%=basePath%>static/css/common.css"/>
	<link rel="stylesheet" href="<%=basePath%>static/css/jquery.Jcrop.css"/>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js" charset="UTF-8"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.validate.js"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.Jcrop.js"></script>
	 
	<script type="text/javascript">
		/* jcrop对象，全局变量方便操作 */
		var api = null;
		/* 原图宽度 */
		var boundx;
		/* 原图高度 */
		var boundy;
		
		/* 选择图片事件 */
		function readURL(URL){
			var reader = new FileReader();
			reader.readAsDataURL(URL.files[0]);
		    reader.onload = function(e){
				$("#faceId").removeAttr("src");
				$("#lookId").removeAttr("src");
		 		$("#faceId").attr("src",e.target.result);
				$("#lookId").attr("src",e.target.result); 
			    $("#faceId").Jcrop({
			        onChange: showPreview,
			        onSelect: showPreview,
			        aspectRatio: 1,
			        boxWidth:600
			      },function(){
			        // Use the API to get the real image size
			        //使用API来获得真实的图像大小
			        var bounds = this.getBounds();
			        boundx = bounds[0];
			        boundy = bounds[1];
			        // Store the API in the jcrop_api variable
			        //jcrop_api变量中存储API
			        api = this;
			        
			        $("#boundx").val(boundx);
			        $("#boundy").val(boundy);
			        
			      });
			 };
			  /* 移除jcrop */
              if (api != undefined) {
                  api.destroy();
              }
			  
			//简单的事件处理程序，响应自onChange,onSelect事件，按照上面的Jcrop调用
			function showPreview(coords){
				/* 设置剪切参数 */
				$("#x").val(coords.x);
				$("#y").val(coords.y);
				$("#w").val(coords.w);
				$("#h").val(coords.h);
				if(parseInt(coords.w) > 0){
					//计算预览区域图片缩放的比例，通过计算显示区域的宽度(与高度)与剪裁的宽度(与高度)之比得到
					var rx = $("#preview_box").width() / coords.w; 
					var ry = $("#preview_box").height() / coords.h;
					$("#lookId").css({
						width:Math.round(rx * $("#faceId").width()) + "px",	//预览图片宽度为计算比例值与原图片宽度的乘积
						height:Math.round(rx * $("#faceId").height()) + "px",	//预览图片高度为计算比例值与原图片高度的乘积
						marginLeft:"-" + Math.round(rx * coords.x) + "px",
						marginTop:"-" + Math.round(ry * coords.y) + "px"
					});
				}
			}

		}
	
	
	</script>
	

  </head>
  
  <body>
    <form name="form" action="<%=basePath%>faceUpload.do" class="form-horizontal" method="post" enctype="multipart/form-data">
    	<dir></dir>
    	<div style="margin-top: 10;margin-left: 30%">
    		<table>
    			<tr>
    				<td>
    					<span>头像：</span>
    					<input class="photo-file" type="file" name="imgFile" id="imgFile" onchange="readURL(this) " />
    				</td>
    				<td>
    				    	<!--  -->
    				    	<img id = "faceId" src="<%=basePath%>static/img/1.jpg" class="jcrop-preview" alt="附件">


    					<!-- 图片长宽高隐藏域 -->
                    	<input type="hidden" id="x" name="x" /> 
                    	<input type="hidden" id="y" name="y" /> 
                    	<input type="hidden" id="w" name="w" /> 
                    	<input type="hidden" id="h" name="h" />
                    	<input type="hidden" id="boundx" name="boundx" >
                    	<input type="hidden" id="boundy" name="boundy" >

    				</td>
    			</tr>
    			
    			<tr>
    				<td>
    					<span>头像预览：</span>
    				</td>
    				<td >
    					<div style="width: 200px;height: 200px;overflow: hidden;" id = "preview_box">
    					<img id = "lookId" src="<%=basePath%>static/img/1.jpg" class="jcrop-preview" alt="预览" >
    					</div>
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<span>用户名：</span><input type="text" id ="userName" name ="userName">
    				</td>
    				<td >
    					<span>艺名：</span><input type="text" id ="artName" name ="artName" >
    				</td>
    			</tr>
    			
    		</table>
    		
    		 <div class="modal-footer">
           		 <button id="submit" onclick="">上传</button>
        	</div>
    	</div>
    </form>
  </body>
</html>
