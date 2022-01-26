<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions</title>
</head>
<body>
	<a href="questions/new">Create Question</a>
	<h1>Questions Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>Questions</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questions}" var="question">
			<tr>
				<td><a href="/questions/${question.id}">${question.question}</a></td>
				<td>
					<c:forEach items="${questions.tags} var=tag">
						${question.tags}
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>