<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top Songs</title>
</head>
<body>
	<h3>Top Ten Songs: </h3>
	<table>
		<thead>
			<tr>
				<th>Rating</th>
				<th>Name</th>
				<th>Artist</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${topTen}" var="song">
			<tr>
				<td>${song.rating}</td>
				<td><a href="/songs/${song.id}">${song.title}</a></td>
				<td>${song.artist}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
	<a href="/dashboard">Dashboard</a>
	</div>
</body>
</html>