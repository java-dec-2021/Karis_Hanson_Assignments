<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>
	<h1>Edit Book</h1>
	<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title"></form:errors>
			<form:input path="title"></form:input>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"></form:errors>
			<form:textarea path="description"></form:textarea>
		</p>
		<p>
			<form:label path="language">Language</form:label>
			<form:errors path="language"></form:errors>
			<form:input path="language"></form:input>
		</p>
		<p>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors path="numberOfPages"></form:errors>
			<form:input type="number" path="numberOfPages"></form:input>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>