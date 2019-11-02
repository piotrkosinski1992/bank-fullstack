package com.kosinski.transaction.gateway;

import com.kosinski.transaction.domain.Transaction;
import com.kosinski.transaction.domain.TransactionId;
import com.kosinski.transaction.domain.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
}
