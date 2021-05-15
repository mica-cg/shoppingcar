<%--
  Created by IntelliJ IDEA.
  User: zzl
  Date: 2021/5/14
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上购物</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>

<body>
<!-- 最上面的部分 购物车部分-->
    <td>
        <img src=img/car.jpg width="50" align="middle">
        <a href="searchall_b">购物车</a>
    </td>
</table>
<form method="post" action="Searchall_d">
<table width="100%" bgcolor="#B6B684">
    <tr>
        <td align="right">
            Search<input type="text" name="bname">
            <input type="submit" value="搜索">
        </td>
    </tr>
</table>
</form>

<C:forEach var="b" items="${bookAll}">
<form action="addbookServlet" method="post">
<table width="100%" align="center">
    <tr>
        <td><input type="hidden"name="bid" value="${b.bid}">${b.bid}</td>
        <td><img src="${b.img}" width="200"/></td>
        <td >书名：${b.bname}</td>
        <td>售价：${b.price}</td>
        <td><input type="text" name="x" value="1" hidden>
            <input type="submit" value="加入到购物车">
        </td>
    </tr>
</table>
</form>
</C:forEach>
</body>
</html>
