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
    <% List<UserCyphers> requestDataList = (List<UserCyphers>) request.getAttribute("requestDataList");
        for (UserCyphers requestData : requestDataList) { %>
    <tr>
        <td><%= requestData.getId() %></td>
        <td><%= requestData.getPlaintext() %></td>
        <td><%= requestData.getCryptedText() %></td>
        <td><%= requestData.getDecryptedText() %></td>
        <td><%= requestData.getCipherType() %></td>
        <td><%= requestData.getCreatedOn() %></td>
    </tr>
    <% } %>
</table>
<br/>


    <c:if test="${sessionScope.role.equals(\"ADMIN\")}">
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
