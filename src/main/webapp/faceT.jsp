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
<link rel="stylesheet" href="<%=basePath%>static/css/common.css" />
<link rel="stylesheet" href="<%=basePath%>static/css/jquery.Jcrop.css" />
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.json-2.4.js" charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery.Jcrop.js"></script>
<script type="text/javascript">
        //定义一个全局api，这样操作起来比较灵活
        var api = null, 
        
        boundx, 
        boundy, 
        
        $preview = $('#preview-pane'), 
        $pcnt = $('#preview-pane .preview-container'), 
        $pimg = $('#preview-pane .preview-container img'),

        xsize = $pcnt.width(), 
        ysize = $pcnt.height();

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.readAsDataURL(input.files[0]);
                reader.onload = function(e) {
                    $('#cutimg').removeAttr('src');
                    $('#cutimg').attr('src', e.target.result);
                    $pimg.removeAttr('src');
                    $pimg.attr('src', e.target.result);

                    api = $.Jcrop('#cutimg', {
                        setSelect: [ 20, 20, 200, 200 ],
                        aspectRatio: 1,
                        onSelect: updateCoords,
                        onChange:updateCoords
                    });
                    var bounds = api.getBounds();
                    boundx = bounds[0];
                    boundy = bounds[1];
                    $preview.appendTo(api.ui.holder);
                };
                if (api != undefined) {
                    api.destroy();
                }
            }
            function updateCoords(obj) {
                $("#x").val(obj.x);
                $("#y").val(obj.y);
                $("#w").val(obj.w);
                $("#h").val(obj.h);
                if (parseInt(obj.w) > 0) {
                    var rx = xsize / obj.w;
                    var ry = ysize / obj.h;
                    $pimg.css({
                        width : Math.round(rx * boundx) + 'px',
                        height : Math.round(ry * boundy) + 'px',
                        marginLeft : '-' + Math.round(rx * obj.x) + 'px',
                        marginTop : '-' + Math.round(ry * obj.y) + 'px'
                    });
                }
            }
            ;
        }
    </script>


</head>

<body>
	<form name="form" action="" class="form-horizontal" method="post"
		enctype="multipart/form-data">
		<dir></dir>
		<div style="margin-top: 10;margin-left: 30%">
			<table>
				<tr>
					<td><span>头像：</span> <input class="photo-file" type="file"
						name="imgFile" id="fcupload" onchange="readURL(this) " /></td>
					<td><img id="xuwanting" src="<%=basePath%>static/img/1.jpg"
						class="jcrop-preview" alt="附件" width="400px"> <!-- 图片长宽高隐藏域 -->
						<input type="hidden" id="x" name="x" /> <input type="hidden"
						id="y" name="y" /> <input type="hidden" id="w" name="w" /> <input
						type="hidden" id="h" name="h" /></td>
				</tr>

				<tr>
					<td><span>头像预览：</span></td>
					<td>
						<div style="width: 300px;height: 300px;overflow: hidden;"
							id="preview_box">
							<img id="crop_preview" src="<%=basePath%>static/img/1.jpg"
								class="jcrop-preview" alt="预览">
						</div>
					</td>
				</tr>
				<tr>
					<td><span>用户名：</span><input type="text" id="userName"
						name="userName"></td>
					<td><span>艺名：</span><input type="text" id="artName"
						name="artName"></td>
				</tr>

			</table>

			<div class="modal-footer">
				<button id="submit" onclick="">上传</button>
			</div>
		</div>
	</form>
</body>
</html>
