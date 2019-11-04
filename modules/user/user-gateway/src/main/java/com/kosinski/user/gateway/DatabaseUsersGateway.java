package com.kosinski.user.gateway;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.gateways.UsersCommandGateway;
import com.kosinski.user.usecase.gateways.UsersQueryGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseUsersGateway implements UsersCommandGateway, UsersQueryGateway {

    private final UserRepository userRepository;

    public DatabaseUsersGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> loadByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public Optional<User> loadByEmail(Email email) {
        return userRepository.findByEmailValue(email.getValue());
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
