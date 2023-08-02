package com.thejoeun.team2.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Socket {
	
	@GetMapping("/socket")
	public void socket(String text, Session session) {
		try {
			onMessage(text, session);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String text, Session session) throws IOException {
		
		int index = text.indexOf("|");
		String id = text.substring(0,index);
		String message = text.substring(index+1);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss] ");
    	
		System.out.println(inputDateFormat.format(date)+" <"+id+"> "+message);
		synchronized(clients) {
			for(Session client : clients) {
				if(!client.equals(session)) {
					client.getBasicRemote().sendText(text);
				}
			}
		}
	}
    
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session);
        clients.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }
}