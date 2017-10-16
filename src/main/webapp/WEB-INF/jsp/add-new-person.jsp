<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add New Person</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <h2>Add New Person</h2>
    <form:form commandName="person">
        <label><fmt:message key="person.name"/></label><br/>
        <form:input path="name"/><form:errors path="name" cssClass="error"/><br/>
        <input type="submit" value="Add New Person"/>
    </form:form>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
