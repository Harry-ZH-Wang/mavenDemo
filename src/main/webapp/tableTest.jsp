<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tableTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<c:forEach items="${test}" var="z" varStatus="s">
   		<input type="text" id = "pre_${s.index}" name ="name[${s.index}]" value ="${z}">
   		
   </c:forEach>
   
    <table cellpadding="0" cellspacing="0" border="0" style="border-collapse:collapse;">
        <tr >
            <td rowspan="4"  style="border-bottom: solid">1111111111111</td>
            <td></td>
            <td></td>
            <td></td>
            <td rowspan="4" style="border-bottom: solid" >22222222222</td>
        </tr>

        <tr >
            <td>BBBBBBBBB</td>
            <td>BBBBBBBBB</td>
            <td>BBBBBBBBB</td>
        </tr>

        <tr>
            <td>ccc</td>
            <td>ccc</td>
            <td>ccc</td>
        </tr>

        <tr style="border-bottom: solid">
            <td>ddd</td>
            <td>ddd</td>
            <td>ddd</td>
        </tr>


    </table>
  </body>
</html>
