<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="jakarta.tags.core"%>

<ul class="nav flex-column">
	<li class="nav-item">
		<c:url value="/inputs" var="inputs">
			<c:param name="day" value="TUESDAY"/>
			<c:param name="value" value="01"/>
			<c:param name="date" value="2025-01-09"/>
		</c:url>
		<a href="${inputs}" class="nav-link">Query Param</a>
	</li>
	<li class="nav-item">
		<a href="${root}/inputs/javaBean" class="nav-link">Get Form Param</a>
	</li>
	<li class="nav-item">
		<a href="" class="nav-link">Post Form Param</a>
	</li>
	<li class="nav-item">
		<a href="" class="nav-link">Path Variable</a>
	</li>
</ul>