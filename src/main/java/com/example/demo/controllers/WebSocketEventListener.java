package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebSocketEventListener {

    public static List<String> sessions = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
        String simpSessionId = (String) event.getMessage().getHeaders().get("simpSessionId");
        //TODO OGet user data from message headers
        sessions.add(simpSessionId);
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        String simpSessionId = (String) event.getMessage().getHeaders().get("simpSessionId");
        sessions.remove(simpSessionId);
        logger.info("User with session id: " + simpSessionId + " disconnected");
    }
}
