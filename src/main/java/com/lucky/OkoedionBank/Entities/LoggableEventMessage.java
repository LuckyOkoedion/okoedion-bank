package com.lucky.OkoedionBank.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoggableEventMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
