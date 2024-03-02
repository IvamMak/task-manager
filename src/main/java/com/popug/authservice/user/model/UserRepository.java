package com.popug.authservice.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value = """
            SELECT * FROM user u
                WHERE u.Username = :username
            """)
    Optional<UserEntity> findByUsername(String username);
}
