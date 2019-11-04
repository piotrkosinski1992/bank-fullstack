package com.kosinski.transaction.domain.transaction;

import com.kosinski.transaction.domain.Currency;

import java.math.BigDecimal;

public class TransactionBuilderInterfaces {

    public interface AmountBuilderInterface {
        TransactionMethodBuilderInterface setAmount(Currency currency, BigDecimal amount);
    }

    public interface TransactionMethodBuilderInterface {
        FromBuilderInterface setMethod(TransactionMethod method);

    }

    public interface FromBuilderInterface {
        ToBuilderInterface setFrom(Long from);
    }

    public interface ToBuilderInterface {
        Transaction setTo(Long to);
    }
}
