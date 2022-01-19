<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<h1>New Questions</h1>
	<a href="/questions">All Questions</a>
	<form:form action="/questions/new" method="post" modelAttribute="question">
		<p>
			<form:label path="question">Question: </form:label>
			<form:input path="question"></form:input>
			<form:errors path="question"></form:errors>
		</p>
		<p>
			<form:label path="tags">Tags: </form:label>
			<form:input path="tags"></form:input>
			<form:errors path="tags"></form:errors>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>