<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="menu" type="java.lang.String" required="true" %>
<div class="row">
	<div class="col-3">
	
		<jsp:include page="/includes/${menu}"></jsp:include>
	</div>
	
	<div class="col">
		<jsp:doBody></jsp:doBody>
	</div>
</div>