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
										<c:choose>
											<c:when test="${empty principal}">
													<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
													<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
											</c:when>
												<c:otherwise>
													<ul class="navbar-nav">
														<li class="nav-item"><a class="nav-link" href="/thejoeun/board/saveForm">글쓰기</a></li>
														<li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
														<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
													</ul>
												</c:otherwise>
										</c:choose>
										<li><a href="https://twitter.com/?lang=ko" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="https://ko-kr.facebook.com/" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
										<li><a href="https://www.instagram.com/" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
									</ul>
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h1>Health Community Project </h1>
											<p></p>
										</header>
										<p>더조은 종로구 보건소는 언제나 방역을 위해 최선을 다합니다!</p>
										<ul class="actions">
											<li><a href="#" class="button big">더 알아볼래요?</a></li>
										</ul>
									</div>
									<span class="image object">
										<img src="/images/보건소이미지.jpg" alt="" />
									</span>
								</section>

							<!-- Section -->
							<section>
								<header class="major">
									<h2>방역을 위한 작은 실천!</h2>
								</header>
								<div class="features">
									<article>
										<div class="content">
										<img src="/images/free-icon-hand-washing-2853684.jpg" width="200px" height="200px" alt="손씻기 아이콘" />
										<a href="https://www.flaticon.com/kr/free-icons/-" target="_blank" title="손 씻기 아이콘  제작자: Konkapp - Flaticon"></a>
											<h3>깨끗이 손씻기</h3>
										</div>
									</article>
									
									<article>
										<div class="content">
											<img src="/images/free-icon-cough-2755798.jpg" width="200px" height="200px" alt="기침 아이콘" />
											<a href="https://www.flaticon.com/kr/free-icons/" target="_blank" title="기침 아이콘  제작자: Freepik - Flaticon"></a>
											<h3>기침시 입을 가리고</h3>
										</div>
									</article>
									<article>
										<div class="content">
											<img src="/images/free-icon-mask-7066301.jpg" width="250px" height="250px" alt="마스크 아이콘" />
											<a href="https://www.flaticon.com/kr/free-icons/" target="_blank" title="마스크 아이콘  제작자: smashingstocks - Flaticon"></a>
											<h3>증상이 있을 시 마스크 착용</h3>
										</div>
									</article>
									<article>
										<div class="content">
											<img src="/images/free-icon-dizziness-3997708.jpg" width="200px" height="200px" alt="피곤한 아이콘" />
											<a href="https://www.flaticon.com/kr/free-icons/" target="_blank" title="피곤한 아이콘  제작자: Freepik - Flaticon"></a>
											<h3>빠른 시일 내 내원</h3>
										</div>
									</article>
								</div>
							</section>

							<!-- Section -->
								<section>
									<header class="major">
										<h2>카드뉴스</h2>
									</header>
									<div class="posts">
										<article>
											<a href="/thejoeun/writing/disease" class="image"><img src="/images/무더운_여름_온열질환을_조심하세요!_카드뉴스1.jpg" alt="" /></a>
											<h3>무더운 여름 온열질환을 주의하세요!</h3>
											<ul class="actions">
												<li><a href="/thejoeun/writing/disease" class="button">자세히보기</a></li>
											</ul>
										</article>
										<article>
											<a href="/thejoeun/writing/infectious" class="image"><img src="/images/신종감염병_대유행_대비_중장기_계획_카드_뉴스_JPG_1.jpg" alt="" /></a>
											<h3>신종 감염병 대유행 대비 중장기 계획</h3>
											<ul class="actions">
												<li><a href="/thejoeun/writing/infectious" class="button">자세히보기</a></li>
											</ul>
										</article>
										<article>
											<a href="/thejoeun/writing/respiratory" class="image"><img src="/images/호흡기세포융합바이러스_감염증_알아보기_카드_뉴스_JPG_1.jpg" alt="" /></a>
											<h3>호흡기세포융합바이러스 감염증 알아보기</h3>
											<ul class="actions">
												<li><a href="/thejoeun/writing/respiratory" class="button">자세히보기</a></li>
											</ul>
										</article>
										<article>
											<a href="/thejoeun/writing/quarantine" class="image"><img src="/images/검역관리_기본계획_카드뉴스_1_1.jpg" alt="" /></a>
											<h3>검역관리 기본 계획</h3>
											<ul class="actions">
												<li><a href="/thejoeun/writing/quarantine" class="button">자세히보기</a></li>
											</ul>
										</article>
										<article>
											<a href="/thejoeun/writing/mpox_guest" class="image"><img src="/images/엠폭스_방문자용.jpg" alt="" /></a>
											<h3>발생지역 방문자용 엠폭스 안내문</h3>
											<ul class="actions">
												<li><a href="/thejoeun/writing/mpox_guest" class="button">자세히보기</a></li>
											</ul>
										</article>
										<article>
											<a href="/thejoeun/writing/mpox_people" class="image"><img src="/images/엠폭스_대국민용.jpg" alt="" /></a>
											<h3>엠폭스 대국민용 안내문</h3>
											<ul class="actions">
												<li><a href="/thejoeun/writing/mpox_people" class="button">자세히보기</a></li>
											</ul>
										</article>
									</div>
								</section>

						</div>
					</div>

				<!-- 위로가는 바 
					<a href="#" class="actions">
						<i class="xi-angle-up-min"></i>
						<span>TOP</span>
					</a>
				-->
					
				<!-- Sidebar -->
				<%@ include file="layout/Sidebar.jsp" %>
			</div>

		<!-- Scripts -->
			<script src="/assets/js/jquery.min.js"></script>
			<script src="/assets/js/browser.min.js"></script>
			<script src="/assets/js/breakpoints.min.js"></script>
			<script src="/assets/js/util.js"></script>
			<script src="/assets/js/main.js"></script>
			
			<!-- 말풍선아이콘 클릭시 채팅창 열고 닫기 -->
			
	</body>
</html>