<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/3/2022
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home/validate" method="post">
    <input type="text" name="email" placeholder="Mời Nhập email">
    <input type="submit" value="Validate">
</form>
<h2>${mess}</h2>
</body>
</html>
