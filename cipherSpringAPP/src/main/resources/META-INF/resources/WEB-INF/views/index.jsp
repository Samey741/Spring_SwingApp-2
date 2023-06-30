<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Choose Action</title>
  </head>
  <body>
    <h1><%= "Choose action!" %></h1>
    <br/>
    <a href="registration.jsp">Registrovať sa</a>
    <br/>
    <br/>
    <form action="login" method="GET">
      <input type="submit" value="Prihlásiť sa">
    </form>
  </body>
</html>