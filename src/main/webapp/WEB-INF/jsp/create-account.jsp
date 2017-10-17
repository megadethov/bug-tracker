<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create Account for Person</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <h2>Create Account for Person</h2>

    <form:form commandName="userFormObject">

<%--        <label>Enter Username</label><form:input path="username"/>
        <form:errors path="username" cssClass="error"/>--%>

        <label>Select Username</label><br/>
        <form:select path="username">
            <form:option value="" label="--Please Select"/>
            <form:options items="${personNameOptions}" itemValue="name" itemLabel="name"/>
        </form:select>
        <form:errors path="username" cssClass="error"/><br/>

        <label>Enter Password</label> <form:password path="password"/>
        <form:errors path="password" cssClass="error"/>


        <input type="submit" value="Create New Account"/>
    </form:form>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
