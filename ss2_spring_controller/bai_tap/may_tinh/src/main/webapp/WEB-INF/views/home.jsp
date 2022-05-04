<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator" method="post">
    <input type="text" name="number1" placeholder="Nhập số thứ nhất">
    <input type="text" name="number2" placeholder="Nhập số thứ hai"> <br>
    <hr>
    <input type="submit" name="op" value="+">
    <input type="submit" name="op" value="-">
    <input type="submit" name="op" value="*">
    <input type="submit" name="op" value="/">
</form>
<h2>Result= ${result}</h2>
</body>
</html>
