package com.kosinski.transaction.usecase;


import com.kosinski.transaction.domain.transaction.Transaction;

public interface PerformTransaction {
    void save(Transaction transaction, String username);
}
