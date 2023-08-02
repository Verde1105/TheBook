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

		<div class="form-group">
			<label for="pwd">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="Password">
		</div>

		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
		
	</form>
		<button id = "btn-update" class="btn btn-primary">회원 수정 완료</button>
</div>
		
		<script src="/js/user.js"></script>
		<%@ include file="../layout/footer.jsp" %>
	</body>
</html>


