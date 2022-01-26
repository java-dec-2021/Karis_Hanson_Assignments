<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:partial>

		<h5>Edit Project - ${editProject.projectName}</h5>
		
		<form:form action="/projects/update/${editProject.id}" method="post"
			modelAttribute="editedProject">

			<div class="form-group">
				<form:label path="projectName">Project Name:</form:label>
				<form:errors class="text-danger" path="projectName" />
				<form:input class="form-control" path="projectName"
					value="${editProject.projectName}" />
			</div>
			<div class="form-group mb-2">
				<form:label path="description">Description:</form:label>
				<form:errors class="text-danger" path="description" />
				<form:input class="form-control" path="description"
					value="${editProject.description}" />

			</div>
			<input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>

</t:partial>