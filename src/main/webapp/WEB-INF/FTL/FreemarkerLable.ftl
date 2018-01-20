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
    
    <#assign num=101110.1234>
    <#--$方式，直接输出-->
    <#--
    	设置全局的数字格式，右边'#"的个数代表小数部分最多为多少位，小数部分最多保留两位，最少保留一位
    	0.##%，表示百分比的形式表示，小数部分最多两位
    	,##0.0#表示示整数部分的千位分割符是','
     -->
    <#setting number_format="0.0#"/>
    ${num}<br/>
    <#--有时候全局格式设置后部分展示需要特殊的格式，也可以调用string方法设置-->
    ${num?string("0.0##")}<br/>
    
    <#--处理日期格式-->
    <#--
    	页面处理日期格式	?date ?time ?datetime 时就会分别按以上设置的对应格式显示
    	java.sql.Date java.sql.Time java.sql.Timestamp 类型的变量自动识别为 date time datetime
    	 java.util.Date 时需指定明确的日期格式，否则会抛出异常
    -->
    ${(date?string("yyyy-MM-dd"))!} <br/>
    ${date?datetime}
   
   <br/>
   <#--boolean的值不能直接取，可以作为判断条件-->
   ${boolean?string("真","假")}
   <#if boolean>真<#else>假</#if>
   
   
   <br/>
   <#assign x1 = 123.432/>
   <#assign x2 = 123/>
   <#--
       formart 可以用小m和大M去表示， mX表示小数最少多少位，MX表示小数部分最大多少位
       如果只有一个小m，表示保留几位小数,如果只写一个大M，表示小数位最多不能超过多少位，不会补位
   -->
   #{x1;m1}<br/>
   #{x1;m1M2}<br/>
   #{x1;M2}<br/>
   #{x2;m1}<br/>
   #{x2;M2}<br/>
  </body>
</html>
