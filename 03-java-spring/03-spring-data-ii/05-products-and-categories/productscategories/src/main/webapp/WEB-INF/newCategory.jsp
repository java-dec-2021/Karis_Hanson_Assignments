<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<a href ="/products/new">New Product</a>
	<form:form action="/categories/new" method="post" modelAttribute="category">
		<p>
			<form:label path="name">Category Name</form:label>
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>
		</p>
		<input type="submit" value="Create"/>
	</form:form>
	<a href="/categories">All Categories</a>
</body>
</html>