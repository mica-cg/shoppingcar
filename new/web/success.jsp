<%--
  Created by IntelliJ IDEA.
  User: zzl
  Date: 2021/4/20
  Time: 21:01
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
    <title>My JSP 'success.jsp' starting page</title>
</head>
<body>
${xiaoxi} <br>
<a href="searchall_b">进入购物车</a>
<a href="Searchall">管理员入口</a>
</body>
</html>