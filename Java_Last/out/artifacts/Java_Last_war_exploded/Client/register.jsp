<%--
  Created by IntelliJ IDEA.
  User: 邱圣洁
  Date: 2021/12/17
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link type="text/css" href="mycss.css" rel="stylesheet">
</head>
<body style="background-color: rgb(255, 250, 250);">
<form action="${pageContext.request.contextPath}/registerServlet" method="post">
    <h1 align="center">欢迎新用户</h1>
    <div align="center" style="margin-top: 5%";>
        <table width = "850px" border="0" cellpadding="0">
            <tr>
                <!--头部信息-->
        <%--        <td style="padding: 30px"><h1>新用户注册</h1></td>--%>
                <%--        <table width="70%" border="0" cellspacing="2" class = "upline>--%>
                <tr>
                    <td style="text-align: right ;width: 20%; padding-left: 200px;" class="label">邮箱:</td>
                    <td style="width: 40%">
                        <input type="text" class="textinput" id="email" name="email"/>
                </tr>
                <tr>
                    <td style="text-align: right; padding-left: 240px;" class="label">用户名:</td>
                    <td style="width: 40%">
                        <input type="text" class="textinput" id="username" name="username"/>
                </tr>
                <tr>
                    <td style="text-align: right; padding-left: 240px;" class="label">密码:</td>
                    <td style="width: 40%">
                        <input type="password" class="textinput" id="password" name="password"/>
                </tr>
                <tr>
                    <td style="text-align: right; padding-left: 240px;" class="label">性别:</td>
                    <td colspan="2">&nbsp;&nbsp;
                        <input type="radio" name="gender" value="0"/>男
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gender" value="1"/>女
                    </td>
                </tr>
                <table width="70%" border="0" cellspacing="0" align="center">
                    <tr>
                        <td style="padding-top: 20px; text-align: center">
                            <input type="submit" name="submit"  class="button" value="同意并提交"/>
                        </td>
                    </tr>
                </table>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
