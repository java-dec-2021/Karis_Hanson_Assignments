<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:partial>
<h3>Here are some of the events in your state:</h3>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Event Name</th>
				<th>Date</th>
				<th>City</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${eventsInState}" var="event">
				<tr>
					<td><a href="/events/${event.id}"> <c:out
								value="${event.eventName}" />
					</a></td>
					<td><c:out value="${event.getEventDateFormatted()}" /></td>
					<td><c:out value="${event.city}" /></td>
					<td><c:out value="${event.planner.firstName}" /></td>
					<td>
				 	<c:choose>
						<c:when test="${event.attendees.contains(user)}">
							<a href="events/${event.id}/a/cancel">Cancel</a>
						</c:when>
						<c:otherwise>
							<a href="events/${event.id}/a/join">Join</a>
						</c:otherwise>
					</c:choose>
            		</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Here are some events in other states:</h3>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Event Name</th>
				<th>Date</th>
				<th>City</th>
				<th>State</th>
				<th>Host</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${eventsOutState}" var="event">
				<tr>
					<td><a href="/events/${event.id}"> <c:out
								value="${event.eventName}" />
					</a></td>
					<td><c:out value="${event.getEventDateFormatted()}" /></td>
					<td><c:out value="${event.city}" /></td>
					<td><c:out value="${event.state}" /></td>
					<td><c:out value="${event.planner.firstName}" /></td>
					<td>
				 <c:choose>
						<c:when test="${event.attendees.contains(user)}">
							<a href="events/${event.id}/a/cancel">Cancel</a>
						</c:when>
						<c:otherwise>
							<a href="events/${event.id}/a/join">Join</a>
						</c:otherwise>
					</c:choose>
            		</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</t:partial>