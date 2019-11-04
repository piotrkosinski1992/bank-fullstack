package com.kosinski.user.usecase.impl;

import com.kosinski.user.usecase.UpdateUserBalance;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserBalanceUsecase implements UpdateUserBalance {

/*    private final SaveTransaction saveTransaction;
    private final LoadUsers loadUsers;

    public UpdateUserBalanceUsecase(SaveTransaction saveTransaction, LoadUsers loadUsers) {
        this.saveTransaction = saveTransaction;
        this.loadUsers = loadUsers;
    }*/

    @Override
    public void transfer() {
/*        User fromUser = loadUsers.loadByAccountNumber(transaction.getFrom());
        User toUser = loadUsers.loadByAccountNumber(transaction.getTo());

        fromUser.withdraw(transaction.getAmount());
        toUser.deposit(transaction.getAmount());

        saveTransaction(transaction, fromUser);
        saveTransaction(transaction, toUser);*/
    }

    private void saveTransaction() {
/*        transaction.setBalance(user.getAccountBalance());
        transaction.setUsername(user.getUsername());
        saveTransaction.save(transaction);*/
    }
}
