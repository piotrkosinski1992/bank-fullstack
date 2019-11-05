package com.kosinski.transaction.usecase.impl;

import com.kosinski.transaction.domain.account.AccountNumber;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(AccountNumber number) {
        super(String.format("Account with given account number: %s doesn't exist", number.getValue()));
    }
}
