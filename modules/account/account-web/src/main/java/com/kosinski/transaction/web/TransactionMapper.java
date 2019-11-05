package com.kosinski.transaction.web;

import java.util.Arrays;

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
                .setAmount(convertToCurrency(dto.getCurrency()), dto.getAmount())
                .setMethod(convertToTransactionMethod(dto.getMethod()))
                .setFrom(dto.getFrom())
                .setTo(dto.getTo());
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
