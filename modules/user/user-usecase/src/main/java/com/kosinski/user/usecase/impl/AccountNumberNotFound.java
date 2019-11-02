package com.kosinski.user.usecase.impl;

class AccountNumberNotFound extends RuntimeException {
    AccountNumberNotFound(int accNumber) {
        super(String.format("Account number %s doesn't exist!", accNumber));
    }
}
