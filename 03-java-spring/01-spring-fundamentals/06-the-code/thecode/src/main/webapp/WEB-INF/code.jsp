<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Code</title>
</head>
<body>
	<ul>
		<c:forEach items="${words}" var="word">
    		<li>${word}</li>
		</c:forEach>
	</ul>

</body>
</html>