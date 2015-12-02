<%-- 
    Document   : createRecord
    Created on : Nov 3, 2015, 5:19:26 PM
    Author     : Jordan Grimes
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hotel Management</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mystyle.css">
        <!-- JQuery UI code to implement a datepicker control -->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({dateFormat: "yy-mm-dd"})
                        .datepicker("setDate", new Date());
            });
        </script>
    </head>
    <body>
        <h1><a href="home.html">Hotel Management</a></h1>
        <h2>Room Check In</h2>
        <form action="create" method="get">

            <!-- Used the new HTML5 email type to force the user to enter an email address.-->
            Name: <input type="text" name="name" size="30"  
                          placeholder="Enter Name" required>
            <br><br>

            <!-- Used the new HTML5 number type to force the user to enter a number.-->
            Room Number: <input type="number" name="room" value='' required>
            <br><br>

            Check In Date: <input type="text" name="indate" id="datepicker" size="30">
            <br><br>
            
            Check Out Date: <input type="text" name="outdate" id="datepicker" size="30">
            <br><br>

            Notes:<br>
            <textarea  name="notes" maxlength="500" cols="60" rows="6"></textarea>
            <br><br>

            <input type="hidden" name="action" value="checkIn">

            <input type="submit" name="submit" value="Submit">
            <br><br>
        </form>
    </body>
</html>

