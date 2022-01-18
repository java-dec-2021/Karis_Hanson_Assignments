<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<h1>All Languages</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
			<tr>
				<td><a href="/languages/${language.id}">${language.name}</a></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.currentVersion}"/></td>
				<td>
				<a href="/languages/${language.id}/edit">Edit</a>
				<form action="/languages/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
				</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>New Language</h1>
	<form:form action="/languages" method="post" modelAttribute="language">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:input path="creator"></form:input>
			<form:errors path="creator"></form:errors>
		</p>
		<p>
			<form:label path="currentVersion">Version</form:label>
			<form:input path="currentVersion"></form:input>
			<form:errors path="currentVersion"></form:errors>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>