<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 邱圣洁--%>
<%--  Date: 2021/12/21--%>
<%--  Time: 16:24--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action = '${pageContext.request.contextPath}/loginServlet' method="post">--%>
<%--    <table width = "850px" border="0" cellpadding="0" align="center">--%>
<%--        <tr>--%>
<%--            <!--头部信息-->--%>
<%--            <td style="padding: 30px"><h1>用户登录</h1></td>--%>
<%--            &lt;%&ndash;        <table width="70%" border="0" cellspacing="2" class = "upline>&ndash;%&gt;--%>
<%--        <tr>--%>
<%--            <td style="text-align: right">用户名:</td>--%>
<%--            <td style="width: 40%">--%>
<%--                <input type="text" class="textinput" id="username" name="username" style="padding: 10px"/>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td style="text-align: right">密码:</td>--%>
<%--            <td style="width: 40%">--%>
<%--                <input type="text" class="textinput" id="password" name="password"style="height: 20px"/>--%>
<%--        </tr>--%>
<%--        <table width="70%" border="0" cellspacing="0">--%>
<%--            <tr>--%>
<%--                <td style="padding-top: 20px; text-align: center">--%>
<%--                    <input type="submit" name="login" value="登录"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</body>--%>
<%--</html>--%>
<!-- <%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/21
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <title>Title</title>
    <link type="text/css" href="mycss.css" rel="stylesheet">
</head>
<body style="background-color: rgb(255, 250, 250);">
<div style="width: 70%;margin: auto;">
    <div style="float:left; width: 30%; border-right: 2px solid gainsboro; height:300px" >
        <img style="padding:30px;">
        <!--上面放图片-->
        <p style="font-style: italic;color: gray; font-size:small; text-align:center">写入点什么</p>
    </div>
    <form style="float: right;width:30%; margin-right:500px" action = '${pageContext.request.contextPath}/loginServlet' method="post">
        <table width = "400px" border="0" cellpadding="0" align="center">
            <tr>
                <!--头部信息-->
                <td style="padding: 30px; margin-left: 100px;"><h1>用户登录</h1></td>
                <%--        <table width="70%" border="0" cellspacing="2" class = "upline>--%>
            </tr>
            <tr>
                <td class="label">用户名:</td>
                <td style="width: 40%">
                    <input type="text" class="textinput" id="username" name="username"/>
            </tr>
            <tr>
                <td class="label">密码:</td>
                <td style="width: 40%">
                    <input type="password" class="textinput" id="password" name="password" />
            </tr>
            <tr>
                <td style="padding-top: 20px; text-align: center ;margin-left: 100px">
                    <input type="submit" name="login" value="登录" class="button"/>
                </td>
            </tr>

            </tr>
        </table>
    </form>
</div>
</body>
</html>
