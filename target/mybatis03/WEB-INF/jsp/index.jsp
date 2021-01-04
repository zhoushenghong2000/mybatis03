<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/ctx.jsp"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>SpringMvc第一次的页面</title>
</head>
<body>

<img src="${ctx}/images/3.gif">

<h1 align="center">欢迎光临SpringMvc${msg}</h1>
<a href="${ctx}/Test/News">新闻查询</a>

<s:form modelAttribute="news">
<%--    <s:input path="newsId"/>--%>
    <s:hidden path="newsId"/>
    <%--<s:input path="title"/>--%>

</s:form>




</body>
</html>
