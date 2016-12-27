<%-- 
    Document   : JSP (View) to notify user when the signup is completed (success / fail)
    Created on : Jul 27, 2016
    Updated on : Jul 28, 2016
    Author     : Sung Woo Lee (leeduris@gmail.com)
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ejd.*, java.util.*, java.sql.*, javaclub.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration Result</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
	<section id="content" class="left">
            <c:if test="${not empty signupMessage}">
            <h3>${signupMessage}</h3>
            </c:if> 
            <br><br>
    
            <a href="index.html">Go to Home page</a>         
	</section><!-- content -->
        <%@ include file="intro.txt" %>   
    </div><!-- container -->
</html>
