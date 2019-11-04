package com.kosinski.user.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Currency;

@Embeddable
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
        if(object == null) {
            throw new RuntimeException("Currency can't be null");
        }
    }

    private void assertNotNegative(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Money can't be negative");
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
