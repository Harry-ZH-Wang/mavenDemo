<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Cache-Control","no-store");//HTTP 1.1  
response.setHeader("Pragma","no-cache");//HTTP 1.0  
response.setDateHeader("Expires",0);//prevents caching at the proxy serv
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MusicTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/webuploader.css"/>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/bootstrap.js"></script>
<%-- 	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js" charset="UTF-8"></script>  --%>
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.validate.js"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.Jcrop.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/webuploader.nolog.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#ptbutton").click(function(){
/* 				var rows = document.getElementById("showUserInof");
				var tds = rows.getElementsByTagName("td");
				for(var i = 0; i<tds.length;i++)
				{
					alert(tds[i]);
				} */
				debugger;
				JSON.stringify();
				var rows = document.getElementById("showUserInof");
				var tr = rows.getElementsByTagName("tr");
				var count  = tr.length;
				if(count < 4){
					var str = "";
					var aId ="infoId_"+count;
					str += "<tr><td><span>"+$("#tempPT").val()+"</span></td><td><span>"+$("#tempLink").val()+"</span></td>"
					+"<td><a href='javascript:void(0);'onclick='update('"+aId+"')''>修改</a><input type='text' id = 'tempPT' name = 'tempPT'></td>"+"</tr>";
					$("#showUserInof").append(str);
				}
			});
			
			
			
			
		});
	
	
	</script>
	
	
	
	
  </head>
  
  <body>
    <div style="margin-left: 35%;margin-top: 10%">
		<form action="test01.do">
			用户名<input type="text" id = "userName" name = "userName">
			音乐名：<input type="text" id = "music[0].musicName" name = "music[0].musicName">
			音乐名：<input type="text" id = "music[2].musicName" name = "music[2].musicName">
			<input type="submit" value = '提交'>
			
		</form>    	
    	
    	
    </div>
  </body>
</html>
