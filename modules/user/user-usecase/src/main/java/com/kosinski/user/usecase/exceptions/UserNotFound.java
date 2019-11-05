package com.kosinski.user.usecase.exceptions;

import com.kosinski.user.domain.UserId;

public class UserNotFound extends RuntimeException {

    public UserNotFound(UserId id) {
        super(String.format("user with id: %s not found", id.getValue().toString()));
    }

    public UserNotFound(String username) {
        super(String.format("User with given username: %s not found", username));
    }
}
