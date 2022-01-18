<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>You have visited http://localhost:8080  <c:out value="${countToShow}"/> times</h3>
	<a href="/">Test another visit?</a>
	
	<a href="/increment">Increment by 2</a>
	<a href="/destroy_session">Delete Count</a>
</body>
</html>