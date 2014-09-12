<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/heroes/">back</a>

<div id="hero-view">
    <img src="${pageContext.request.contextPath}/img/dummy.jpg"/> <br/>
    <span class="detail-label">Name</span><span class="detail-content">${hero.name}</span><br/>
    <span class="detail-label">Real name</span><span class="detail-content">${hero.realName}</span><br/>
    <span class="detail-label">Powers</span><span class="detail-content">${hero.powers}</span><br/>
</div>

</body>
</html>
