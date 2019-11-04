package com.kosinski.transaction.domain.exceptions;

import com.kosinski.transaction.domain.Currency;

public class CurrencyMismatch extends RuntimeException {
    public CurrencyMismatch(Currency currency1, Currency currency2) {
        super(String.format("Currency mismatch: %s and %s", currency1, currency2));
    }
}
