<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Sandwich condimets</h2>
    <form action="/sandwich" method="post">
        <input type="checkbox" name="condimet" value="Lettuce">Lettuce <br>
        <input type="checkbox" name="condimet" value="Tomato">Tomato <br>
        <input type="checkbox" name="condimet" value="Mustard">Mustard <br>
        <input type="checkbox" name="condimet" value="Sprouts">Sprouts <br>
        <input type="submit">
    </form>
</body>
</html>
