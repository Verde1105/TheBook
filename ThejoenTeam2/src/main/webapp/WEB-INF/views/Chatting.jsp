<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--     채팅창 -->
	<div id="_chatbox_index" style="display: none">
		<fieldset>
			<div id="messageWindow" style="overflow: auto; height:250px;"></div>
			<br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
			<input type="submit" value="send" onclick="send()" />
		</fieldset>
	</div>


<!-- 말풍선아이콘 클릭시 채팅창 열고 닫기 -->
<script>
	//index
	$(".chat_index").on({
		"click" : function() {
			if ($(this).attr("src") == "<%=request.getContextPath()%>/company/images/chat.png") {
				console.log("INDEX TEST")
				$(".chat_index").attr("src", "<%=request.getContextPath()%>/company/images/chathide.png");
				$("#_chatbox_index").css("display", "block");
			} else if ($(this).attr("src") == "<%=request.getContextPath()%>/company/images/chathide.png") {
				$(".chat_index").attr("src", "<%=request.getContextPath()%>/company/images/chat.png");
				$("#_chatbox_index").css("display", "none");
			}
		}
	});

	//Chat/CHATTING
	$(".chat").on({
		"click" : function() {
			if ($(this).attr("src") == "<%=request.getContextPath()%>/company/images/chat.png") {
				console.log("TEST")
				$(".chat").attr("src", "<%=request.getContextPath()%>/company/images/chathide.png");
				$("#_chatbox").css("display", "block");
			} else if ($(this).attr("src") == "<%=request.getContextPath()%>/company/images/chathide.png") {
				$(".chat").attr("src", "<%=request.getContextPath()%>/company/images/chat.png");
				$("#_chatbox").css("display", "none");
			}
		}
	});
	
	// Chat/MEGAZONE CHATTING
	$(".chat_megazone").on({
		"click" : function() {
			console.log("MEGAZONE TEST")
			if ($(this).attr("src") == "<%=request.getContextPath()%>/company/images/MEGAZONE CLOUD CI_03.png") {
				$(".chat_megazone").attr("src", "<%=request.getContextPath()%>/company/images/MEGAZONE CLOUD CI_02.png");
				$("#_chatbox_megazone").css("display", "block");
			} else if ($(this).attr("src") == "<%=request.getContextPath()%>/company/images/MEGAZONE CLOUD CI_02.png") {
				$(".chat_megazone").attr("src", "<%=request.getContextPath()%>/company/images/MEGAZONE CLOUD CI_03.png");
				$("#_chatbox_megazone").css("display", "none");
			}
		}
	});
	
	
	/* $(function test(){
		$('#messageWindow').scrollTop($('#messageWindow')[0].scrollHeight)
	});  */

</script>

<script type="text/javascript">
	var textarea = document.getElementById("messageWindow");
	var webSocket = new WebSocket('ws://<%=request.getServerName() %>:8080/JSP/broadcasting');
	var inputMessage = document.getElementById('inputMessage');
	webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event)
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
		var message = event.data.split("|");
		var sender = message[0];
		var content = message[1];
		if (content == "") {

		} else {
			if (content.match("/")) {
				if (content.match(("/" + $("#chat_id").val()))) {
					var temp = content.replace("/" + $("#chat_id").val(),
							"(귓속말) :").split(":");
					if (temp[1].trim() == "") {
					} else {
						$("#messageWindow").html(
								$("#messageWindow").html()
										+ "<p class='whisper'>"
										+ sender
										+ content.replace("/"
												+ $("#chat_id").val(),
												"(귓속말) :") + "</p>");
					}
				} else {
				}
			} else {
				if (content.match("!")) {
					$("#messageWindow")
							.html(
									$("#messageWindow").html()
											+ "<p class='chat_content'><b class='impress'>"
											+ sender + " : " + content
											+ "</b></p>");
				} else {
					$("#messageWindow").html(
							$("#messageWindow").html()
									+ "<p class='chat_content'>" + sender
									+ " : " + content + "</p>");
				}
			}
		}
	}
	function onOpen(event) {
		$("#messageWindow").html("<p class='chat_content'>채팅에 참여하였습니다.</p>");
	}
	function onError(event) {
		alert(event.data);
	}
	function send() {
		if (inputMessage.value == "") {
		} else {
			$("#messageWindow").html(
					$("#messageWindow").html() + "<p class='chat_content'>나 : "
							+ inputMessage.value + "</p>");
		}
		webSocket.send($("#chat_id").val() + "|" + inputMessage.value);
		inputMessage.value = "";
	}
	//     엔터키를 통해 send함
	function enterkey() {
		if (window.event.keyCode == 13) {
			send();
		}
	}
	//     채팅이 많아져 스크롤바가 넘어가더라도 자동적으로 스크롤바가 내려가게함
	window.setInterval(function() {
		var elem = document.getElementById('messageWindow');
		elem.scrollTop = elem.scrollHeight;
	}, 0);
</script>

</body>
</html>