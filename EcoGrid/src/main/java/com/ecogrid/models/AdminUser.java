package com.ecogrid.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUser extends User {
    public AdminUser(int userId, String username, String password, String email) {
        super(userId, username, password, "ADMIN", email);
    }

    // Polimorfismo dinâmico
    @Override
    public boolean authenticate() {
        // Autenticação com privilégios administrativos
        return true;
    }
}
