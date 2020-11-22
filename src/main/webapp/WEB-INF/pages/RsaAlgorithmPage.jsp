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
    <form:form style="display: inline-block; margin-right: 10px" method="post" action="/encryptRsa">
        <table>
            <tr>
                <td align="right">E</td>
                <td>
                    <input class="rsaInputValue" name="eNumber" type="text" required>
                </td>
            </tr>
            <tr>
                <td align="right">N</td>
                <td>
                    <input class="rsaInputValue" name="nNumber" type="text" required>
                </td>
            </tr>
            <tr>
                <td align="right">Value</td>
                <td>
                    <input class="rsaInputValue" name="value" type="text" required>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <p>
                        <input class="btn btn-success" type="submit" name="Submit" value="encrypt">
                    </p>
                </td>
            </tr>
        </table>
    </form:form>
    <form:form style="display: inline-block; margin-left: 10px" method="post" action="/decryptRsa">
        <table>
            <tr>
                <td align="right">D</td>
                <td>
                    <input class="rsaInputValue" name="dNumber" type="text" required>
                </td>
            </tr>
            <tr>
                <td align="right">N</td>
                <td>
                    <input class="rsaInputValue" name="nNumber" type="text" required>
                </td>
            </tr>
            <tr>
                <td align="right">Value</td>
                <td>
                    <input class="rsaInputValue" name="value" type="text" required>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <p>
                        <input class="btn btn-success" type="submit" name="Submit" value="decrypt">
                    </p>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<div align="left">
    <p style="white-space: nowrap">encrypted value = ${encrypted}</p>
</div>
<div align="left">
    <p style="white-space: nowrap">decrypt value = ${decrypt}</p>
</div>
<div class="left">
    <p><a href="/generateRsaKeys" class="btn btn-success" role="button" aria-pressed="true">Generate Keys</a></p>
    <c:forEach var="keyDaya" items="${keyDataList}" varStatus="i">
        <p>publicKey E = ${keyDaya.publicKeyE}</p>
        <p style="white-space: nowrap">privateKey D = ${keyDaya.privateKeyD}</p>
        <p style="white-space: nowrap">N = ${keyDaya.numberN}</p>
    </c:forEach>
</div>
</body>
</html>
