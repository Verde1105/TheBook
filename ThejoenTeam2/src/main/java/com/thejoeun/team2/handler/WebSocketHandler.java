package com.thejoeun.team2.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 메시지를 받았을 때 처리 로직 구현
        String receivedMessage = message.getPayload();
        // ...
        session.sendMessage(new TextMessage("서버로부터 응답 메시지")); // 클라이언트로 응답 보내기
    }
}
