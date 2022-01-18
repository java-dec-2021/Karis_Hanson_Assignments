<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninjas</title>
</head>
<body>
	<a href="/dojos">All Dojos</a>
	<a href="/dojos/new">Create Dojo</a>
	<a href="ninjas/new">Create Ninja</a>
	<h1>All Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Dojo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ninjas}" var="ninja">
			<tr>
				<td>${ninja.firstName} ${ninja.lastName}</td>
				<td>${ninja.age}</td>
				<td>${ninja.dojo.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>