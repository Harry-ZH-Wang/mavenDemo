<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//定义一个用户数组

String[] test={"zhang1",      "zhang2",      "zhang3",      "zhang4"};

request.setAttribute("test",test);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'each.jsp' starting page</title>
    
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
			var thcount = ${fn:length(test)};
			//alert(thcount);
			
		});
	</script>
  </head>
  
  <body>
 
   <c:forEach items="${test}" var="z" varStatus="s">
   		<input type="text" id = "pre_${s.index}" name ="name[${s.index}]" value ="${z}">
   		<c:set var="testIndex" value="${fn:length(test)}"></c:set>
   		${testIndex}
   </c:forEach>
   
   
   
  </body>
</html>
