<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
</head>
<body>
	<a href="/products">All Products</a>
	<a href="/products/new">Create Product</a>
	<a href="categories/new">Create Category</a>
	<h1>All Categories</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="category">
			<tr>
				<td><a href="/categories/${category.id}">${category.name}</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>