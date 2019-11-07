package com.kosinski.user.gateway;


import com.kosinski.user.domain.User;
import com.kosinski.user.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmailValue(String value);
}
