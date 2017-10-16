<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>All Persons</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <h2>All Persons</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>CHANGE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allPersons}" var="next">
            <tr>
                <td>${next.id}</td>
                <td>${next.name}</td>
                <td>
                    <a href="<c:url value="/person/update?id=${next.id}"/>">EDIT</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>