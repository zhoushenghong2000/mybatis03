<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@include file="../../../common/ctx.jsp"%>


<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.0/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.1.0/jquery.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.0/js/bootstrap.js"></script>
<html>
<head>
    <title>书本首页</title>
</head>
<body>
<div align="center">
    <s:form  action="${ctx}/Book/books" method="post" enctype="multipart/form-data">
        书本名称: <input type="text" name="bookName"/>
       <input type="submit" class="btn btn-default" value="查询"/>
        <%-- <input type="button" class="btn btn-primary" value="新增"/>--%>
        <a href="${ctx}/Book/Edit" type="button" class="btn btn-primary">新增</a>
    </s:form>
</div>
<table class="ble table-striped table-bordered table-hover table-condensed"  width="100%">
<tr>
    <td>书本编号</td>
    <td>书本姓名</td>
    <td>书本价格</td>
    <td>书本描述</td>
    <td>书本图片</td>
    <td>操作</td>
</tr>
    <c:forEach items="${books}" var="b">
        <tr>
            <td>${b.bookId}</td>
            <td>${b.bookName}</td>
            <td>${b.bookPrice}</td>
            <td>${b.bookBrief}</td>
                <%--<c:choose>
                    <c:when test="${b.bookImage!=null}">
                       <td><a href="">下载图片</a></td>
                   </c:when>
                    <c:otherwise>
            <td><a href="${ctx}/Book/fileupload?bookId=${b.bookId}">上传图片</a></td>
                    </c:otherwise>
                </c:choose>--%>
            <c:choose>
                <c:when test="${b.bookImage!=null}">
                    <td><a href="${ctx}/Book/download?bookImage=${b.bookImage}">图片下载</a></td>
                </c:when>
                <c:otherwise>
                    <td><a href="${ctx}/Book/fileupload?bookId=${b.bookId}">图片上传</a></td>
                </c:otherwise>
            </c:choose>

<%--                <a href="">下载图片</a>--%>
               <td> <a href="${ctx}/Book/load?bookId=${b.bookId}">修改</a>
                <a onclick="del(${b.bookId})">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <a href="" class="btn btn-primary" >首页</a>
    <a href="" class="btn btn-primary">上一页</a>
    <a href="" class="btn btn-primary">下一页</a>
    <a href="" class="btn btn-primary">末页</a>
</div>


<script type="text/javascript">
    function del(bookId){
        let b = confirm("确定要删除吗?");
        if(b){
            $.ajax({
                url: "${ctx}/Book/del?bookId="+bookId,
                type : "post"
              });
        }
    }
</script>

</body>
</html>
