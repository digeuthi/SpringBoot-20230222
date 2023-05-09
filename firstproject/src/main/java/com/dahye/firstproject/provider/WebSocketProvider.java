package com.dahye.firstproject.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketProvider extends TextWebSocketHandler {
    //실제로는 handler에 진행해야하는것. 수업때만 provider에서 진행한다


    //모두 AbstractWebSocketHandler에서 기본적인 틀 가져옴

    // 1. 연결 (클라이언트와 서버 간의 연결) 
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	}

    // 2. 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	}

    // 3. 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}
}
