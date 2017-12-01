<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'InputTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.9.1.min.js"></script>
	    <script type="text/javascript">
        function testBtn(){
            var textVal = $("#loginusername").val();
            alert(textVal);

        }


    </script>
  </head>
  <input id="loginusername" placeholder="输入您的邮箱或昵称" onfocus="if(this.value=='输入您的邮箱或昵称'){this.value=''; this.style.color='#333';}" onblur="if(this.value=='') {this.value='输入您的邮箱或昵称'; this.style.color='#B5B5B5';}" style="color: rgb(181, 181, 181);" type="text">
  <input type="button" value="BTN" onclick="testBtn();">
  <body>
    This is my JSP page. <br>
  </body>
</html>
