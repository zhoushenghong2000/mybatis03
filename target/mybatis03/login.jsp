<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/ctx.jsp"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${ctx}/User/login" method="post">
    用户名：<input name="username"/><br/>
    密码：<input type="password" name="password"/> <br/>
    <input type="submit"/>
</form>
</body>
</html>
