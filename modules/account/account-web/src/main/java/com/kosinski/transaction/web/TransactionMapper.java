package com.kosinski.transaction.web;

import java.util.Arrays;

import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.account.AccountNumber;
import org.springframework.stereotype.Component;

import com.kosinski.transaction.domain.Currency;
import com.kosinski.transaction.domain.transaction.Transaction;
import com.kosinski.transaction.domain.transaction.TransactionMethod;
import com.kosinski.transaction.web.exceptions.InvalidTransactionMethod;
import com.kosinski.transaction.web.exceptions.UnsupportedCurrency;

@Component
class TransactionMapper
{
    Transaction toEntity(TransactionCommandDTO dto)
    {
        return Transaction.create()
                .setAmount(Money.create(convertToCurrency(dto.getCurrency()), dto.getAmount()))
                .setMethod(convertToTransactionMethod(dto.getMethod()))
                .setFrom(null)
                .setTo(convertToAccountNumber(dto.getTo()))
                .setCurrentBalance(null); //TODO zrobic jako optional parameter
    }

    private AccountNumber convertToAccountNumber(Long to) {
        return AccountNumber.create(to);
    }

    private TransactionMethod convertToTransactionMethod(String method)
    {
        return Arrays.stream(TransactionMethod.values())
                .filter(tm -> tm.name().equals(method))
                .findFirst()
                .orElseThrow(() -> new InvalidTransactionMethod(method));
    }

    private Currency convertToCurrency(String currency)
    {
        return Arrays.stream(Currency.values())
                .filter(c -> c.name().equals(currency))
                .findFirst()
                .orElseThrow(() -> new UnsupportedCurrency(currency));
    }
}
