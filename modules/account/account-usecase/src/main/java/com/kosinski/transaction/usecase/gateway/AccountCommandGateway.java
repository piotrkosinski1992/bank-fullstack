package com.kosinski.transaction.usecase.gateway;

import com.kosinski.transaction.domain.account.Account;

public interface AccountCommandGateway
{
    void save(Account account);
}
