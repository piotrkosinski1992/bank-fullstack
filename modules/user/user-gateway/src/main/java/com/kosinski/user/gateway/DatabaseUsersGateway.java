package com.kosinski.user.gateway;

import com.kosinski.domain.User;
import com.kosinski.usecase.gateways.UsersCommandGateway;
import com.kosinski.usecase.gateways.UsersQueryGateway;
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
    public Optional<User> loadByAccountNumber(int number) {
        return userRepository.findByAccountNumber(number);
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
