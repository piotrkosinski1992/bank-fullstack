package com.kosinski.user.gateway;


import com.kosinski.user.domain.UserId;
import com.kosinski.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmailValue(String value);
}
