package com.kosinski.transaction.domain.transaction;

import com.kosinski.transaction.domain.Currency;
import com.kosinski.transaction.domain.Money;

import java.math.BigDecimal;

public class TransactionBuilder implements
        TransactionBuilderInterfaces.AmountBuilderInterface,
        TransactionBuilderInterfaces.TransactionMethodBuilderInterface,
        TransactionBuilderInterfaces.FromBuilderInterface,
        TransactionBuilderInterfaces.ToBuilderInterface {
    private Transaction transaction;


    TransactionBuilder() {
        transaction = new Transaction();
    }

    @Override
    public TransactionBuilderInterfaces.TransactionMethodBuilderInterface setAmount(Currency currency, BigDecimal amount) {
        transaction.setAmount(Money.create(currency, amount));
        return this;
    }

    @Override
    public TransactionBuilderInterfaces.FromBuilderInterface setMethod(TransactionMethod method) {
        transaction.setMethod(method);
        return this;

    }

    @Override
    public TransactionBuilderInterfaces.ToBuilderInterface setFrom(Long from) {
        transaction.setFrom(from);
        return this;

    }

    @Override
    public Transaction setTo(Long to) {
        transaction.setTo(to);
        return transaction;
    }
}
