package com.kosinski.transaction.usecase.gateway;


import com.kosinski.transaction.domain.Transaction;

public interface TransactionCommandGateway {
    void save(Transaction transaction);
}
