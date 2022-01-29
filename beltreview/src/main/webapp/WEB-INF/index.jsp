<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Registration Page</title>
</head>
<body>
	<div class="container mt-3">
    <div class="row">
	    <div class="col">
	    <h1>Register</h1>
	    <form:form method="POST" action="/registration" modelAttribute="user">
	      <div class="form-group">
		        <form:label path="firstName">First Name:</form:label>
		        <form:errors class="text-danger" path="firstName"/>
		        <form:input class="form-control" path="firstName"/>
		    </div>
		    <div class="form-group">
		        <form:label path="lastName">Last Name:</form:label>
		        <form:errors class="text-danger" path="lastName"/>
		         <form:input class="form-control" path="lastName"/>
		    
		    </div>
		    <div class="form-group">
		        <form:label path="email">Email:</form:label>
		        <form:errors class="text-danger" path="email"/>
		        <form:input class="form-control" path="email"/>
		    </div>
		     <div class="form-group">
		        <form:label path="city">City:</form:label>
		        <form:errors class="text-danger" path="city"/>
		        <form:input class="form-control" path="city"/>
		    </div>
		     <div class="form-group">
		        <form:label path="state">State:</form:label>
		        <form:errors class="text-danger" path="state"/>
		        <form:select path="state" class="form-control">
		        <c:forEach items="${states}" var="state">
		        	<option value="${state}">${state}</option>
		        </c:forEach>
		        </form:select>
		    </div>
	      	<div class="form-group">
	            <form:label path="password">Password:</form:label>
	            <form:errors class="text-danger" path="password"/>
	            <form:password class="form-control" path="password"/>
	            
	        </div>
	         <div class="form-group mb-2">
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	 			<form:errors class="text-danger" path="passwordConfirmation"/>
	            <form:password class="form-control" path="passwordConfirmation"/>
	        </div>
	        <input class="btn btn-primary" type="submit" value="Register"/>
	        
	    </form:form>
	    </div>
	    
	    <div class="col">
    		<h1>Login</h1>
    		<form method="post" action="/login">
    			<p class="text-danger">
    			<c:out value="${error}"/>
    			</p>
        	<div class="form-group">
           	 	<label type="email" for="email">Email</label>
            	<input class="form-control"  type="text" id="email" name="email"/>
        	</div>
       		 <div class="form-group mb-2">
           	 <label for="password">Password</label>
            	<input class="form-control"  type="password" id="password" name="password"/>
        	</div>
        	<input class="btn btn-primary" type="submit" value="Login!"/>
    		</form>   
    		</div> 
    	</div>
    </div>
</body>
</html>