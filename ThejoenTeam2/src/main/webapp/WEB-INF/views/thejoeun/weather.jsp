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

		<!-- Content -->
		<section>
			<header class="main">
				<h1>Weather Test Page Widget</h1>
			</header>
			
			<script>
        (function(d, s, id) {
            if (d.getElementById(id)) {
                if (window.__TOMORROW__) {
                    window.__TOMORROW__.renderWidget();
                }
                return;
            }
            const fjs = d.getElementsByTagName(s)[0];
            const js = d.createElement(s);
            js.id = id;
            js.src = "https://www.tomorrow.io/v1/widget/sdk/sdk.bundle.min.js";

            fjs.parentNode.insertBefore(js, fjs);
        })(document, 'script', 'tomorrow-sdk');
        </script>

        <div class="tomorrow"
           data-location-id="065306"
           data-language="KO"
           data-unit-system="METRIC"
           data-skin="light"
           data-widget-type="upcoming"
           style="padding-bottom:22px;position:relative;"
        >
          <a
            href="https://www.tomorrow.io/weather-api/"
            rel="nofollow noopener noreferrer"
            target="_blank"
            style="position: absolute; bottom: 0; transform: translateX(-50%); left: 50%;"
          >
          </a>
        </div>
        
			<hr>
		
		<script>
        (function(d, s, id) {
            if (d.getElementById(id)) {
                if (window.__TOMORROW__) {
                    window.__TOMORROW__.renderWidget();
                }
                return;
            }
            const fjs = d.getElementsByTagName(s)[0];
            const js = d.createElement(s);
            js.id = id;
            js.src = "https://www.tomorrow.io/v1/widget/sdk/sdk.bundle.min.js";

            fjs.parentNode.insertBefore(js, fjs);
        })(document, 'script', 'tomorrow-sdk');
        </script>

        <div class="tomorrow"
           data-location-id="065306"
           data-language="KO"
           data-unit-system="METRIC"
           data-skin="light"
           data-widget-type="aqiMini"
           style="padding-bottom:22px;position:relative;"
        >
          <a
            href="https://www.tomorrow.io/weather-api/"
            rel="nofollow noopener noreferrer"
            target="_blank"
            style="position: absolute; bottom: 0; transform: translateX(-50%); left: 50%;"
          >
          </a>
        </div>
		
			<hr>
			
			<script>
        (function(d, s, id) {
            if (d.getElementById(id)) {
                if (window.__TOMORROW__) {
                    window.__TOMORROW__.renderWidget();
                }
                return;
            }
            const fjs = d.getElementsByTagName(s)[0];
            const js = d.createElement(s);
            js.id = id;
            js.src = "https://www.tomorrow.io/v1/widget/sdk/sdk.bundle.min.js";

            fjs.parentNode.insertBefore(js, fjs);
        })(document, 'script', 'tomorrow-sdk');
        </script>

        <div class="tomorrow"
           data-location-id="065306"
           data-language="KO"
           data-unit-system="METRIC"
           data-skin="light"
           data-widget-type="aqiPollutant"
           style="padding-bottom:22px;position:relative;"
        >
          <a
            href="https://www.tomorrow.io/weather-api/"
            rel="nofollow noopener noreferrer"
            target="_blank"
            style="position: absolute; bottom: 0; transform: translateX(-50%); left: 50%;"
          >
          </a>
        </div>
			
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