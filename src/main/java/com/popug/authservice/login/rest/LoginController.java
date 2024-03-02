package com.popug.authservice.login.rest;

import com.popug.authservice.login.exception.UserLoginException;
import com.popug.authservice.login.exception.UserNotFoundLoginException;
import com.popug.authservice.login.rest.model.LoginRequest;
import com.popug.authservice.login.rest.model.LoginResponse;
import com.popug.authservice.login.rest.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUseCase loginUseCase;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginUseCase.login(request));
    }

    @ExceptionHandler(UserNotFoundLoginException.class)
    private ResponseEntity<String> handleUserNotFound(UserNotFoundLoginException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    private ResponseEntity<String> handleUserLoginException(UserLoginException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }
}
