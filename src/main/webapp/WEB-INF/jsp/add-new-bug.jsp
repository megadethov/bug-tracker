<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add New Bug</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <h2>Add New Bug</h2>
    <form:form commandName="bug" action="addNew">
        <label><fmt:message key="bug.name"/></label><br/>
        <form:input path="name"/><form:errors path="name" cssClass="error"/><br/>

        <label><fmt:message key="bug.resolution"/></label><br/>
        <form:select path="resolution" items="${resolutionOptions}"/><form:errors path="resolution" cssClass="error"/><br/>

        <label><fmt:message key="bug.priority"/></label><br/>
        <form:select path="priority" items="${priorityOptions}"/><form:errors path="priority" cssClass="error"/><br/>

        <label><fmt:message key="bug.bugStatus"/></label><br/>
        <form:select path="bugStatus" items="${bugStatusOptions}"/><form:errors path="bugStatus" cssClass="error"/><br/>

        <label><fmt:message key="bug.assignee.name"/></label><br/>
        <form:select path="assignee.id" items="${personNameOptions}" itemLabel="name" itemValue="id"/><form:errors path="assignee.name" cssClass="error"/><br/>

        <label><fmt:message key="bug.reporter.name"/></label><br/>
        <form:select path="reporter.id" items="${personNameOptions}" itemLabel="name" itemValue="id"/><form:errors path="reporter.name" cssClass="error"/><br/>

        <input type="submit" value="Add New Bug"/>
    </form:form>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
