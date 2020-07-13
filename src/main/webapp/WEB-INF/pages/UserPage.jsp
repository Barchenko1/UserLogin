<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <link rel="stylesheet" href="../../style/css/bootstrap.css">
    <link rel="stylesheet" href="../../style/css/st4.css">
    <title>Customer Page</title>
</head>
<body>
<h5 class="logo-text-color text-center p-3">User page</h5>
<table class="tableBorder">
    <tr>
        <th>title</th>
        <th>price</th>
        <th>circulation</th>
        <th>advance</th>
        <th>actions</th>
    </tr>
    <c:forEach var="dto" items="${userRoleDto}" varStatus="i">
        <tr>
            <td>${dto.title}</td>
            <td>${dto.price}</td>
            <td>${dto.circulation}</td>
            <td>${dto.advance}</td>
            <td>
                <a href="/user/update/${dto.book_id}/${dto.customer_id}">update</a>
                <a href="/user/delete/${dto.book_id}/${dto.customer_id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>