<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: barchenko
  Date: 05.07.2020
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <link rel="stylesheet" href="../../style/css/bootstrap.css">
    <link rel="stylesheet" href="../../style/css/st4.css">
    <link rel="stylesheet" href="../../style/css/myStyles.css">
    <title>User Page</title>
</head>
<body>
<h1 align="center">Add User</h1>
<br/>
<form:form method="post" action="/create">
    <table>
        <tr>
            <td align="right">Login</td>
            <td>
                <input name="login" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Password</td>
            <td>
                <input name="password" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">First Name</td>
            <td>
                <input name="f_name" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Surname</td>
            <td>
                <input name="l_name" type="text">
            </td>
        </tr>
        <tr>
            <td align="right">Age</td>
            <td>
                <input name="age" type="number">
            </td>
        </tr>
        <tr>
            <td align="right">Email</td>
            <td>
                <input name="email" type="email">
            </td>
        </tr>
        <tr>
            <td align="right">Phone</td>
            <td>
                <input name="phone" type="tel">
            </td>
        </tr>
        <tr>
            <td align="right">Birthday</td>
            <td>
                <input name="birthday" type="date">
            </td>
        </tr>
        <tr>
            <td align="right">Role</td>
            <td>
                <input name="role_name" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <p><input class="btn btn-success" type="submit" name="Submit" value="OK">
                    <a href="/admin" class="btn btn-success" role="button" aria-pressed="true">Cancel</a></p>
            </td>
        </tr>
    </table>
</form:form>
<div class="center">
    <c:out value="${error}"/>
</div>
</body>
</html>
