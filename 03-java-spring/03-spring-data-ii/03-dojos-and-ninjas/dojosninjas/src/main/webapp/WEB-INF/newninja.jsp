<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<a href="/dojos">All Dojos</a>
	<!-- <a href="/ninjas">All Ninjas</a> -->
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojo Name</form:label>
			<form:errors path="dojo"></form:errors>
			<form:select path="dojo">
			<c:forEach items="${allDojos}" var="dojo">
				<option value ="${dojo.id}">${dojo.name}</option>
			</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName"></form:input>
			<form:errors path="firstName"></form:errors>
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName"></form:input>
			<form:errors path="lastName"></form:errors>
		</p>
		<p>
			<form:label path="age">Age</form:label>
			<form:input path="age"></form:input>
			<form:errors path="age"></form:errors>
		</p>
		<input type="submit" value="Create Ninja"/>
	</form:form>
</body>
</html>