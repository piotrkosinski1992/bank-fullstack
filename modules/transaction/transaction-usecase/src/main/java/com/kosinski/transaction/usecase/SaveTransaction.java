package com.kosinski.transaction.usecase;


import com.kosinski.transaction.domain.Transaction;

public interface SaveTransaction {
    void save(Transaction transaction);
}
