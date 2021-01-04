<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="r" uri="http://shiro.apache.org/tags" %>
<%@include file="../../common/ctx.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主界面<%=System.currentTimeMillis()%>，欢迎您：[${sessionScope.username}]</h1>
<ul>
    系统功能列表
    <li>
        <a href="admin/addUser.jsp">用户新增</a>
    </li>
    <li>
        <a href="${ctx}/admin/listUser.jsp">用户查询</a>
    </li>
    <li>
        <a href="${ctx}/User/reset">重置用户密码</a>
    </li>
    <li>
        <a href="${ctx}/admin/updateUser.jsp">用户修改</a>
    </li>
    <li>
        <a href="/admin/updatePwd.jsp">个人密码修改</a>
    </li>
    <li>
        <a href="/logout.do">退出系统</a>
    </li>
</ul>
<ul>
    shiro标签
    <li>
        <r:hasRole name="管理员">
            <a href="${ctx}admin/addUser.jsp">用户新增</a>
        </r:hasRole>
    </li>
    <li>
        <a href="/admin/listUser.jsp">用户查询</a>
    </li>
    <li>
        <a href="/admin/resetPwd.jsp">重置用户密码</a>
    </li>
    <li>
        <r:hasPermission name="订单管理">
            <a href="${ctx}/User/reset">用户修改</a>
        </r:hasPermission>
    </li>
    <li>

            <a href="admin/updatePwd.jsp">个人密码修改</a>

    </li>
    <li>
        <a href="logout.do">退出系统</a>
    </li>
</ul>
</body>
</html>
