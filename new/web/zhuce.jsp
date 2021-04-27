<%--
  Created by IntelliJ IDEA.
  User: zzl
  Date: 2021/4/20
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'BB.jsp' starting page</title>
</head>
<body >
<form action="ZhuceServlet"method="post" style="padding-top:-700px;">
    输入用户名:<input name="name" type="text"><br><br>
    输入密码:<input name="pwd" type="password"><br><br>
    选择性别:<input type="radio"name="sex"value="男"checked>男
    <input type="radio"name="sex"value="女">女<br><br>
    <input type="reset"value="重置"><input type="submit"value="注册">
</form>
</body>
</html>
