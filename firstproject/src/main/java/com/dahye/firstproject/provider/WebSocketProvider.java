package com.dahye.firstproject.provider;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
class SessionGroup{
    private String room;
    private WebSocketSession session;

}
@Component
public class WebSocketProvider extends TextWebSocketHandler {
    //실제로는 handler에 진행해야하는것. 수업때만 provider에서 진행한다

    private List<SessionGroup> sessionList = new ArrayList<>();
    //접속되어 있는 세션의 리스트를 관리해줄수 있다.

    //모두 AbstractWebSocketHandler에서 기본적인 틀 가져옴

    // 1. 연결 (클라이언트와 서버 간의 연결) 
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        
        String room = session.getHandshakeHeaders().getFirst("room"); 
        //특정한 키를 이용해 값을 가져올수 있다. json형태인건가? 특정한 유저랑 연결을 유지할수 있게하는건가

        sessionList.add(new SessionGroup(room, session)); //session = room 이므로 하나로 관리를 하게 된다.
        System.out.println(room + " / " + session.getId() + " Web Socket Conneted!!");
	}

    // 2. 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //서버상에 메시지 수신했을때의 출력
        //System.out.println(message.getPayload());
        String room = session.getHandshakeHeaders().getFirst("room");
        for(SessionGroup sessionGroup : sessionList) {
            if(sessionGroup.getRoom().equals(room) && 
            !sessionGroup.getSession().equals(session)/* 내가 보낸 메시지는 나한테 안보이게 하는것 */){
                sessionGroup.getSession().sendMessage(message);
            }
        }
	}

    // 3. 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(session.getId() + "WebSocket Closed!");
        //관리하는 대상에서도 지우는 작업
        for(SessionGroup sessionGroup : sessionList){
            if(sessionGroup.getSession().equals(session)){
                sessionList.remove(sessionGroup);
            }
        }
            
                
	}
}
