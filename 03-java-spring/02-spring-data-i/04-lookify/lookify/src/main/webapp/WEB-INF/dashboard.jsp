<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
</head>
<body>
	<a href="/songs/new">Add New</a>
	<a href="search/TopTen">Top Songs</a>
	<form action="/songs/search">
		<input type="text" name="search" />
		<button>Search Artists</button>
	</form>
	
	<h1>All Songs</h1>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lookifys}" var="song">
			<tr>
				<td><a href="/songs/${song.id}">${song.title}</a></td>
				<td><c:out value="${song.rating}"/></td>
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
</body>
</html>