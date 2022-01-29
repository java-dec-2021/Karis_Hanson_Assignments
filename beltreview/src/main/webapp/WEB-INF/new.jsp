<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:partial>
<form:form action="/events/create" method="post" modelAttribute="newEvent">
	    <div class="form-group">
	        <form:label path="eventName">Event Name:</form:label>
	        <form:errors class="text-danger" path="eventName"/>
	        <form:input class="form-control" path="eventName"/>
	    </div>
	    <div class="form-group mb-2">
	        <form:label path="eventDate">Event Date:</form:label>
	        <form:errors class="text-danger" path="eventDate"/>
	        <form:input class="form-control" type="date" value="${now}" path="eventDate"/>
	    </div>
	      <div class="form-group mb-2">
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
	      <!-- Hidden Input for userId -->
	      <form:input type="hidden" value="${userId}" path="planner"/>
	   
	    <input type="submit" class="btn btn-primary mt-2" value="Submit"/>
	</form:form>  
</t:partial>