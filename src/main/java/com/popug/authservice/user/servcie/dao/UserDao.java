package com.popug.authservice.user.servcie.dao;

import com.popug.authservice.user.domain.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);

    Optional<User> find(String username);
}
