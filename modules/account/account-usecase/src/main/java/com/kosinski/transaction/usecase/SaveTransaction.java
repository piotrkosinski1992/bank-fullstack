package com.kosinski.transaction.usecase;


import com.kosinski.transaction.domain.transaction.Transaction;

public interface SaveTransaction {
    void save(Transaction transaction);
}
