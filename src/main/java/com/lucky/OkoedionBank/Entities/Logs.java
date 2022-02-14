package com.lucky.OkoedionBank.Entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String source_class_name;
    @Column(nullable = false)
    private String event_description;
    @Column(nullable = false)
    private String timestamp;


    public Logs() {

    }

    public Logs(String source_class_name, String event_description, String timestamp) {
        super();
        this.event_description = event_description;
        this.source_class_name = source_class_name;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource_class_name() {
        return source_class_name;
    }

    public void setSource_class_name(String source_class_name) {
        this.source_class_name = source_class_name;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
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
        if (!(o instanceof Logs)) return false;
        Logs logs = (Logs) o;
        return getId().equals(logs.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
