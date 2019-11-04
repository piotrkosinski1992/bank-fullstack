package com.kosinski.transaction.gateway;


import com.kosinski.transaction.domain.transaction.Transaction;
import com.kosinski.transaction.domain.transaction.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
}
