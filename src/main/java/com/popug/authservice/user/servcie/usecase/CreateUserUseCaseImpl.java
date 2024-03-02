package com.popug.authservice.user.servcie.usecase;

import com.popug.authservice.user.domain.User;
import com.popug.authservice.user.exception.UserAlreadyExistException;
import com.popug.authservice.user.rest.model.CreateUserRequest;
import com.popug.authservice.user.rest.usecase.CreateUserUseCase;
import com.popug.authservice.user.servcie.FindUserService;
import com.popug.authservice.user.servcie.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final PasswordEncoder passwordEncoder;
    private final FindUserService findUserService;
    private final UserDao dao;

    @Override
    public void create(CreateUserRequest request) {
        throwExceptionIfUserAlreadyExist(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(request.getUserRole(), encodedPassword, request.getUsername());
        dao.save(user);
    }

    private void throwExceptionIfUserAlreadyExist(CreateUserRequest request) {
        findUserService.find(request.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException(request.getUsername());
                });
    }
}
