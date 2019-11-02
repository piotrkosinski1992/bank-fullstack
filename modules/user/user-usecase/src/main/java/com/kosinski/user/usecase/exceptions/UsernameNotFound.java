package com.kosinski.user.usecase.exceptions;

public class UsernameNotFound extends RuntimeException {
    public UsernameNotFound(String username) {
        super(String.format("User with given username: %s not found", username));
    }
}
