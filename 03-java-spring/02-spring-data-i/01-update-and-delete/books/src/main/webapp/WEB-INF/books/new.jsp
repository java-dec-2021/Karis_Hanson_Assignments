<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Book</title>
</head>
<body>
	<h1>New Book</h1>
	<form:form action="/books" method="post" modelAttribute="book">
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