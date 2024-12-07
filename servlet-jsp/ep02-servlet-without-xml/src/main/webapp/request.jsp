<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Dispatcher</title>
<jsp:include page="/bootstrap.jsp"></jsp:include>
</head>
<body>
<body>
	<div class="container mt-3">
		<h1>Hello from request Dispatcher</h1>
		
		<table class="table table-striped w-50">
			<tr>
				<td>ContextPath</td>
				<td>${contextPath}</td>
			</tr>
			<tr>
				<td>ServletPath</td>
				<td>${servletPath}</td>
			</tr>
			<tr>
				<td>SeverPort</td>
				<td>${severPort}</td>
			</tr>
		</table>

		<a href="./" class="btn btn-primary">Home</a>
	</div>
</body>
</html>

</body>

</html>