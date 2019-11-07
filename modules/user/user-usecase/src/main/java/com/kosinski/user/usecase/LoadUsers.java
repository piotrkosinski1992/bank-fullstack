package com.kosinski.user.usecase;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.User;

public interface LoadUsers {
    User loadByEmail(Email email);
}
