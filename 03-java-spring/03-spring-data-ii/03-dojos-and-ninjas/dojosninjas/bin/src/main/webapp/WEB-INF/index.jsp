<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos</title>
</head>
<body>
	<a href="/dojos/new">Create Dojo</a>
	<a href="ninjas/new">Create Ninja</a>
	<a href="/ninjas">All Ninjas</a>
	<h1>All Dojos</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojos}" var="dojo">
			<tr>
				<td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
				<td>
				<form action="/dojos/${dojo.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
				</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>