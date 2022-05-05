<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="" modelAttribute="setting" method="post" >
<span>Languages</span>
<form:select path="language">
    <form:option value="english">English</form:option>
    <form:option value="vietnamese">Vietnamese</form:option>
    <form:option value="japanese">Japanese</form:option>
    <form:option value="chinese">Chinese</form:option>
</form:select>
    <br>
<span>Page Size:</span>
<span>show</span>
<form:select path="pageSize">
    <form:option value="5">5</form:option>
    <form:option value="10">10</form:option>
    <from:option value="15">15</from:option>
    <from:option value="25">25</from:option>
    <form:option value="50">50</form:option>
    <form:option value="100">100</form:option>
</form:select>
<span>emails per page</span>
    <br>
<span>Spams filler</span>
<form:checkbox path="spamsFillter" />Enable spams filler
    <br>
<span>Signature</span>
<form:textarea path="signature" />
    <input type="submit" value="Update">
</form:form>
</body>
</html>
