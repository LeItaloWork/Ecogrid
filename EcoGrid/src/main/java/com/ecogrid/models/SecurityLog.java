package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class SecurityLog {
    private int logId;
    private Date timestamp;
    private String eventType;
    private String description;

    public SecurityLog(String eventType, String description) {
        this.timestamp = new Date();
        this.eventType = eventType;
        this.description = description;
    }

    // Getters e Setters gerados automaticamente pelo Lombok
}
