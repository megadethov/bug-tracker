<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add New Person</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <form:form commandName="person">
        <label>Enter Name</label><form:input path="name"/>
        <label>Enter Last name</label><form:input path="lastName"/>
        <input type="submit" value="Add New Person"/>
        <input type="reset"/>
    </form:form>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
