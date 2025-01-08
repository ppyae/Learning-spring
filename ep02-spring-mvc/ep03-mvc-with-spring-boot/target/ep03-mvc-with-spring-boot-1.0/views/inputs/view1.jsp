<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

	<app:layout>
		<h4>Input Params</h4>
		
		<app:sidebar menu="inputs.jsp">
			<h1>Query params</h1>
			<table class="table table-bordered w-50">
				<tr>
					<td>Day</td>
					<td>${day}</td>
				</tr>
				<tr>
					<td>Count</td>
					<td>${value}</td>
				</tr>
				<tr>
					<td>Date</td>
					<td>${date}</td>
				</tr>
			</table>
		</app:sidebar>
	</app:layout>