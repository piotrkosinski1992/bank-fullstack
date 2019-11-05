package com.kosinski.user.usecase.impl;

import com.kosinski.events.UserRegisteredEvent;
import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.RegisterUsers;
import com.kosinski.user.usecase.exceptions.EmailAlreadyUsed;
import com.kosinski.user.usecase.gateways.UsersCommandGateway;
import com.kosinski.user.usecase.gateways.UsersQueryGateway;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUsersUsecase implements RegisterUsers {

    private final ApplicationEventPublisher eventPublisher;
    private final UsersCommandGateway usersCommandGateway;
    private final UsersQueryGateway usersQueryGateway;

    public RegisterUsersUsecase(ApplicationEventPublisher eventPublisher,
            UsersCommandGateway usersCommandGateway, UsersQueryGateway usersQueryGateway) {
        this.eventPublisher = eventPublisher;
        this.usersCommandGateway = usersCommandGateway;
        this.usersQueryGateway = usersQueryGateway;
    }

    @Override
    public void register(User user) {
        validateUser(user);
        usersCommandGateway.register(user);
        this.eventPublisher.publishEvent(new UserRegisteredEvent(this, user.getId().getValue()));
    }

    private void validateUser(User user) {
        Optional<User> optionalUser = usersQueryGateway.loadByEmail(user.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyUsed(user.getEmail());
        }
    }
}
