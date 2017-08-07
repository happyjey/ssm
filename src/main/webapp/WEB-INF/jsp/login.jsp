<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/4
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<form action="/user/dologin" method="post">
    <p>帐号：<input name="username"></p>
    <p>密码：<input name="pwd"></p>
    <p><input type="submit"></p>

</form>
</body>
</html>
