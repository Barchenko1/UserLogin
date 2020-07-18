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
<div>
    <h2>Hello User</h2>
    <p>your name: ${user.f_name}</p>
    <p>your surname: ${user.l_name}</p>
</div>
</body>
</html>
