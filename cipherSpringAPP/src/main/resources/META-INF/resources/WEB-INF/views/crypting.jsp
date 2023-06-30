<%@ page import="java.util.List" %>
<%@ page import="com.example.cipherSpringAPP.UserCipherData" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <% List<UserCipherData> requestDataList = (List<UserCipherData>) request.getAttribute("requestDataList");
        for (UserCipherData requestData : requestDataList) { %>
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
<br/>
<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
