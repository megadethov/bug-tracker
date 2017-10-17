<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Bug Tracker</h1>

<a href="<spring:url value="/main"/>">Home</a> &nbsp
<a href="<spring:url value="/person/viewAll"/>">View All Persons</a> &nbsp
<a href="<spring:url value="/person/addNew"/>">Add New Person</a> &nbsp
<a href="<spring:url value="/bug/viewAll"/>">View All Bugs</a> &nbsp
<a href="<spring:url value="/bug/addNew"/>">Add New Bug</a> &nbsp
<a href='<spring:url value="/logout"/>'>Logout</a> &nbsp
<a href='<spring:url value="/createAccount"/>'>Create Account</a> &nbsp


