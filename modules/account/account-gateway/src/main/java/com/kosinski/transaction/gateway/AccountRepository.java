package com.kosinski.transaction.gateway;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.domain.account.AccountNumber;

public interface AccountRepository extends JpaRepository<Account, AccountNumber>
{
}
