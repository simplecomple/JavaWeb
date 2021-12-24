<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Bean.Users" %>
<%@ page import="Service.CartService" %>
<%@ page import="Service.CartsService" %>
<%@ page import="Utils.MailUtils" %><%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/23
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售订单</title>
</head>
<body style="background-color: rgb(255, 250, 250);">
<%--<h3 align="center">${user.username}的订单</h3>--%>
<%--<h3 align="right">--%>
<%--&lt;%&ndash;    <td>欢迎:${user.username}</td>&ndash;%&gt;--%>
<%--    |--%>
<%--&lt;%&ndash;    <td><a href="${pageContext.request.contextPath}/logoutServlet">注销</a></td>&ndash;%&gt;--%>
<%--</h3>--%>
<table border="1" height="50" width="1000" cellspacing="0" align="center">
    <tr align="center" style="BACKGROUND-COLOR: #a7f3c7">
        <td>用户编号</td>
        <td>商品编号</td>
        <td>数量</td>
    </tr>
    <c:set var = "total" value="0" />
    <c:forEach items="${purchases}" var="purchase" >
        <tr align="center">
            <td>${purchase.id}</td>
            <td>${purchase.s_id}</td>
            <td>${purchase.count}</td>
<%--            <c:set value="${total+purchase.count*purchase.sale.price}" var="total" />--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
