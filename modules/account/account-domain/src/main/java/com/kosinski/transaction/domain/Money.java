package com.kosinski.transaction.domain;

import com.kosinski.transaction.domain.exceptions.CurrencyMismatch;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Embeddable
public
class Money {

    @Enumerated(EnumType.STRING)
    private Currency currency;
    private BigDecimal amount;

    private Money() {
    }

    private Money(Currency currency, BigDecimal amount) {
        this.amount = validateAmount(amount);
        this.currency = validateCurrency(currency);
    }

    public static Money create(Currency currency, BigDecimal amount) {
        return new Money(currency, amount);
    }

    private BigDecimal validateAmount(BigDecimal amount) {
        assertNotNull(amount);
        assertNotNegative(amount);
        return amount;
    }

    private Currency validateCurrency(Currency currency) {
        assertNotNull(currency);
        return currency;
    }

    private void assertNotNull(Object object) {
        if (object == null) {
            throw new RuntimeException("Currency can't be null");
        }
    }

    private void assertNotNegative(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Money can't be negative");
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money subtract(Money amount) {
        verifyCurrencyIdentity(amount);
        return Money.create(currency, this.amount.subtract(amount.getAmount()));
    }

    public Money add(Money amount) {
        verifyCurrencyIdentity(amount);
        return Money.create(currency, this.amount.add(amount.getAmount()));
    }

    private void verifyCurrencyIdentity(Money amount) {
        if (currency != amount.getCurrency()) {
            throw new CurrencyMismatch(currency, amount.getCurrency());
        }
    }
}
