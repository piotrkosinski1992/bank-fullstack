package com.kosinski.transaction.domain.transaction;

import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.account.AccountNumber;

public class TransactionBuilder implements
        TransactionBuilderInterfaces.AmountBuilderInterface,
        TransactionBuilderInterfaces.TransactionMethodBuilderInterface,
        TransactionBuilderInterfaces.FromBuilderInterface,
        TransactionBuilderInterfaces.ToBuilderInterface,
        TransactionBuilderInterfaces.CurrentBalanceBuilderInterface{
    private Transaction transaction;


    TransactionBuilder() {
        transaction = new Transaction();
    }

    @Override
    public TransactionBuilderInterfaces.TransactionMethodBuilderInterface setAmount(Money amount) {
        transaction.setAmount(amount);
        return this;
    }

    @Override
    public TransactionBuilderInterfaces.FromBuilderInterface setMethod(TransactionMethod method) {
        transaction.setMethod(method);
        return this;
    }

    @Override
    public TransactionBuilderInterfaces.ToBuilderInterface setFrom(AccountNumber from) {
        transaction.setFrom(from);
        return this;

    }

    @Override
    public TransactionBuilderInterfaces.CurrentBalanceBuilderInterface setTo(AccountNumber to) {
        transaction.setTo(to);
        return this;
    }

    @Override
    public Transaction setCurrentBalance(Money currentBalance) {
        transaction.setCurrentBalance(currentBalance);
        return transaction;
    }
}
