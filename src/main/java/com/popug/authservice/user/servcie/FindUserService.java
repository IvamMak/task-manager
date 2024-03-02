package com.popug.authservice.user.servcie;

import com.popug.authservice.user.domain.User;
import com.popug.authservice.user.servcie.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserService {
    private final UserDao dao;

    public Optional<User> find(String username) {
        return dao.find(username);
    }
}
