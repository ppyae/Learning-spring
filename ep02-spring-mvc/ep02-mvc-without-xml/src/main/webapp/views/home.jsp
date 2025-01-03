<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mvc</title>
</head>
<body>

	<h1>Hello Mvc Without xml</h1>
	
	<ul>
		<li>
			<c:forEach var="item" items="${list}">
				<li>${item.name}</li>
			</c:forEach>
		</li>
	</ul>
	<div>
		<a href="${pageContext.request.contextPath}/legacy">Legacy Controller</a>
	</div>

</body>
</html>