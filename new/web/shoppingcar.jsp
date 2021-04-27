<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zzl
  Date: 2021/4/21
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <style>
        table{
            width:50%;
            position:relative;
            margin:30px auto;
            border-collapse: collapse;
            border:1px solid gray;
        }
        th{
            background: #6495ed;
            height:2.5em;
        }
        .tdone{
            width:10%;
        }
        .tdtwo{
            width:20%;
        }
        .tdthree{
            width:20%;
        }
        .tdfour{
            width:20%;
        }
        .tdfive{
            width:20%;
        }
        .tdsix{
            width:10%;
        }
        td{
            height:2em;
            text-align: center;
            border:1px solid #ccc;
        }
        .num{
            display:inline-block;
            width:3em;
        }
        input{
            height:2em;
        }
        .talast{
            text-align: left;
        }

    </style>

</head>
<body>
<table>
    <thead>
    <tr>
        <th class="tdone">序号</th>
        <th class="tdtwo">商品名称</th>
        <th class="tdthree">购物数量</th>
        <th class="tdfour">单价</th>
        <th class="tdfive">已在购物车中</th>
        <th class="tdsix">操作</th>
    </tr>
    </thead>
    <tbody>
    <C:forEach var="b" items="${bookAll}">
        <form action="addbookServlet" method="post">
    <tr class="trclass">
        <td class="tdone xuhao"><input type="hidden"name="bid" value="${b.bid}">${b.bid}</td>
        <td class="tdtwo">${b.bname}</td>
        <td class="tdthree"><span class="jiajie"><input type="text" name="x"><input type="submit" value="添加"></span></td>
        <td class="tdfour"><span>单价:￥</span><span class="unit">${b.price}</span></td>
        <td class="tdfive"><span class="subtal">${b.num}</span></td>
        </form>
        <form action="DeletebookServlet" method="post">
        <td class="tdsix"><input type="submit" value="删除第${b.bid}项"></td>
        </form>
    </tr>

    </C:forEach>

    <tr><td colspan="6"; class="talast"><span >商品一共 </span><input type="hidden" name="y"> ${sessionScope.a}件; 共计花费 <span class="pricetal">￥${sessionScope.b}</span></span><br> <a href="clearServlet">清空购物车</a></td></tr>

    </tbody>
</table>
</body>
</html>
