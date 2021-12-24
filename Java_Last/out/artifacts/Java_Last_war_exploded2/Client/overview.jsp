<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/21
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物中心首页</title>
    <link type="text/css" href="mycss.css" rel="stylesheet">
    <link type="text/css" href="table.css" rel="stylesheet">
</head>
<body style="background-color: rgb(255, 250, 250);">
<h1 align="center">欢迎来到购物中心</h1>
<div style="float: right; margin-right: 100px;">
    <td><a href="${pageContext.request.contextPath}/Client/login.jsp">登录</a></td>
    |
    <td style="float: right; margin-right: 100px;"><a href="${pageContext.request.contextPath}/Client/register.jsp">注册</a></td>
</div>>
<table border="1" height="50" width="1000" cellspacing="0" align="center">
    <tr align="center"style="BACKGROUND-COLOR: #a7f3c7">
        <th>编号</th>
        <th>名称</th>
        <th>价格</th>
<%--        <td>操作</td>--%>
    </tr>
    <c:forEach items="${sales}" var="sale">
        <tr align="center" >
            <td>${sale.id}</td>
            <td>${sale.name}</td>
            <td>${sale.price}￥</td>
<%--            <form action = "./addCartServlet?goodId=${sale.id}" method="post">--%>
<%--                <td><input type="submit" name="purchase" value="购买"/></td>--%>
<%--            </form>--%>
        </tr>
    </c:forEach>

</table>
<%--<table border="0" height="50" width="1000" cellspacing="0" align="center">--%>
<%--    <tr align="center">--%>
<%--        <td><a href="/goodsServlet">我的购物车</a></td>--%>
<%--    </tr>--%>
<%--</table>--%>
</body>
</html>
