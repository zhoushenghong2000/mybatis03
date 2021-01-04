<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻首页</title>
</head>
<body>
<h1>第一条新闻</h1>
<c:forEach items="${news}" var="s">
    <h4>${s}</h4>
</c:forEach>



</body>
</html>
