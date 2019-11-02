package com.kosinski.user.usecase.impl;

import com.kosinski.transaction.domain.Transaction;
import com.kosinski.transaction.usecase.SaveTransaction;
import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.LoadUsers;
import com.kosinski.user.usecase.UpdateUserBalance;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserBalanceUsecase implements UpdateUserBalance {

    private final SaveTransaction saveTransaction;
    private final LoadUsers loadUsers;

    public UpdateUserBalanceUsecase(SaveTransaction saveTransaction, LoadUsers loadUsers) {
        this.saveTransaction = saveTransaction;
        this.loadUsers = loadUsers;
    }

    @Override
    public void pay(Transaction transaction) {
        User fromUser = loadUsers.loadByAccountNumber(transaction.getFrom());
        User toUser = loadUsers.loadByAccountNumber(transaction.getTo());

        fromUser.withdraw(transaction.getAmount());
        toUser.deposit(transaction.getAmount());

        saveTransaction(transaction, fromUser);
        saveTransaction(transaction, toUser);
    }

    private void saveTransaction(Transaction transaction, User user) {
        transaction.setBalance(user.getAccountBalance());
        transaction.setUsername(user.getUsername());
        saveTransaction.save(transaction);
    }
}
