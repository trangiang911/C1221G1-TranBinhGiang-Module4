<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich Condiment</h2>
<c:if test="${mess eq null}">
    <c:forEach var="x" items="${condimet}">
        <h2>${x}</h2>
    </c:forEach>
</c:if>
<c:if test="${mess != null}">
    <h2>${mess}</h2>
</c:if>
</body>
</html>
