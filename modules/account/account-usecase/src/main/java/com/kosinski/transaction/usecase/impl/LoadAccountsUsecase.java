package com.kosinski.transaction.usecase.impl;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.domain.account.AccountNumber;
import com.kosinski.transaction.usecase.LoadAccounts;
import com.kosinski.transaction.usecase.gateway.AccountQueryGateway;
import com.kosinski.user.domain.UserId;
import com.kosinski.user.usecase.exceptions.UserNotFound;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LoadAccountsUsecase implements LoadAccounts {

    private final AccountQueryGateway accountQueryGateway;

    public LoadAccountsUsecase(AccountQueryGateway accountQueryGateway) {
        this.accountQueryGateway = accountQueryGateway;
    }

    @Transactional
    @Override
    public Account loadByAccountNumber(AccountNumber number) {
        return accountQueryGateway.loadByAccountNumber(number)
                .orElseThrow(() -> new AccountNotFound(number));
    }

    @Override
    public Account loadByUserId(UserId userId) {
        return accountQueryGateway.loadByUserId(userId)
                .orElseThrow(() -> new UserNotFound(userId));
    }
}
