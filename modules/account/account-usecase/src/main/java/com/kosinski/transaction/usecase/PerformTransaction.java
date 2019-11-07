package com.kosinski.transaction.usecase;


import com.kosinski.transaction.domain.transaction.Transaction;
import com.kosinski.user.domain.Email;

public interface PerformTransaction {
    void save(Transaction transaction, Email email);
}
