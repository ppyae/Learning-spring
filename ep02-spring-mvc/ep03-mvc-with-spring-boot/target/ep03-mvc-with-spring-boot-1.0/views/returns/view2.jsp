<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<app:layout>
	<h4>Return Type for Handler Methods</h4>

	<app:returns>
		<h1>Returning Model and View</h1>
		<ul>
			<c:forEach var="item" items="${days}">
				<li>${item}</li>
			</c:forEach>

		</ul>
		<p>${message}</p>
	</app:returns>
</app:layout>