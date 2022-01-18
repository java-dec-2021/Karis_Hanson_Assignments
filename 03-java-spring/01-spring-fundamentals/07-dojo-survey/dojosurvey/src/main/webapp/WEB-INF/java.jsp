<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container bg-secondary col-3 flex justify-around mx-auto p-4 mt-5">
        <h1 class="text-primary">You Chose Java as your favorite Language! :</h1>
        <h4 class="text-white">Name: <c:out value= "${name}"/></h4>
        <h4 class="text-white">Dojo Location: <c:out value="${location}"/></h4>
        <h4 class="text-white">Favorite Programming Language: <c:out value="${language}"/></h4>
        <h4 class="text-white">Comment: <c:out value="${comment}"/></h4>
        <a href="/" class="btn btn-primary mt-2">Home</a>
    </div>

</body>
</html>