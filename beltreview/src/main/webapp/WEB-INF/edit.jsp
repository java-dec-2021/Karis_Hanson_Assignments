<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:partial>
<form:form action="/events/update/${oldEvent.id}" method="post" modelAttribute="editedEvent">
	       <!-- Hidden Input for eventId -->
	      <form:input type="hidden" value="${oldEvent.id}" path="id"/>
	    <div class="form-group">
	        <form:label path="eventName">Event Name:</form:label>
	        <form:errors class="text-danger" path="eventName" />
	        <form:input class="form-control" path="eventName" value="${oldEvent.eventName}"/>
	    </div>
	    <div class="form-group mb-2">
	        <form:label path="eventDate">Event Date:</form:label>
	        <form:errors class="text-danger" path="eventDate"/>
	        <form:input class="form-control" type="date" value="${date}" path="eventDate"/>
	    </div>
	      <div class="form-group mb-2">
	        <form:label path="city">City:</form:label>
	        <form:errors class="text-danger" path="city"/>
	        <form:input class="form-control" path="city" value="${oldEvent.city}"/>
	    </div>
	    <div class="form-group">
		        <form:label path="state">State:</form:label>
		        <form:errors class="text-danger" path="state"/>
		        <form:select path="state" class="form-control">
		        <c:forEach items="${states}" var="state">
		        	<c:choose>
		        		<c:when test="${state.equals(oldEvent.state)}">
		        			<option selected value="${state}">${state}</option>
		        		</c:when>
		        		<c:otherwise>
		        			<option value="${state}">${state}</option>
		        		</c:otherwise>
		        	</c:choose>
		        </c:forEach>
		        </form:select>
		    </div>
	      <!-- Hidden Input for userId -->
	      <form:input type="hidden" value="${userId}" path="planner"/>
	   
	    <input type="submit" class="btn btn-primary mt-2" value="Update"/>
	</form:form>  
</t:partial>