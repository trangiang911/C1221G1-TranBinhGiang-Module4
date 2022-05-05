<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="create" method="post" modelAttribute="music">
    Tên bài hát: <form:input type="text"  path="name" /> <br>
    Ca sĩ thể hiện:<form:input type="text"  path="singer" /> <br>
    Thể loại:<form:select path="type">
    <form:option value="thiếu nhi">Thiếu nhi</form:option>
    <form:option value="Nhạc vàng">Nhạc Vàng</form:option>
    <form:option value="Nhạc Trẻ">Nhạc Trẻ</form:option>
</form:select> <br>
    Đường dẫn: <form:input type="text" path="link" /> <br>
    <input type="submit" value="Thêm">
</form:form>
</body>
</html>
