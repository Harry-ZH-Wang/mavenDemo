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
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js" charset="UTF-8"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.validate.js"></script> 
	<script type="text/javascript" src="<%=basePath%>static/js/jquery.Jcrop.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/webuploader.nolog.js"></script>
	<script type="text/javascript">
	
	
		$(function(){
			var thcount = 0;
			
			//添加指定元素
			$("#ptbutton").click(function(){
/* 				var rows = document.getElementById("showUserInof");
				var tds = rows.getElementsByTagName("td");
				for(var i = 0; i<tds.length;i++)
				{
					alert(tds[i]);
				} */
				var rows = document.getElementById("musicInfo");
				var tr = rows.getElementsByTagName("tr");
				var count  = tr.length-1;
				if(count < 10){
					//预览展示表格
					var str = "";
					var aId =thcount;
					str += "<tr id = 'tr_"+aId+"'><td><input type = 'text' id = 'preName_"+aId+"' value = '"+$("#tempMusicName").val()+"'/></td><td><input type = 'text' id = 'preCount_"+aId+"' value ='"+$("#tempMusicCount").val()+"'/></td>"
					+"<td><a href='javascript:void(0);'onclick='updateDIV("+aId+")'>修改</a>"
					+"<a href='javascript:void(0);'onclick='deleteDIV("+aId+")'>删除</a></td></tr>";
					$("#musicInfo").append(str);
					//实际提交
					var submitUserInfo ="<div id = 'musicDiv_"+aId+"'>";
					submitUserInfo+="<input type='text' id = 'musicName_"+aId+"' name = 'music["+aId+"].musicName' value = '"+$("#tempMusicName").val()+"'><br>";
					submitUserInfo+="<input type='text' id = 'musicCount_"+aId+"' name = 'music["+aId+"].musicCount' value = '"+$("#tempMusicCount").val()+"'><br>";
					submitUserInfo+="<input type='text' id = 'PT01_"+aId+"' name = 'music["+aId+"].ptName01' value = '"+$("#tempPT01").val()+"'><br>";
					submitUserInfo+="<input type='text' id = 'Link01_"+aId+"' name = 'music["+aId+"].ptLink01' value = '"+$("#tempLink01").val()+"'><br>";
					submitUserInfo+="<input type='text' id = 'PT02_"+aId+"' name = 'music["+aId+"].ptName02' value = '"+$("#tempPT02").val()+"'><br>";
					submitUserInfo+="<input type='text' id = 'Link02_"+aId+"' name = 'music["+aId+"].ptLink02' value = '"+$("#tempLink02").val()+"'><br>";
					submitUserInfo+="<br></div>";
					$("#musicInfoHidden").append(submitUserInfo);
					thcount = thcount + 1 ;
				}
			});
			
			$("#updatebutton").click(function(){
				var countId = $("#updatebutton").attr("updateId");
				$("#musicName_"+countId).val($("#tempMusicName").val());
				$("#musicCount_"+countId).val($("#tempMusicCount").val());
				$("#PT01_"+countId).val($("#tempPT01").val());
				$("#Link01_"+countId).val($("#tempLink01").val());
				$("#PT02_"+countId).val($("#tempPT02").val());
				$("#Link02_"+countId).val($("#tempLink02").val());
				$("#preName_"+countId).val($("#tempMusicName").val());
				$("#preCount_"+countId).val($("#tempMusicCount").val());
				$("#updatebutton").removeAttr("updateId");
				
			});
			
			
			
		});
		//删除方法
		function deleteDIV(countId)
		{
			//删除预览
			$("#tr_"+countId).remove();
			$("#musicDiv_"+countId).remove();
		}
		
		//修改方法
		function updateDIV(countId)
		{
			$("#tempMusicName").val($("#musicName_"+countId).val());
			$("#tempMusicCount").val($("#musicCount_"+countId).val());
			$("#tempPT01").val($("#PT01_"+countId).val());
			$("#tempLink01").val($("#Link01_"+countId).val());
			$("#tempPT02").val($("#PT02_"+countId).val());
			$("#tempLink02").val($("#Link02_"+countId).val());
			$("#updatebutton").attr("updateId",countId);
		}
	
		
		
	</script>
	
	
	
	
  </head>
  
  <body>
    <div style="margin-left: 35%;margin-top: 10%">
    	<form action="test.do">
    	<span>平台信息填写界面</span>
    	<table>
    	    <tr>
    			<td>音乐名</td>
    			<td><input type="text" id = "tempMusicName" name = "tempMusicName"></td>
    		</tr>
    	    <tr>
    		<td>试听量</td>
    			<td><input type="text" id = "tempMusicCount" name = "tempMusicCount"></td>
    		</tr>    		
    		<tr>
    	</table>
    	<table>
    		<tr>
    		 	<td>平台名</td>
    		 	<td>链接名</td>
    		</tr>
     		<tr>
    			<td><input type="text" id = "tempPT01" name = "tempPT01"></td>
    			<td><input type="text" id = "tempLink01" name = "tempLink01"></td>
    		</tr>
     		<tr>
    			<td><input type="text" id = "tempPT02" name = "tempPT02"></td>
    			<td><input type="text" id = "tempLink02" name = "tempLink02"></td>
    		</tr>
    		<tr>
    			<td>&nbsp;</td>
    			<td><input type="button" id = "ptbutton" name = "ptbutton" value ="确定"></td>
    		</tr>
    		 <tr>
    			<td>&nbsp;</td>
    			<td><input type="button" id = "updatebutton" name = "ptbutton" value ="修改"></td>
    		</tr>    	    		
    	</table>
		<br>    	
    	<table>
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" id = "userName" name = "userName"></td>
    		</tr>
    	</table>
    		<br>   
    	<span>用户注册平台信息</span>
        	<table id = "showUserInof">
    			<tr>
    				<td>平台名</td>
    				<td>平台连接</td>
    				<td>修改</td>
    				<td>删除</td>
    			</tr>
    	</table>
      	<span>平台音信息</span>
        	<table id = "musicInfo">
    			<tr>
    				<td>音乐名</td>
    				<td>试听量</td>
    				<td>操作</td>
    			</tr>
    	</table>  	
    	
    	<div id = "musicInfoHidden">
    		
    	</div>
    	
    	<input type="submit" value = '提交'>
    	</form>
    	
    </div>
  </body>
</html>
