package com.kosinski.transaction.usecase.impl;

import com.kosinski.transaction.domain.Transaction;
import com.kosinski.transaction.usecase.SaveTransaction;
import com.kosinski.transaction.usecase.gateway.TransactionCommandGateway;
import org.springframework.stereotype.Service;

@Service
public class SaveTransactionUsecase implements SaveTransaction {

    private final TransactionCommandGateway transactionCommandGateway;

    public SaveTransactionUsecase(TransactionCommandGateway transactionCommandGateway) {
        this.transactionCommandGateway = transactionCommandGateway;
    }

    @Override
    public void save(Transaction transaction) {
        transactionCommandGateway.save(transaction);
    }
}
