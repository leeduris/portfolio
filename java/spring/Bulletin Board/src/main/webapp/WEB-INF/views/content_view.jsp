<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>content view here</title>
	<spring:url value="/resources/css/myStyle.css" var="coreCss" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>
<body>
	<form action="modify" method="post">
		<input type="hidden" name="bId" value="${content_view.bId}">
		<table class="table" width="500" cellpadding="0" cellspacing="0" border="1" style="width: 640px; height: 433px; ">
		
			<tr>
				<td> NO </td>
				<td> ${content_view.bId} </td>
			</tr>
			<tr>
				<td> HIT </td>
				<td> ${content_view.bHit} </td>
			</tr>
			<tr>
				<td> NAME </td>
				<td> <input type="text" name="bName" value="${content_view.bName}" style="width: 517px; "></td>
			</tr>
			<tr>
				<td> TITLE </td>
				<td> <input type="text" name="bTitle" value="${content_view.bTitle}" style="width: 515px; "></td>
			</tr>
			<tr>
				<td> CONTENT </td>
				<td> <textarea rows="10" name="bContent" style="width: 514px; ">${content_view.bContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="MODIFY"> &nbsp;&nbsp; <a href="list">LIST</a> &nbsp;&nbsp; <a href="delete?bId=${content_view.bId}">DELETE</a> &nbsp;&nbsp; <a href="reply_view?bId=${content_view.bId}">REPLY</a></td>
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