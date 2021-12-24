<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/17
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    request.getRequestDispatcher("/listSaleServlet").forward(request,response);
  %>
  </body>
</html>
