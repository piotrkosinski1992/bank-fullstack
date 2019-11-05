package com.kosinski.transaction.usecase;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.domain.account.AccountNumber;
import com.kosinski.user.domain.UserId;

public interface LoadAccounts {
    Account loadByAccountNumber(AccountNumber number);

    Account loadByUserId(UserId userId);
}
