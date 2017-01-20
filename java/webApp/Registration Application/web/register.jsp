<%-- 
    Document   : JSP (View) for the registration form page.
    Created on : Jul 27, 2016
    Updated on : Jul 27, 2016
    Author     : Sung Woo Lee (leeduris@gmail.com)
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ejd.*, java.util.*, java.sql.*, javaclub.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Java Club Registration Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
	<section id="content" class="left">
            <h1>Java Club Registration Form</h1>            
            <h3>Please fill out the form below...</h3>
 
            <%--  print the error message in red only if not empty --%>
            <c:if test="${not empty signupMessage}">
            <h3>${signupMessage}</h3>
            </c:if>
            
            <form action="Register" method="post">
            <div> 
                <input type="text" placeholder="Choose user ID" name="user">
            </div>
            <div> 
                <input type="password" placeholder="Choose your password" name="pass">
            </div>
            <div> 
                <input type="password" placeholder="Re-enter password" name="pass2">
            </div>    
            <div> 
                <input type="text" placeholder="Enter your first name" name="fname">
            </div>
            <div> 
                <input type="text" placeholder="Enter your last name"  name="lname">
            </div>
            <div> 
                <input type="text" placeholder="Enter your email" name="email">
            </div>    
            <div> 
                <input type="submit" value="Signup">
            </div>
            </form>
	</section><!-- content -->
        <%@ include file="intro.txt" %>
    </div><!-- container -->
</body>
</html>
