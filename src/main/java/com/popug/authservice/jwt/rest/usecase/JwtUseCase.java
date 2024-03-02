package com.popug.authservice.jwt.rest.usecase;

public interface JwtUseCase {

    String generateToken(String username);

    void validateToken(String token);
}
