package com.kosinski.user.usecase.exceptions;

import com.kosinski.user.domain.Email;

public class EmailAlreadyUsed extends RuntimeException {
    public EmailAlreadyUsed(Email email) {
        super("Email already exists in our database: " + email.getValue());
    }
}
