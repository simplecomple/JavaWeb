<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/22
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <script type="text/javascript">
        function confirm(){
            document.form1.action="/editProductServlet";
            document.form1.submit();
        }
        function reset(){
            document.form1.action="/Admin/edit.jsp";
            document.form1.submit();
        }
    </script>
</head>
<body style="background-color: rgb(255, 250, 250);">
<form method="post" name="form1">
    <table width = "850px" border="0" cellpadding="0">
        <tr>
            <!--头部信息-->
            <td style="padding: 30px" align="right"><h1>修改商品信息</h1></td>
            <%--        <table width="70%" border="0" cellspacing="2" class = "upline>--%>
        <tr>
            <td style="text-align: right">商品编号</td>
            <td style="width: 40%">
                <input type="text" class="textinput" id="id" name="id" value = "${product.id}" readonly/>
        </tr>
        <tr>
            <td style="text-align: right">商品名称</td>
            <td style="width: 40%">
                <input type="text" class="textinput" id="name" name="name"value = "${product.p_name}"/>
        </tr>
        <tr>
            <td style="text-align: right">商品价格</td>
            <td style="width: 40%">
                <input type="text" class="textinput" id="price" name="price"value = "${product.price}"/>
        </tr>
        <tr>
            <td style="text-align: right">商品数量</td>
            <td style="width: 40%">
                <input type="text" class="textinput" id="number" name="number"value = "${product.p_number}"/>
        </tr>
        <tr>
            <td style="text-align: right">商品类别</td>
            <td style="width: 40%">
                <input type="text" class="textinput" id="category" name="category"value = "${product.category}"/>
        </tr>
        <table width="70%" border="0" cellspacing="0">
            <tr>
                <td style="padding-top: 20px; text-align: center">
                    <input type="button" value="确定" onclick="confirm()"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" value="重置" onclick="reset()"/>
                </td>
            </tr>
        </table>
        </tr>
    </table>
</form>
</body>
</html>
