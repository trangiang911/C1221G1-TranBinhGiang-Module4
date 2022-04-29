<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/29/2022
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/gohomepage" method="post">
    <div>
        Nhập số tiền cần chuyển từ USD sang VND:
        <input type="text" name="money">
    </div>
    <div>
        <input type="submit" value="Convert">
    </div>
    <div>
        <h2>Result: ${result}</h2>
    </div>
</form>
</body>
</html>
