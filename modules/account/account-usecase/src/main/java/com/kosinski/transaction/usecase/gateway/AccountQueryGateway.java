package com.kosinski.transaction.usecase.gateway;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.domain.account.AccountNumber;
import com.kosinski.user.domain.UserId;

import java.util.Optional;

public interface AccountQueryGateway {
    Optional<Account> loadByAccountNumber(AccountNumber number);

    Optional<Account> loadByUserId(UserId userId);
}
