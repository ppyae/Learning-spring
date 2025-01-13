<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

	<app:layout>
		<h4>Input Params</h4>
		
		<app:sidebar menu="inputs.jsp">
			<h1>Get Form</h1>
			
			<form action="${root}/inputs/get/form" class="w-50">
				<div>
					<label  class="form-label">Day of Week</label>
					<select  class="form-select">
						<option value="">Select One</option>
						<c:forEach var="item" items="${days}">
							<option value="${item}">${item}</option>
						</c:forEach>
					</select>
				</div>
			</form>
			
		</app:sidebar>
	</app:layout>