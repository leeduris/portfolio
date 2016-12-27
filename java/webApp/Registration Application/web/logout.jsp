<%-- 
    Document   : JSP (View) to allow user to logout
    Created on : Jul 27, 2016
    Updated on : Jul 29, 2016
    Author     : Sung Woo Lee (leeduris@gmail.com)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>logout</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
	<section id="content" class="left">
            <%-- JSP scriptlet element to close the session --%>
            <c:remove var="user" scope="session" />

            <h3>Goodbye, you successfully logged out.</h3>
            <br><br>
            
            <a href="index.html">Go to Home Page</a>
	</section><!-- content -->
        <%@ include file="intro.txt" %>
    </div><!-- container -->
</body>
</html>
