<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:partial>
	<h5 class="text-info">Event Name: <c:out value="${event.eventName}" /></h5>
	<p>Host: <c:out value="${event.planner.firstName} ${event.planner.lastName}"/>
	<p>Date: <c:out value="${event.getEventDateFormatted()}" /></p>
	<p>Location: <c:out value="${event.city}, ${event.state}" /></p>
	
	<h5 class="text-info">People who are attending this event: <c:out value="${event.attendees.size()}"/></h5>
		<table class="table table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${event.attendees}" var="attendee">
				<tr>
					<td><c:out value="${attendee.firstName} ${attendee.lastName}" /></td>
					<td><c:out value="${attendee.city}" /></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Check if user is logged in -->

		<h5>Message Wall</h5>
		
		<c:forEach items="${event.messages}" var="message">	
			<p><c:out value="${message.author.firstName} says: ${message.message}" /></p>				
		</c:forEach>
	
		
		
		<%-- <form:form action="/events/${event.id}/comment" method="post" modelAttribute="message">
	   	 	  	    <!-- Hidden Input for userId -->
	      <form:input type="hidden" value="${userId}" path="author"/>
	      <form:input type="hidden" value="${event.id}" path="event"/>
	   	 	<div class="form-group">
	   	  		<form:label path="message">Message:</form:label>
	       	 	<form:errors class="text-danger" path="message"/>
	        	<form:input class="form-control" path="message"/>
	   	 	</div>
	   	 
	   		<input type="submit" class="btn btn-primary" value="Submit"/>
		</form:form>
		 --%>
		 
		 <form action="/events/${event.id}/comment" method="post">
		 	<div class="form=group>">
		 		<label for="message"> Add Comment: </label>
		 		<span class=text-danger> ${error}</span>
		 		<textarea name="message" id="message" class="form-control"></textarea>
		 		<button class="btn btn-primary mt-2">Submit</button>
		 	</div>
		 </form>
		 
		 
	
	<!-- Check if event belongs to user -->
	<c:if test="${event.planner.id==userId}">
		<a href="/events/delete/${event.id}" class="btn btn-danger"> Delete</a>
		<a href="/events/edit/${event.id}" class="btn btn-primary">Edit</a>
	</c:if>
	
</t:partial>