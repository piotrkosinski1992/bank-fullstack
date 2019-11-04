package com.kosinski.user.usecase.impl;

import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.LoadUsers;
import com.kosinski.user.usecase.exceptions.UsernameNotFound;
import com.kosinski.user.usecase.gateways.UsersQueryGateway;
import org.springframework.stereotype.Service;

@Service
public class LoadUsersUsecase implements LoadUsers {

    private final UsersQueryGateway usersQueryGateway;

    public LoadUsersUsecase(UsersQueryGateway usersQueryGateway) {
        this.usersQueryGateway = usersQueryGateway;
    }

    @Override
    public User loadByUsername(String username) {
        return usersQueryGateway.loadByUsername(username).orElseThrow(() -> new UsernameNotFound(username));
    }
}
