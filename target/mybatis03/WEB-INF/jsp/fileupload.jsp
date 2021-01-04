<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/ctx.jsp"%>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${ctx}/Book/doupload" method="post" enctype="multipart/form-data">
    <input type="hidden" name="bookId" value="${param.bookId}"/>
    选择文件:<input type="file" name="fname"/><input type="submit"/>
</form>





</body>
</html>
