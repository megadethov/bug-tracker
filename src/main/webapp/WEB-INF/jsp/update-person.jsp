<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Update Person</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <h2>Edit Person</h2>
    <form:form commandName="person">
        <label><fmt:message key="person.name"/></label><br/>
        <form:input path="name" value="${person.name}"/><form:errors path="name" cssClass="error"/><br/>

        <input type="submit" value="Update Person"/>
    </form:form>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
