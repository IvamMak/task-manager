package com.popug.authservice.login.rest.usecase;

import com.popug.authservice.login.rest.model.LoginRequest;
import com.popug.authservice.login.rest.model.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
}
