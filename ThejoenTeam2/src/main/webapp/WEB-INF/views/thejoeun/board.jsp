<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<%@ include file="layout/header.jsp" %>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
							<header id="header">
								<a href="https://www.jongno.go.kr/healthMain.do" class="logo"><strong>Health Community</strong> Project</a>
								<ul class="icons">
									<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
									<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
									<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
									<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
									<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
								</ul>
							</header>

							<!-- Content -->
							<section>
								<header class="main">
									<h2>게시판</h2>
								</header>
								<c:forEach var="board" items="${boards.content}">
									<div class="container">
										<div class="card M-2">
											<div class="card-body">
												<h6 class="card-title">${board.title}</h6>
												<a href="/thejoeun/board/${board.id}" class="btn btn-primary">상세보기</a>
											</div>
										</div>
									</div>
								</c:forEach>	
								<ul class = "pagination justify-content-center">
									<c:choose>
										<c:when test="${boards.first}">
											<li class = "page-item disabled"><a class = "page-link" href = "?page=${board.number-1}">Previous</a></li>
										</c:when>
										<c:otherwise>
											<li class = "page-item"><a class = "page-link" href = "?page=${board.number-1}">Previous</a></li>
										</c:otherwise>
									</c:choose>
							
									<c:choose>
										<c:when test="${boards.last}">
											<li class = "page-item disabled"><a class = "page-link" href = "?page=${board.number+1}">Next</a></li>
										</c:when>
										<c:otherwise>
											<li class = "page-item"><a class = "page-link" href = "?page=${board.number+1}">Next</a></li>
										</c:otherwise>
									</c:choose>
								</ul>

							</section>

						</div>
					</div>

				<!-- Sidebar -->
				<%@ include file="layout/Sidebar.jsp" %>
			</div>

		<!-- Scripts -->
			<script src="/assets/js/jquery.min.js"></script>
			<script src="/assets/js/browser.min.js"></script>
			<script src="/assets/js/breakpoints.min.js"></script>
			<script src="/assets/js/util.js"></script>
			<script src="/assets/js/main.js"></script>

	</body>
	
	

</html>


