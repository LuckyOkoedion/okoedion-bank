package com.lucky.OkoedionBank.Pojo;

public class LoggableEventMessage {
    private String messageText;
    private LoggableEventSource source;

    public LoggableEventMessage(String messageText, LoggableEventSource source) {
        this.source = source;
        this.messageText = messageText;
    }

    public LoggableEventSource getSource() {
        return source;
    }

    public void setSource(LoggableEventSource source) {
        this.source = source;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
