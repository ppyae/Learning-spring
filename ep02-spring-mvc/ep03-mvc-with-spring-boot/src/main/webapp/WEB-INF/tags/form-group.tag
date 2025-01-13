<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="label" required="true" %>
<%@ attribute name="cssClass" required="true" %>

<div class="${cssClass}">
	<label class="form-label">${label}</label> 
	<jsp:doBody/>
</div>
