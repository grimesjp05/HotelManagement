<%-- 
    Document   : updateRecord2
    Created on : Nov 3, 2015, 8:54:49 PM
    Author     : Jordan Grimes
--%>

<%@page import="model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hotel Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
    </head>
    <body>
        <h1><a href="home.html">Employee Web</a></h1>
        <h2>Update Room Status</h2>
        <form action="update" method="get">
            <% User user = (User) request.getAttribute("name");%>
            Name: <input type="text" name="name" value="<%= user.getName() %>" readonly>
            <br><br>
            Room: <input type="number" name="room" size="30" value="<%= user.getRoom() %>" required>
            <br><br>
            In Date: <input type="text" name="indate" size="30" value="<%= user.getInDate() %>" required>
            <br><br>            
            Out Date: <input type="text" name="outdate" size="30" value="<%= user.getOutDate() %>" required>
            <br><br>
            Notes: <input type="text" name="notes" value="<%= user.getNotes() %>" required>
            <br><br>

            <input type="hidden" name="action" value="updateRecord2">

            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>
