package com.kosinski.user.usecase.gateways;

import com.kosinski.user.domain.User;

import java.util.Optional;

public interface UsersQueryGateway {
    Optional<User> loadByUsername(String username);
    Optional<User> loadByAccountNumber(int number);
}
