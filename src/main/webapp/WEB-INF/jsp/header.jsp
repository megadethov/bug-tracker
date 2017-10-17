<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Bug Tracker</h1>
<c:out value="Hello ${pageContext.request.remoteUser}"/><br/>

<a href="<spring:url value="/main"/>">Home</a> &nbsp

<sec:authorize access="isAnonymous()">
    <a href='<spring:url value="/login"/>'>Login</a> &nbsp
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <a href='<spring:url value="/logout"/>'>Logout</a> &nbsp
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <!-- stuff to hide -->
    <a href="<spring:url value="/person/viewAll"/>">View All Persons</a> &nbsp
    <a href="<spring:url value="/bug/viewAll"/>">View All Bugs</a> &nbsp
    <a href="<spring:url value="/person/addNew"/>">Add New Person</a> &nbsp
    <a href='<spring:url value="/createAccount"/>'>Create Account</a> &nbsp
</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
    <!-- stuff to hide -->
    <a href="<spring:url value="/bug/viewAllByAssigneeName"/>">View All Bugs By Assignee</a> &nbsp
    <a href="<spring:url value="/bug/viewAllByReporterName"/>">View All Bugs By Reporter</a> &nbsp
    <a href="<spring:url value="/bug/addNew"/>">Add New Bug</a> &nbsp
</sec:authorize>












