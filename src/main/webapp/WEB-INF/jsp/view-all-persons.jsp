<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>All Persons</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
    <script src="<spring:url value="http://code.jquery.com/jquery-latest.js"/>" type="text/javascript"></script>
    <script src="<spring:url value="/resources/js/script.js"/>" type="text/javascript"></script>

</head>
<body>

<jsp:include page="header.jsp"/>

<div id="container">
    <table class="zebra">
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>LAST NAME</th>
            <th>UPDATE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allPersons}" var="next">
            <tr>
                <td>${next.id}</td>
                <td class="edit" data-id="${next.id}" data-name="name" contenteditable="true">${next.name}</td>
                <td class="edit" data-id="${next.id}" data-name="lastName" contenteditable="true">${next.lastName}</td>
                <td>
                    <div>
                        <input id="update" type="button" value="SAVE CHANGE" style="color: #cd0a0a"/>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</div>

<jsp:include page="footer.jsp"/>

</body>

</html>