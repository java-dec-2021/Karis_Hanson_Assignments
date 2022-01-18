<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Searched Song</title>
</head>
<body>
	<form action="/songs/search">
		<input type="text" name="search" />
		<button>New Search</button>
	</form>
	<h3>Searched for Songs By: <c:out value="${artist}"></c:out></h3>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="song">
			<tr>
				<td><a href="/songs/${song.id}">${song.title}</a></td>
				<td>${song.rating}</td>
				<td>
				<form action="/songs/${song.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
				</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
	<a href="/dashboard">Dashboard</a>
	</div>
</body>
</html>