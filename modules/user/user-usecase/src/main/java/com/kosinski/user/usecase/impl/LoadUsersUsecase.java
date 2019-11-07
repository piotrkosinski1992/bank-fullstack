package com.kosinski.user.usecase.impl;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.LoadUsers;
import com.kosinski.user.usecase.exceptions.UserNotFound;
import com.kosinski.user.usecase.gateways.UsersQueryGateway;
import org.springframework.stereotype.Service;

@Service
public class LoadUsersUsecase implements LoadUsers {

    private final UsersQueryGateway usersQueryGateway;

    public LoadUsersUsecase(UsersQueryGateway usersQueryGateway) {
        this.usersQueryGateway = usersQueryGateway;
    }

    @Override
    public User loadByEmail(Email email) {
        return usersQueryGateway.loadByEmail(email).orElseThrow(() -> new UserNotFound(email.getValue()));
    }
}
