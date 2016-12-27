<%--
    Document   : JSP (View) to render the member’s main page.  
    Created on : Jul 27, 2016
    Updated on : Jul 28, 2016
    Author     : Sung Woo Lee (leeduris@gmail.com)
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ page import="ejd.*, java.util.*, java.sql.*, javaclub.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Main Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
	<section id="content" class="left">
            <%-- print a welcome message and profile using EL --%>
            <h1>Hello ${user.firstName},</h1>
            <h1>you log in Java Club successfully.</h1>
            <br>
            <h2>Your Profile:</h2>
            <h3>Name : ${user.firstName} ${user.lastName}</h3>
            <h3>Email: ${user.email}</h3> 
            <br><br>
    
            <a href="logout.jsp">Log out</a>
	</section><!-- content -->
        <%@ include file="intro.txt" %>
    </div><!-- container -->
</body>
</html>
