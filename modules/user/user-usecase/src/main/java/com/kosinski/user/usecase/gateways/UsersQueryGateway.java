package com.kosinski.user.usecase.gateways;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.User;

import java.util.Optional;

public interface UsersQueryGateway {
    Optional<User> loadByEmail(Email email);
}
