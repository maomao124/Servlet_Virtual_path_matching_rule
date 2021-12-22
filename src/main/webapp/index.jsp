<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet<br/><br/></a>
<a href="hello">精确匹配：/hello<br/>目录匹配：/abc/my/*<br/>目录匹配：/abc/*<br/>扩展名匹配：*.do<br/>缺省匹配：/</a>
</body>
</html>