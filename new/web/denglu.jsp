<%--
  Created by IntelliJ IDEA.
  User: zzl
  Date: 2021/4/20
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录注册页面</title>
</head>
<body >
<form action="DengluServlet"  method="post"  style="padding-top:-700px;">
    用户名：<input type="text" name="name"value=""><br><br>
    密码：  <input type="password" name="pwd"value=""><br><br>
    <input type="submit"value="登录"name="denglu"><input type="reset"value="重置"><br>
</form>
<form action="zhuce.jsp">
    <input type="submit"value="新用户注册">
</form>

</body>
</html>
