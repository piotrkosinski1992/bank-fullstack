package com.kosinski.user.usecase;

import com.kosinski.user.domain.User;

public interface LoadUsers {
    User loadByUsername(String username);
}
