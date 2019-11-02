package com.kosinski.transaction.gateway;

import com.kosinski.domain.Transaction;
import com.kosinski.domain.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,TransactionId> {
}
