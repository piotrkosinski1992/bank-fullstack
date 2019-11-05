package com.kosinski.transaction.gateway;

import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.domain.account.AccountNumber;
import com.kosinski.user.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, AccountNumber>
{
    Optional<Account> findByUserId(UserId userId);
}
