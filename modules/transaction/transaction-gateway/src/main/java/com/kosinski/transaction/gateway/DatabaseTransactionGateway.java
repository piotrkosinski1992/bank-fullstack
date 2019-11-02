package com.kosinski.transaction.gateway;

import com.kosinski.domain.Transaction;
import com.kosinski.gateway.TransactionRepository;
import com.kosinski.usecase.gateway.TransactionCommandGateway;
import com.kosinski.usecase.gateway.TransactionQueryGateway;
import org.springframework.stereotype.Service;

@Service
public class DatabaseTransactionGateway implements TransactionQueryGateway, TransactionCommandGateway {

    private final TransactionRepository transactionRepository;

    public DatabaseTransactionGateway(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
