package com.kosinski.user.usecase.impl;

import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.RegisterUsers;
import com.kosinski.user.usecase.gateways.UsersCommandGateway;
import com.kosinski.user.usecase.gateways.UsersQueryGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUsersUsecase implements RegisterUsers {

    private final UsersCommandGateway usersCommandGateway;
    private final UsersQueryGateway usersQueryGateway;

    public RegisterUsersUsecase(UsersCommandGateway usersCommandGateway, UsersQueryGateway usersQueryGateway) {
        this.usersCommandGateway = usersCommandGateway;
        this.usersQueryGateway = usersQueryGateway;
    }

    @Override
    public void register(User user) {
        validateUser(user);
        usersCommandGateway.register(user);
    }

    private void validateUser(User user) {
        Optional<User> optionalUser = usersQueryGateway.loadByEmail(user.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyUsed(user.getEmail());
        }
    }
}
