package com.kosinski.user.gateway;

import com.kosinski.user.domain.EntityId;
import com.kosinski.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, EntityId> {
    Optional<User> findByUsername(String username);
    Optional<User> findByAccountNumber(Integer number);
}
