<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="css/style.css" />
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" 
/>

</head>
<body>
	<div class="container bg-secondary col-3 flex justify-around mx-auto p-4 mt-5">
        <h1 class="text-primary">Dojo Survey</h1>
        <form action='/process' method='POST'> 
            <div class="form-group mb-2">
                <label for="name">Your Name: </label>
                <input type="text" class="form-control" name="name" placeholder="Name">
            </div>
            <div class="form-group mb-2">
                <label for="location">Dojo Location: </label>
                <select class="form-control" name="location">
                	<c:forEach items="${locations}" var="loc">
                		<option value="${loc}"><c:out value="${loc}"/></option>
                	</c:forEach>
                   <!--  <option value="Chicago">Chicago</option>
                    <option value="Seattle">Seattle</option>
                    <option value="Online">Online</option>
                    <option value="Burbank">Burbank</option>
                    <option value="Bellevue">Bellevue</option> -->
         		</select>
            </div>
            <div class="form-group mb-2">
                <label for="language">Favorite Language</label>
                <select class="form-control" name="language">
                	<c:forEach items="${languages}" var="lang"> 
                		<option value="${lang}"><c:out value="${lang}"/></option>
                	</c:forEach>
                    <!-- <option value="HTML">HTML</option>
                    <option value="CSS">CSS</option>
                    <option value="Java">Java</option>
                    <option value="Python">Python</option>
                    <option value="C#">C#</option> -->
                </select>
            </div>
            <div class="form-group mb-1">
                <label for="comments">Comments:</label>
                <textarea class="form-control" name="comment" rows="3"></textarea>
            </div>
            <div class="form-group mt-2">
                <input class="btn btn-primary" type='submit' value='Submit'>
            </div>
         </form>
      </div>
</body>
</html>