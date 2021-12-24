<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/21
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎界面</title>
</head>
<body style="background-color: rgb(255, 250, 250);">
<h1 align="center" style="border-bottom: 2px solid gainsboro">商品目录</h1>
<h3 align="right">
    <td>欢迎:${user.username}</td>
    <td><a href="${pageContext.request.contextPath}/logoutServlet">注销</a></td>
    <td><a href="${pageContext.request.contextPath}/listCartServlet">我的购物车</a></td>
</h3>
<table border="2" height="50" width="1000" cellspacing="0" align="center">
    <tr align="center"style="BACKGROUND-COLOR: #a7f3c7">
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${sales}" var="sale">
        <tr align="center">
            <td>${sale.id}</td>
            <td>${sale.name}</td>
            <td>${sale.price}￥</td>
            <td><a href= "${pageContext.request.contextPath}/addCartServlet?saleId=${sale.id}">购买</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
