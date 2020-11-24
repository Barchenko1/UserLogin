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
    <h1 align="left">Decrypt</h1>
    <form:form style="display: inline-block; margin-right: 10px" method="post" action="/desDecrypt">
        <table>
            <tr>
                <td align="right">Value</td>
                <td>
                    <input name="value" type="text" required>
                </td>
            </tr>
            <tr>
                <td align="right">Key</td>
                <td>
                    <input name="key" type="text" required>
                </td>
            </tr>
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
    <form:form style="display: inline-block; margin-left: 10px" method="post" action="/desEncrypt">
        <table>
            <tr>
                <td align="right">Value</td>
                <td>
                    <input name="value" type="text" required>
                </td>
            </tr>
            <tr>
                <td align="right">Key</td>
                <td>
                    <input name="key" type="text" required>
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
    <p>key = ${key}</p>
    <p>encrypt value = ${encryptValue}</p>
    <p>decrypt value = ${decryptValue}</p>

    <div>
        <p>Encryption</p>
        <c:forEach var="desData" items="${encryptDataLogger}" varStatus="i">
            <p>After initial permutation : ${desData.permutation}</p>
            <p>After splitting L0 : ${desData.left}</p>
            <p>After splitting RO : ${desData.right}</p>
            <c:forEach var="round" items="${desData.rounds}" varStatus="j">
                <p>${round}</p>
            </c:forEach>
        </c:forEach>
    </div>
</div>
<div class="right">
    <p>Decrypting</p>
    <c:forEach var="desData" items="${decryptDataLogger}" varStatus="i">
        <p>After initial permutation : ${desData.permutation}</p>
        <p>After splitting L0 : ${desData.left}</p>
        <p>After splitting RO : ${desData.right}</p>
        <c:forEach var="round" items="${desData.rounds}" varStatus="j">
            <p>${round}</p>
        </c:forEach>
    </c:forEach>
</div>
</body>
</html>
