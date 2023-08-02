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
		<%@ include file="../layout/header.jsp" %>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
							<header id="header">
								<a href="index.jsp" class="logo"><strong>Editorial</strong> by HTML5 UP</a>
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
								
									<h2>글쓰기</h2>
								</header>

								<form>
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Enter title" id="title">
									</div>
									
									<div class="form-group">
										<textarea class = "from-control summernote" rows="5" id="content"></textarea>
									</div>
								</form>
								<button id ="Thejoeun-btn-save" class="btn btn-light">글쓰기 완료</button>
							</section>

						</div>
					</div>
				<script>
					$('.summernote').summernote({
						tabsize: 2,
						height: 300
					});
				</script>
				<!-- Sidebar -->
				<%@ include file="../layout/Sidebar.jsp" %>
			</div>

		<!-- Scripts -->
			<script src="/assets/js/jquery.min.js"></script>
			<script src="/assets/js/browser.min.js"></script>
			<script src="/assets/js/breakpoints.min.js"></script>
			<script src="/assets/js/util.js"></script>
			<script src="/assets/js/main.js"></script>
			<script src="/js/ThejoeunBoard.js"></script>

	</body>
</html>