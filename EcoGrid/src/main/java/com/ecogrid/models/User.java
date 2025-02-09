package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    private String email;
    private List<SecurityLog> securityLogs = new ArrayList<>();

    // Constructors, Getters, and Setters
    public User() {}

    public User(int userId, String username, String password, String role, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public boolean authenticate() {
        // Implementação de autenticação
        return true;
    }

    public void logAction(String eventType, String description) {
        SecurityLog log = new SecurityLog(eventType, description);
        securityLogs.add(log);
    }
}
