package com.kosinski.transaction.gateway;

import com.kosinski.transaction.domain.account.AccountNumber;
import com.kosinski.transaction.usecase.gateway.AccountQueryGateway;
import com.kosinski.user.domain.UserId;
import org.springframework.stereotype.Service;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.usecase.gateway.AccountCommandGateway;

import java.util.Optional;

@Service
public class DatabaseAccountGateway implements AccountCommandGateway, AccountQueryGateway
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

    @Override
    public Optional<Account> loadByAccountNumber(AccountNumber number) {
        return accountRepository.findById(number);
    }

    @Override
    public Optional<Account> loadByUserId(UserId userId) {
        return accountRepository.findByUserId(userId);
    }
}
