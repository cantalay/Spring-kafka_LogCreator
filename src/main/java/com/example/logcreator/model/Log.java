package com.example.logcreator.model;

import java.io.Serializable;

public class Log implements Serializable {

    private String timestamp;

    private LogLevel logLevel;

    private LogCity logCity;

    private String detail;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public LogCity getLogCity() {
        return logCity;
    }

    public void setLogCity(LogCity logCity) {
        this.logCity = logCity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return timestamp.toString() + " " + this.logLevel.name().toUpperCase() + " " +
                this.logCity.name() + " " + this.detail;
    }
}
