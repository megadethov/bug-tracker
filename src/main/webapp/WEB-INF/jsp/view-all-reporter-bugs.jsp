<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>All Reporter Bugs</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <h2>All Reporter Bugs</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>BUG NAME</th>
            <th>RESOLUTION</th>
            <th>PRIORITY</th>
            <th>BUG STATUS</th>
            <th>ASSIGNEE</th>
            <th>REPORTER</th>
            <th>CHANGE</th>
            <th>DELETE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allBugs}" var="next">
            <tr>
                <td>${next.id}</td>
                <td>${next.name}</td>
                <td>${next.resolution}</td>
                <td>${next.priority}</td>
                <td>${next.bugStatus}</td>
                <td>${next.assignee.name}</td>
                <td>${next.reporter.name}</td>

                <%--todo - handle for differents role--%>
<%--                <td>
                    <a href="<c:url value="/bug/update?id=${next.id}"/>">EDIT</a>
                </td>
                <td>
                    <a href="<c:url value="/bug/delete?id=${next.id}"/>">DELETE</a>
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>