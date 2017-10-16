<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Main Page</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<h2>LOGIN</h2>

<div id="container">
    <c:url value="/login" var="loginUrl"/>

    <form action="${loginUrl}" method="post">

        <c:if test="${param.error != null}">
            <p class="error">Invalid username and/or password</p>
        </c:if>

        <label>Username:</label> <input type="text" name="username" value="${param.username}"/>
        <label>Password:</label> <input type="password" name="password"/>

        <input type="submit" value="Login"/>
    </form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>

