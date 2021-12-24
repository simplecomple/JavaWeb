<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/21
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>购物车详情</title>
    <link type="text/css" href="mycss.css" rel="stylesheet">
    <link type="text/css" href="table.css" rel="stylesheet">
    <script>
        //当商品数量发生变化时触发该方法
        function changeProductNum(count,id) {
            count = parseInt(count);
            //如果数量为0，判断是否要删除商品
            if (count == 0) {
                var flag = window.confirm("确认删除商品吗?");
                if (!flag) {
                    count = 1;
                }
            }
            location.href = "${pageContext.request.contextPath}/changeCartServlet?saleId="+id+"&count="+count;
            //location.href = "${pageContext.request.contextPath}/changeCheckServlet?saleId="+id+"&count="+count;
        }
        //删除购物车中的商品
        function cart_del() {
            var msg = "您确定要删除该商品吗？";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<h1 align="center"style="border-bottom: 2px solid gainsboro;">我的购物车</h1>
<h3 align="right">
    <td>欢迎:${user.username}</td>
    |
    <td><a href="${pageContext.request.contextPath}/logoutServlet">注销</a></td>
</h3>
<table border="1" height="50" width="1000" cellspacing="0" align="center" style="border: 1px solid gainsboro;">
    <tr align="center"style="border: 1px solid gainsboro;BACKGROUND-COLOR: #a7f3c7">
        <td>商品编号</td>
        <td>商品名称</td>
        <td>价格</td>
        <td>选购数量</td>
        <td>小计</td>
        <td>操作</td>
    </tr>
    <c:set var = "total" value="0" />
    <c:forEach items="${carts}" var="carti" >
        <tr align="center"style="border: 1px solid gainsboro;">
            <td>${carti.sale.id}</td>
            <td>${carti.sale.name}</td>
            <td>${carti.sale.price}￥</td>
            <td>
                    <%--                    ${purchase.number}--%>
                <!-- 减少商品数量 -->
                <input type="button" value='-' style="width:20px"
                       onclick="changeProductNum('${carti.count-1}','${carti.sale.id}')">
                <!-- 商品数量显示 -->
                <input name="text" type="text" value="${carti.count}" style="width:40px;text-align:center" />
                <!-- 增加商品数量 -->
                <input type="button" value='+' style="width:20px"
                       onclick="changeProductNum('${carti.count+1}','${carti.sale.id}')">
            </td>
            <td>${carti.count*carti.sale.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/changeCartServlet?saleId=${carti.sale.id}&count=0">删除</a>
            </td>
            <c:set value="${total+carti.count*carti.sale.price}" var="total" />
        </tr>
    </c:forEach>
</table>
<table border="1" height="50" width="1000" cellspacing="0" align="center">
    <tr>
        <td style="text-align:right">合计：${total}元</td>
    </tr>
</table>
<table border="0" height="50" width="1000" cellspacing="0" align="center">
    <div align="right">
        <td style="text-align:right">
            <form action="${pageContext.request.contextPath}/listSaleServlet" method="get">
                <td><input type="submit" name="shopping" value="继续购物" style="font-size: 20px;text-align: center;color:rgb(123, 126, 128);background-color:rgb(219, 216, 255);/*按钮颜色*/line-height: 1.3;font-weight: 600;/*字体粗细*/letter-spacing: 0.247em;/*字体间隔*/"></td>
            </form>
        </td>
        <td style="text-align:right">
            <form action="${pageContext.request.contextPath}/makeOrderServlet" method="post">
                <td><input type="submit" name="makeOrder" value="结算"style="font-size: 20px;text-align: center;color:rgb(123, 126, 128);background-color:rgb(219, 216, 255);/*按钮颜色*/line-height: 1.3;font-weight: 600;/*字体粗细*/letter-spacing: 0.247em;/*字体间隔*/"></td>
            </form>
        </td>
    </div>>
</table>
</body>
</html>
