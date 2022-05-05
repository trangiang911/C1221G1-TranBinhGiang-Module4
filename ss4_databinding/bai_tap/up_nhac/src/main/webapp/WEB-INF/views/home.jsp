<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Danh sách bài hát</h2>
    <form action="" method="get">
    <button type="submit"><a href="/create">Thêm mới bài hát</a></button>
    </form>
    <c:forEach var="x" items="${music1}">
        <span>Bài hát:${x.name}</span>|<span>${x.singer}</span>|<span>${x.type}</span>|<span>${x.link}</span> <br>
    </c:forEach>
</body>
</html>
