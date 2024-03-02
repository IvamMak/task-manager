package com.popug.authservice.login.exception;

public class UserLoginException extends RuntimeException {
    public UserLoginException() {
        super("Login or password is incorrect");
    }
}
