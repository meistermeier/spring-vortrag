<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div>
    <form:form modelAttribute="hero" action="/heroes/">
        <div><label for="name">Name</label><form:input id="name" path="name"/><form:errors path="name"/></div>
        <div><label for="realName">Real name</label><form:input id="realName" path="realName"/><form:errors path="realName"/></div>
        <div><label for="powers">Powers</label><form:input id="powers" path="powers"/><form:errors path="powers"/></div>
        <div><form:button>Save</form:button></div>
    </form:form>
</div>
</body>
</html>
