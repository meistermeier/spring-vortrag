<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="create">
    <a href="${pageContext.request.contextPath}/heroes/create">Create hero</a>
</div>
<ul>
<c:forEach items="${heroes}" var="hero">
    <li><a href="<c:url value="/heroes/"/>${hero.id}">${hero.name}</a></li>
</c:forEach>
</ul>
</body>
</html>
