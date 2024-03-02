package com.popug.authservice.login.service.usecase;

import com.popug.authservice.jwt.rest.usecase.JwtUseCase;
import com.popug.authservice.login.exception.UserLoginException;
import com.popug.authservice.login.rest.model.LoginRequest;
import com.popug.authservice.login.rest.model.LoginResponse;
import com.popug.authservice.login.rest.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final JwtUseCase jwtUseCase;
    private final AuthenticationManager authenticationManager;


    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authenticate =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
        if (authenticate.isAuthenticated()) {
            return getToken(authenticate);
        }
        throw new UserLoginException();
    }

    private LoginResponse getToken(Authentication authenticate) {
        String token = jwtUseCase.generateToken(authenticate.getName());
        return new LoginResponse(token);
    }
}
