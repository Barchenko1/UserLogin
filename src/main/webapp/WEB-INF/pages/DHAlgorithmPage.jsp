<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <%@ include file="/WEB-INF/jspf/head.jspf" %>
    <link rel="stylesheet" href="../../style/css/bootstrap.css">
    <link rel="stylesheet" href="../../style/css/st4.css">
    <link rel="stylesheet" href="../../style/css/myStyles.css">
    <title>RSA Algorithm</title>
</head>
<body>
<h1 align="center">Enter Values</h1>
<br/>
<div class="containerRsa">
    <h1 align="left">Server</h1>
    <form:form style="display: inline-block; margin-right: 10px" method="get" action="/serverToClient">
        <table>
            <tr>
                <td>
                    <p>
                        <input class="btn btn-success" type="submit" name="Submit" value="answer">
                    </p>
                </td>
            </tr>
        </table>
    </form:form>
    <h1 align="right">Client</h1>
    <form:form style="display: inline-block; margin-left: 10px" method="post" action="/clientToClient">
        <table>
            <tr>
                <td align="right">Client P</td>
                <td>
                    <input name="clientP" type="number" required>
                </td>
            </tr>
            <tr>
                <td align="right">Client G</td>
                <td>
                    <input name="clientG" type="number" required>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <p>
                        <input class="btn btn-success" type="submit" name="Submit" value="send">
                    </p>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<div class="left">
    <p><a href="/showViewLogger" class="btn btn-success" role="button" aria-pressed="true">Show Symmetric Encryption Keys</a></p>
    <c:forEach var="dh" items="${dhLoggerList}" varStatus="i">
        <p>From Server : Private Key = ${dh.b}</p>
        <p>From Client : Private Key = ${dh.a}</p>
        <p>From Client : P = ${dh.p}</p>
        <p>From Client : G = ${dh.g}</p>
        <p>From Client : Public Key = ${dh.publicKeyA}</p>
        <p>From Server : Public Key = ${dh.publicKeyB}</p>
        <p>From Server : Secret Key to perform Symmetric Encryption = ${dh.bDash}</p>
        <p>From Client : Secret Key to perform Symmetric Encryption = ${dh.aDash}</p>

    </c:forEach>
</div>
</body>
</html>
