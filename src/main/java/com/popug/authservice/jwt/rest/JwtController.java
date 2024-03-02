package com.popug.authservice.jwt.rest;

import com.popug.authservice.jwt.rest.usecase.JwtUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
@AllArgsConstructor
public class JwtController {
    private final JwtUseCase jwtUseCase;

    @GetMapping("/validate")
    public void validateToken(@RequestParam(name = "username") String username,
                                                 @RequestParam(name = "token") String token) {
        jwtUseCase.validateToken(token);
    }
}
