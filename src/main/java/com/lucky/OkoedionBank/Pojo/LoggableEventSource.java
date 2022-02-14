package com.lucky.OkoedionBank.Pojo;

public class LoggableEventSource {
    private String className;

    public LoggableEventSource(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
