<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h1>The Code</h1>
	<form action="guess" method="POST">
	<span class="red"><c:out value="${error}"/></span>
	<p><input type  = "text" name="code" placeholder="What is the code?"/></p>
	<p><button>Submit</button></p>
	</form>
</body>
</html>