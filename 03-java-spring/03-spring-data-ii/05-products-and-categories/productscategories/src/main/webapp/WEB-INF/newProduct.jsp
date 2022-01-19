<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<a href="/products">All Products</a>
	<form:form action="/products/new" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name: </form:label>
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>
		</p>
		<p>
			<form:label path="description">Description: </form:label>
			<form:input path="description"></form:input>
			<form:errors path="description"></form:errors>
		</p>
		<p>
			<form:label path="price">Price: </form:label>
			<form:input path="price"></form:input>
			<form:errors path="price"></form:errors>
		</p>
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>