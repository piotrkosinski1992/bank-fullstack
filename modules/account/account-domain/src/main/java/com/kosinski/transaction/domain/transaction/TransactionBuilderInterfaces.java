package com.kosinski.transaction.domain.transaction;

import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.account.AccountNumber;

public class TransactionBuilderInterfaces {

    public interface AmountBuilderInterface {
        TransactionMethodBuilderInterface setAmount(Money amount);
    }

    public interface TransactionMethodBuilderInterface {
        FromBuilderInterface setMethod(TransactionMethod method);
    }

    public interface FromBuilderInterface {
        ToBuilderInterface setFrom(AccountNumber from);
    }

    public interface ToBuilderInterface {
        CurrentBalanceBuilderInterface setTo(AccountNumber to);
    }

    public interface CurrentBalanceBuilderInterface {
        Transaction setCurrentBalance(Money currentBalance);
    }
}
