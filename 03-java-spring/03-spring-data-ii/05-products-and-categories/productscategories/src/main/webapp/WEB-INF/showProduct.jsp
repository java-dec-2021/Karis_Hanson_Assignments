<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product</title>
</head>
<body>
	<a href="/products">All Products</a>
	<a href="/products/new">Create Product</a>
	<h1>${product.name}</h1>
	<table>
		<thead>
			<tr>
				<th>Categories: </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${product.categories}" var="category">
			<tr>
				<td>${category.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Add Category:<p>
	<form action="/addCategory/${product.id}" method="post">
		<p>
			<select name="category">
			<c:forEach items="${categoriesNotInProduct}" var="category">
				<option value ="${category.id}">${category.name}</option>
			</c:forEach>
			</select>
			<button> Add</button>		
	</form>
</body>
</html>