package com.lucky.OkoedionBank.Entities;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class ActivityLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LoggableEventSource event_source;
    @Column(nullable = false)
    private LoggableEventMessage event_description;
    @Column(nullable = false)
    private String timestamp;


    public ActivityLogs() {

    }

    public ActivityLogs(LoggableEventSource event_source, LoggableEventMessage event_description) {
        super();
        this.event_description = event_description;
        this.event_source = event_source;
        this.timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoggableEventSource getEvent_source() {
        return event_source;
    }

    public void setEvent_source(LoggableEventSource event_source) {
        this.event_source = event_source;
    }

    public LoggableEventMessage getEvent_description() {
        return event_description;
    }

    public void setEvent_description(LoggableEventMessage event_description) {
        this.event_description = event_description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityLogs)) return false;
        ActivityLogs logs = (ActivityLogs) o;
        return getId().equals(logs.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
