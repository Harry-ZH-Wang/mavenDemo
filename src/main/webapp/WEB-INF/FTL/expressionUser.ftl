<!DOCTYPE html>
<html>
  <head>
    <title>MyHtml.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
    <div >
    	姓名：<input type = "text" value="${user.name}"/><br>
    	性别：<input type = "text" value="${user.age}"/><br>
    	年龄：<input type = "text" value="${user.sex!}"/><br>
    	班级：<input type = "text" value="${(user.classBean.className)!}"/>
    	班级：<input type = "text" value="<#if (user.classBean.className)??></#if>"/>
    	班级：<input type = "text" value="${(user.classBean.className)???string("班级不为空","班级为空")}"/>
    </div>
  </body>
</html>
