package com.kosinski.transaction.usecase.impl;

import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.account.Account;
import com.kosinski.transaction.domain.transaction.Transaction;
import com.kosinski.transaction.usecase.LoadAccounts;
import com.kosinski.transaction.usecase.PerformTransaction;
import com.kosinski.transaction.usecase.gateway.TransactionCommandGateway;
import com.kosinski.user.domain.UserId;
import com.kosinski.user.usecase.LoadUsers;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PerformTransactionUsecase implements PerformTransaction {
    private final LoadAccounts loadAccounts;
    private final LoadUsers loadUsers;
    private final TransactionCommandGateway transactionCommandGateway;

    public PerformTransactionUsecase(LoadAccounts loadAccounts, LoadUsers loadUsers, TransactionCommandGateway transactionCommandGateway) {
        this.loadAccounts = loadAccounts;
        this.loadUsers = loadUsers;
        this.transactionCommandGateway = transactionCommandGateway;
    }

    @Transactional
    @Override
    public void save(Transaction transaction, String username) {
        Account fromAccount = getUserAccount(username);
        Account toAccount = loadAccounts.loadByAccountNumber(transaction.getTo());

        fromAccount.verifyWithdrawalPossibility(transaction.getAmount());
        fromAccount.withdraw(transaction.getAmount());
        toAccount.deposit(transaction.getAmount());

        transaction.setFrom(fromAccount.getNumber());
        fromAccount.addTransaction(prepareTransaction(transaction, fromAccount));
        toAccount.addTransaction(prepareTransaction(transaction, toAccount));
    }


    private Transaction prepareTransaction(Transaction transaction, Account account) {
        return Transaction.create()
                .setAmount(transaction.getAmount())
                .setMethod(transaction.getMethod())
                .setFrom(transaction.getFrom())
                .setTo(transaction.getTo())
                .setCurrentBalance(account.getBalance());
    }

    private Account getUserAccount(String username) {
        UserId userId = loadUsers.loadByUsername(username).getId();
        return loadAccounts.loadByUserId(userId);
    }
}
