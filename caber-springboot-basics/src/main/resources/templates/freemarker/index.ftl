<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title>FreeMarker</title>
</head>
<body>
<h1>ID：${id}</h1>
<h1>姓名：${name}</h1>
<h1>年龄：${age}</h1>

<#assign info={"mobile":"13301231212",'address':'北京市昌平区王府街'} >
电话 ： ${info.mobile}

地址：${info.address}



</body>
</html>





<#--<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门</title>
</head>

<body>
&lt;#&ndash;我只是一个注释，我不会有任何输出  &ndash;&gt;
$你好。{name},你好。${message}

</body>
</html>-->
