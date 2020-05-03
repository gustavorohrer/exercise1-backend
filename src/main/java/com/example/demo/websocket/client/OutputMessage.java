package com.example.demo.websocket.client;

public class OutputMessage extends Message {

    public static final String LEAVE = "LEAVE";
    public static final String JOIN = "JOIN";

    private String time;

    public OutputMessage() {
    }

    public OutputMessage(final String from, final String text, final String time) {
        setFrom(from);
        setText(text);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
