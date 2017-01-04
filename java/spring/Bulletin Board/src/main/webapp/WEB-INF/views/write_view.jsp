<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write here</title>
	<spring:url value="/resources/css/myStyle.css" var="coreCss" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>
<body>
	<form action="write" method="post">
		<table class="table" width="500" cellpadding="0" cellspacing="0" border="1" style="width: 641px; ">
		
			<tr>
				<td> NAME</td>
				<td> <input type="text" name="bName" size = "50" style="width: 521px; "> </td>
			</tr>
			<tr>
				<td> TITLE </td>
				<td> <input type="text" name="bTitle" size = "50" style="width: 521px; "> </td>
			</tr>
			<tr>
				<td> CONTENT </td>
				<td> <textarea name="bContent" rows="10" style="width: 526px; "></textarea> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="INPUT"> &nbsp;&nbsp; <a href="list.do">LIST</a></td>
			</tr>		
		</table>
	</form>

<spring:url value="/resources/css/myScript.js" var="coreJs" />
<spring:url value="/resources/css/bootstrap.min.js" var="bootstrapJs" />
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>	
	
</body>
</html>