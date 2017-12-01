<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AppendTest.jsp' starting page</title>
    
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
    function addPtn()
    {
        var sfa = 122;

        var temp="<a>";
        temp+="<input type='button' value='test' onclick=\"test('eq_"+sfa+"')\"/>";
        temp+="</a>";

        $("#test1").append(temp);
    }

    function test(iii){
        var KK ="F"+iii;
        alert(KK);
    }
    function test12()
    {
    	alert("A\\.B");
    }
	
	</script>

  </head>
  
  <body>
    <div id="test1" onclick="test12()"><span onclick="addPtn()">测试</span></div>
  </body>
</html>
