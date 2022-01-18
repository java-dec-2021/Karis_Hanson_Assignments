<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Language</title>
</head>
<body>
	<h1>Edit Language</h1>
	<form action="/languages/${language.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
	<a href="/languages">Dashboard</a>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"></form:errors>
			<form:input path="creator"></form:input>
		</p>
		<p>
			<form:label path="currentVersion">Version</form:label>
			<form:errors path="currentVersion"></form:errors>
			<form:input path="currentVersion"></form:input>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>