<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
		
<div class="container">
	<form>
		<div class="form-group">
			<input type="hidden" id="id" value="${principal.user.id }"/>
			<label for="Username">Username</label> 
			<input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter Username" id="Username" readonly>
		</div>
		<div class="valid-feedback">Valid.</div>
			
		<c:if test="${empty principal.user.oauth}">
			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="email">Email Address:</label> 
				<input type="email" value="${principal.user.email}" class="form-control" id="email" placeholder="Enter email" required readonly>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>				
	
		</c:if>
		
		<div class="form-group">
			<label for="pwd">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="Password">
		</div>

		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
		
	</form>
	<br />
	<br />
	<button id="btn-update" class="btn btn-primary">회원수정완료</button>
	<br />
</div>
		
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>


