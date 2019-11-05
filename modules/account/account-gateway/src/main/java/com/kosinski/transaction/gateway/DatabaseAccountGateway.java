package com.kosinski.transaction.gateway;

import org.springframework.stereotype.Service;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.usecase.gateway.AccountCommandGateway;

@Service
public class DatabaseAccountGateway implements AccountCommandGateway
{
    private final AccountRepository accountRepository;

    public DatabaseAccountGateway(AccountRepository repository)
    {
        accountRepository = repository;
    }

    @Override
    public void save(Account account)
    {
        accountRepository.save(account);
    }
}
