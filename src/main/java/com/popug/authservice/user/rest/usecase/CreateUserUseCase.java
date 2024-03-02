package com.popug.authservice.user.rest.usecase;

import com.popug.authservice.user.rest.model.CreateUserRequest;

public interface CreateUserUseCase {
    void create(CreateUserRequest request);
}
