package com.kosinski.transaction.usecase.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.usecase.CreateAccount;
import com.kosinski.transaction.usecase.gateway.AccountCommandGateway;

@Service
public class CreateAccountUsecase implements CreateAccount
{
    private final AccountCommandGateway accountCommandGateway;

    public CreateAccountUsecase(AccountCommandGateway gateway)
    {
        accountCommandGateway = gateway;
    }

    @Override
    public void create(UUID id)
    {
        accountCommandGateway.save(Account.create(id));
    }
}
