package com.kosinski.user.usecase.impl;

import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.RegisterUsers;
import com.kosinski.user.usecase.gateways.UsersCommandGateway;
import org.springframework.stereotype.Service;

@Service
public class RegisterUsersUsecase implements RegisterUsers {

    private final UsersCommandGateway usersCommandGateway;

    public RegisterUsersUsecase(UsersCommandGateway usersCommandGateway) {
        this.usersCommandGateway = usersCommandGateway;
    }

    @Override
    public void register(User user) {
        usersCommandGateway.register(user);
    }
}
