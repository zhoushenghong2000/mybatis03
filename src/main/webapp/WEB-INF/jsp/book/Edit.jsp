<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/ctx.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增书本</title>
</head>
<body>
<h1>新增书本</h1>
<form action="${ctx}/Book/edit" method="post">
<input type="hidden" value="${book1.bookId}" name="bookId"/>
 书本名称:<input type="text" value="${book1.bookName}" name="bookName"/><br/>
    书本价格:<input type="text" value="${book1.bookPrice}" name="bookPrice"/><br/>
    书本简介:<input type="text" value="${book1.bookBrief}" name="bookBrief"/><br/>
    <input type="submit" value="提交" />
</form>

</body>
</html>
