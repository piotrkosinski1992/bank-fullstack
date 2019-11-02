package com.kosinski.user.usecase.gateways;


import com.kosinski.user.domain.User;

public interface UsersCommandGateway {
    void register(User user);
}
