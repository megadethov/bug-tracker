<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Add New Person</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <form action="<c:url value="/person/addNew"/>" method="post" >
        <label>Enter Name</label><input type="text" name="name"/>
        <label>Enter Last name</label><input type="text" name="lastName"/>
        <input type="submit" value="Add New Person"/>
    </form>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>
