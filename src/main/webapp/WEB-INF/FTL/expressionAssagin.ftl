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
    <#assign root="页面变量优先于数据模型变量展示">
        优先展示：<b>${root}</b></br>
        指定展示：<b>${.globals.root}</b></br>
        
        页面定义的变量:
     <#assign username="李四">
     ${username}<br>
     
     <#--使用local可以声明局部变量，所以在marco宏中局部变量-->
     <#macro test>
     	<#--此时当调用该指令之后，会将模板中的变量覆盖，不能使用globals，一般不使用这种方式在指令中定义变量-->
     	<#local  username="我的名字变了"/>
     	<#local  sex="性别是保密的"/>
        姓名：${username!}&nbsp;性别${sex!}</br>
     </#macro>
     <#--调用宏-->
     <@test/>
   	 ${sex!"局部变量外部是调用不到的"}
   	 
   	 <#--循环变量-->
   	 <#list 1..3 as num>
   	 <#--只能在循环体中使用-->
   	 	${num}
   	 </#list>
   	 ${num!"循环变量出了循环体就消失了"}
  </body>
</html>
