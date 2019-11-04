package com.kosinski.transaction.usecase.gateway;


import com.kosinski.transaction.domain.transaction.Transaction;

public interface TransactionCommandGateway {
    void save(Transaction transaction);
}
