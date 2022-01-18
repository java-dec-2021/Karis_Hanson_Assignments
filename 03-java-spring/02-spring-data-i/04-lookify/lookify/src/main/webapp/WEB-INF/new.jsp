<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs</title>
</head>
<body>
	<h1>New Song</h1>
	<form:form action="/songs/new" method="post" modelAttribute="lookify">
		<p>
			<form:label path="title">Title</form:label>
			<form:input path="title"></form:input>
			<form:errors path="title"></form:errors>
		</p>
		<p>
			<form:label path="artist">Artist</form:label>
			<form:input path="artist"></form:input>
			<form:errors path="artist"></form:errors>
		</p>
		<p>
			<form:label path="rating">Rating</form:label>
			<form:input path="rating"></form:input>
			<form:errors path="rating"></form:errors>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>