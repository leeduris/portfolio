<%-- 
    Document   : JSP (View) to allow user to login. 
    Created on : Jul 27, 2016
    Updated on : Jul 29, 2016
    Author     : Sung Woo Lee (leeduris@gmail.com)
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ejd.*, java.util.*, java.sql.*, javaclub.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
	<section id="content" class="left">
    
            <c:if test="${not empty loginMessage}">
            <h3>${loginMessage}</h3>
            </c:if>

            <form action="Login" method="post">
                <div>
                    <input type="text" placeholder="Username" name="user" required>
                </div>
                <div> 
                    <input placeholder="Password" type="password" name="pass" required>
                </div>
                <div> <input type="submit" value="Login">
                </div>
            </form>
            <br>
            <p class="link">Not register yet?&nbsp;&nbsp;
                <a href="Register">Sign up here</a>.
            </p>
	</section><!-- content -->
        <%@ include file="intro.txt" %>
    </div><!-- container -->
</body>    
</html>
