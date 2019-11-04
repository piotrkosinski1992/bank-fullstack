package com.kosinski.user.usecase.impl;

class AccountNumberNotFound extends RuntimeException {
    AccountNumberNotFound(long accNumber) {
        super(String.format("Account number %s doesn't exist!", accNumber));
    }
}
