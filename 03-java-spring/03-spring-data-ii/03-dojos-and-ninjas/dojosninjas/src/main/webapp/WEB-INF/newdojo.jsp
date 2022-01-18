<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos" method="post" modelAttribute="dojo">
		<p>
			<form:label path="name">Dojo Name</form:label>
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>
		</p>
		<input type="submit" value="Create Dojo"/>
	</form:form>
	<a href="/dojos">All Dojos</a>
</body>
</html>