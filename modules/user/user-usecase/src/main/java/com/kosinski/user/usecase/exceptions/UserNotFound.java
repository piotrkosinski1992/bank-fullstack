package com.kosinski.user.usecase.exceptions;

import com.kosinski.user.domain.EntityId;

public class UserNotFound extends RuntimeException {

    public UserNotFound(EntityId id) {
        super(String.format("user with id: %s not found", id.getValue().toString()));
    }
}
