<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/29/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home" method="post">
    <div>
        Nhập từ:
        <br>
        <input type="text" name="x">
    </div>
    <div>
        <input type="submit" value="convert">
    </div>
</form>
<h2>Result: ${result}</h2>
</body>
</html>
