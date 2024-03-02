package com.popug.authservice.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private UserRole userRole;
    private String password;

    public User(Long id, UserRole userRole, String password, String username) {
        this.id = id;
        this.userRole = userRole;
        this.password = password;
        this.username = username;
    }

    public User(UserRole userRole, String password, String username) {
        this.userRole = userRole;
        this.password = password;
        this.username = username;
    }
}
