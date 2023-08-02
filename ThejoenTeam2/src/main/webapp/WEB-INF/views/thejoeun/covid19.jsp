<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!DOCTYPE HTML>
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
				<li><a href="https://twitter.com/?lang=ko" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="https://ko-kr.facebook.com/" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
				<li><a href="https://www.instagram.com/" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
			</ul>
		</header>

	<div style="width: 300px; height: 400px;">
		<canvas id="covid19Chart"></canvas>
	</div>

	<!-- 
	 <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1"></script>
	 -->
	<script>
		function colorize() {
			var r = Math.floor(Math.random() * 100);
			var g = Math.floor(Math.random() * 100);
			var b = Math.floor(Math.random() * 100);
			var color = 'rgba(' + r + ', ' + g + ', ' + b + ', 0.7)';
			return color;
		}

		var jData = JSON.parse('${covid19}');
		var labelList = [];
		var valueList = [];
		var colorList = [];

		for (var i = 0; i < jData.length; i++) {
			var d = jData[i];
			labelList.push(d.day);
			valueList.push(d.people);
			colorList.push(colorize());
		}

		var data = {
			labels : labelList,
			datasets : [ {
				label : "코로나19 확진자", // UTF-8(BOM)
				backgroundColor : colorList,
				data : valueList
			} ]
		};

		var minmax = valueList.slice();
		var minTemp = Math.min.apply(null, minmax)
		var maxTemp = Math.max.apply(null, minmax) + 2000
		var options = {
			scales : {
				y : {
					beginAtZero : false,
					min : 0,
					max : maxTemp 
				}
			}
		};

		var ctx1 = document.getElementById('covid19Chart').getContext('2d');
		new Chart(ctx1, {
			type : 'bar',
			data : data,
			options : options
		});
	</script>
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