package com.popug.authservice.login.exception;

public class UserNotFoundLoginException extends RuntimeException {
    public UserNotFoundLoginException(String username) {
        super(String.format("User with username %s was not found", username));
    }
}
