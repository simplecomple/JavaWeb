<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/21
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="Utils.MailUtils" %>
<%@ page language="java" import="Bean.Users" %>
<%@ page language="java" import="Service.CartService" %>
<%@ page language="java" import="Service.CartsService" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>购物车</title>
</head>
<body style="background-color: rgb(255, 250, 250);">
<script>
    function sendConfirmEmail(email){
        <%
            Users user = (Users)session.getAttribute("user");
            CartService cartService= new CartsService();
            cartService.deleteAllByUser(user);
             try {
                    MailUtils.sendEmail(user.getEmail(),"订单生成成功，请注意查收");
                    //System.out.println(user.getEmail()+"订单生成成功，请注意查收");
                } catch (Exception e) {
                    e.printStackTrace();
                }
          %>
        return true;
    }
</script>
<h3 align="center">${user.username}的订单</h3>
<h3 align="right">
    <td>欢迎:${user.username}</td>
    |
    <td><a href="${pageContext.request.contextPath}/logoutServlet">注销</a></td>
</h3>
<table border="1" height="50" width="1000" cellspacing="0" align="center">
    <tr align="center">
        <td>商品编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>数量</td>
        <td>小计</td>
    </tr>
    <c:set var = "total" value="0" />
    <c:forEach items="${purchases}" var="purchase" >
        <tr align="center">
            <td>${purchase.sale.id}</td>
            <td>${purchase.sale.name}</td>
            <td>${purchase.sale.price}￥</td>
            <td>${purchase.count}</td>
            <td>${purchase.count*purchase.sale.price}</td>
            <c:set value="${total+purchase.count*purchase.sale.price}" var="total" />
        </tr>
    </c:forEach>
</table>
<table border="1" height="50" width="1000" cellspacing="0" align="center">
    <tr>
        <td style="text-align:right">合计：${total}元</td>
    </tr>
</table>
<table border="0" height="50" width="1000" cellspacing="0" align="center">
    <tr style="text-align:center">
        <form action="${pageContext.request.contextPath}/listSaleServlet" method="get" onsubmit="return sendConfirmEmail('${user.email}')">
            <td><button type="submit">确认订单</button></td>
        </form>
    </tr>
</table>
</body>
</html>
