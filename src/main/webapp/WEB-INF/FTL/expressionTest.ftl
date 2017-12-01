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
    	<#--在jsp中${}表达式会直接忽略不显示，而freemarker会报异常，还是一大堆，freemarker就需要您手动去处理-->
    	<#--  ?? 用于判断是否为空   ?number将字符串转换为数字-->
    	${list???string("非空","集合为空	")}
    	<#if list??>
    	<span>集合长度：${list?size} </span><br>
    	<#list list as a >
    		集合的下标：${a_index}
    		当前集合值：${a}&nbsp;
    		<#if a?number%2==0>偶数
    		<#else>奇数
    		</#if>
    		<br>
    	</#list>
    	<#else>
    	集合为空
    	</#if>
    	
    	
    	
    
    </div>
  </body>
</html>
