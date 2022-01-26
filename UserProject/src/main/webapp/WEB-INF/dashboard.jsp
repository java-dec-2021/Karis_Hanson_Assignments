<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:partial>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Project name</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td><a href="/projects/${project.id}"> <c:out
								value="${project.projectName}" />
					</a></td>
					<td><c:out value="${project.user.firstName}" /></td>
					<td><c:out value="${project.likers.size()}" /></td>
					
					<td>
				 <c:choose>
					 <c:when test="${project.likers.contains(user)}">
							<a href="/projects/unLike/${project.id}">Unlike</a>
					</c:when>
					<c:otherwise>
							<a href="/projects/like/${project.id}">Like</a>
					</c:otherwise>
					</c:choose>		
            		</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:partial>