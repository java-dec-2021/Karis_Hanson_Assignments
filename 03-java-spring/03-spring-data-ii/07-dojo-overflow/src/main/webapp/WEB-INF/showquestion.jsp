<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Question</title>
</head>
<body>
	<a href="questions">All Questions</a>
	<a href="questions">Create Question</a>
	<h1>${question.question}</h1>
	<h2>Tags:
	<c:forEach items="${question.tags}" var="tag">
		${tag.subject}
	</c:forEach>
	</h2>
	<table>
		<thead>
			<tr>
				<th>Answers: </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${question.answers}" var="answer">
			<tr>
				<td>${answer.answer}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Add Your Answer:<p>
	<form action="/addAnswer/${quesion.id}" method="post">
			<label>Answer:</label>
			<input></input>
			<button> Add</button>		
	</form>
</body>
</html>