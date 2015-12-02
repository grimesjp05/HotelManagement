<%-- 
    Document   : getReportByDateRange.jsp
    Created on : Nov 19, 2015, 4:27:29 PM
    Author     : Jordan Grimes
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hotel Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">

        <!-- JQuery UI code to implement a datepicker control -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
        </script>
    </head>
    <body>
        <h1><a href="home.html">Hotel Management</a></h1>
        <h2>Room Status</h2>
        <form action="retrieve" method="get">

            Name: <input type="text" name="name" size="70"
                          placeholder="Enter name or leave blank and enter room number">
            <br><br>

<!--            Room Number: <input type="number" name="room" size="30" required>
            <br><br>
-->
            <input type="hidden" name="action" value="report">


            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>