<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Hello Jsp</h1>
	
	<ul>
		<li><a href="hello?name=Aung&phone=93839">Hello Servlet</a>
	</ul>
	<form method="get" action="hello">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" placeholder="Enter Name"> </td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" placeholder="Enter Phone"> </td>
			</tr>
			<tr>
				<td></td>
				<td> <button type="submit" >Send</button> </td>
			</tr>
		</table>
	</form>
</body>
</html>