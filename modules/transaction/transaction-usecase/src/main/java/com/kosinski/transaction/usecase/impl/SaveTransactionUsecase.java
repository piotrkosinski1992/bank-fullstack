package com.kosinski.transaction.usecase.impl;

import com.kosinski.transaction.domain.Transaction;
import com.kosinski.transaction.usecase.SaveTransaction;
import org.springframework.stereotype.Service;

@Service
public class SaveTransactionUsecase implements SaveTransaction {

    private final SaveTransaction saveTransaction;

    public SaveTransactionUsecase(SaveTransaction saveTransaction) {
        this.saveTransaction = saveTransaction;
    }

    @Override
    public void save(Transaction transaction) {
        saveTransaction.save(transaction);
    }
}
