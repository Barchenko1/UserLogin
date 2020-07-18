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
<h5 class="logo-text-color text-center p-3">Admin page</h5>
<div class="addLink">
    <a href="/user/create">Add new user</a>
</div>
<table class="tableBorder">
    <tr>
        <th>login</th>
        <th>password</th>
        <th>first name</th>
        <th>last name</th>
        <th>age</th>
        <th>email</th>
        <th>phone</th>
        <th>birthday date</th>
        <th>role</th>
    </tr>
    <c:forEach var="dto" items="${userRoleDto}" varStatus="i">
        <tr>
            <td>${dto.login}</td>
            <td>${dto.password}</td>
            <td>${dto.f_name}</td>
            <td>${dto.l_name}</td>
            <td>${dto.age}</td>
            <td>${dto.email}</td>
            <td>${dto.phone}</td>
            <td>${dto.birthday}</td>
            <td>${dto.role_name}</td>
            <td>
<%--                <a href="/user/update/${dto.book_id}/${dto.customer_id}">update</a>--%>
<%--                <a href="/user/delete/${dto.book_id}/${dto.customer_id}">delete</a>--%>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
