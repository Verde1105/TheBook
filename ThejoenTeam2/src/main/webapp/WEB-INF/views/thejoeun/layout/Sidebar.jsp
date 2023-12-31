<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Sidebar -->
<div id="sidebar">
	<div class="inner">

		<!-- Search -->
		<section id="search" class="alt">
			<form method="post" action="#">
				<input type="text" name="query" id="query" placeholder="Search" />
			</form>
		</section>

		<!-- Menu -->
		<nav id="menu">
			<header class="major">
				<h2>HHR Menu</h2>
			</header>
			<ul>
				<li><a href="/thejoeun/index">Homepage</a></li>
				<!-- 
				<li><a href="/thejoeun/gen">Generic</a></li>
				<li><a href="/thejoeun/ele">Elements</a></li>
				 -->
				<li><a href="/thejoeun/board">Board</a></li>
				<li><a href="/thejoeun/weather">날씨 및 대기질 예보</a></li>
				<li>
					<span class="opener">계절별 질병</span>
					<ul>
						<li><a href="/thejoeun/spring">봄철 질병</a></li>
						<li><a href="/thejoeun/summer">여름철 질병</a></li>
						<li><a href="/thejoeun/autumn">가을철 질병</a></li>
						<li><a href="/thejoeun/winter">겨울철 질병</a></li>
					</ul>
				</li>
			</ul>
		</nav>

		<!-- Section -->

		<!-- Section -->
			<section>
				<header class="major">
				</header>
				<p>
				</p>
				<article>
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
				</article>
				<article>
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
				</article>
				
				<article>
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
				</article>
			</section>

		<!-- Footer -->
			<header>
			</header>
			<footer id="footer">
			
			</footer>

	</div>
</div>