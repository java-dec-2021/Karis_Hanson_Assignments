<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Song</title>
</head>
<body>
	<h1>Title: <c:out value="${lookify.title}"></c:out></h1>
	<p>Artist: <c:out value="${lookify.artist}"></c:out></p>
	<p>Rating: <c:out value="${lookify.rating}"></c:out></p>
	<form action="/songs/${lookify.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
	<a href="/dashboard">Dashboard</a>
</body>
</html>