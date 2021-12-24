<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/22
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="mycss.css" rel="stylesheet">
    <link type="text/css" href="table.css" rel="stylesheet">
    <script type="text/javascript">
        //添加商品
        function addProduct() {
            window.location.href = "${pageContext.request.contextPath}/Admin/add.jsp";
        }
        //删除商品
        function delProduct() {
            var msg = "您确定要删除该商品吗？";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body style="background-color: rgb(255, 250, 250);">
<h1 align="center" style="border-bottom:2px solid gainsboro;">商品目录</h1>
<p align="right">
    <td>管理员:${user.username}</td>
    |
    <td><a href="${pageContext.request.contextPath}/logoutServlet">注销</a></td>
</p>
<div align="right">
    <td align="right"><a href="${pageContext.request.contextPath}/Admin/add.jsp">添加商品</a></td>
    <td align="right"><a href="${pageContext.request.contextPath}/checkSaleServlet">查看销售记录</a></td>
</div>
<table cellspacing="0" cellpadding="1" rules="all"
       bordercolor="gray" border="1" id="DataGrid1"
       style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
    <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #a7f3c7">
        <td align="center" width="18%">商品编号</td>
        <td align="center" width="18%">商品名称</td>
        <td align="center" width="9%">商品价格</td>
        <td align="center" width="9%">商品数量</td>
        <td width="9%" align="center">商品类别</td>
        <td width="9%" align="center">操作</td>
    </tr>
    <!--  循环输出所有商品 -->
    <c:forEach items="${products}" var="product">
<%--        <tr onmouseover="this.style.backgroundColor = 'white'"--%>
<%--            onmouseout="this.style.backgroundColor = '#F5FAFE';">--%>
        <tr>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="20">${product.id }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${product.p_name }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${product.price }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${product.p_number }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center">${product.category}</td>
            <td align="center" style="HEIGHT: 22px" width="7%">
                <a href="${pageContext.request.contextPath}/findProductByIdServlet?id=${product.id}&type=admin">编辑</a>
                <a href="${pageContext.request.contextPath}/deleteProductServlet?id=${product.id}" onclick="javascript:return delProduct()">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
