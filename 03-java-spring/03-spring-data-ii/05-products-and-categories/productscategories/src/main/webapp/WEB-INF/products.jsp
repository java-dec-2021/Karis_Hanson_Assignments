<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<a href="/categories">All Categories</a>
	<a href="/categories/new">Create Category</a>
	<a href="products/new">Create Product</a>
	<h1>All Products</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
			<tr>
				<td><a href="/products/${product.id}">${product.name}</a></td>
				<td>${product.description}</td>
				<td>${product.price}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>