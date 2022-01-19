<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Category</title>
</head>
<body>
	<a href="/categories">All Categories</a>
	<a href="/categories/new">Create Category</a>
	<h1>${category.name}</h1>
	<table>
		<thead>
			<tr>
				<th>Products: </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${category.products}" var="product">
			<tr>
				<td>${product.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="/addProduct/${category.id}" method="post">
		<p>
			<select name="product">
			<c:forEach items="${productsNotInCategory}" var="product">
				<option value ="${product.id}">${product.name}</option>
			</c:forEach>
			</select>
			<button> Add</button>		
	</form>
</body>
</html>