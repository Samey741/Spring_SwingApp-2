<%@ page import="java.util.List" %>
<%@ page import="com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
    </head>
        <body>
        <h2>Welcome to Dashboard</h2>
        <h3>Your Records:</h3>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Input</th>
                <th>Crypted text</th>
                <th>Decrypted text</th>
                <th>Cipher type</th>
                <th>Timestamp</th>
            </tr>
            <jsp:useBean id="requestDataList" scope="request" type="java.util.List"/>
            <c:forEach var="requestData" items="${requestDataList}">
                <tr>
                    <td>${requestData.id}</td>
                    <td>${requestData.plaintext}</td>
                    <td>${requestData.cryptedText}</td>
                    <td>${requestData.decryptedText}</td>
                    <td>${requestData.cipherType}</td>
                    <td>${requestData.createdOn}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <c:if test="${sessionScope.roles.contains('ADMIN')}">
            <form action="showAllCiphers" method="GET">
                <a href="/showAllCiphers"><button>Show all Ciphers</button></a>
            </form>
        </c:if>
        <br/>
        <form action="logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
