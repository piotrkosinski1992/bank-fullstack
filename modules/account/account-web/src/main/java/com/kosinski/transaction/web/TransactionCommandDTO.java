package com.kosinski.transaction.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class TransactionCommandDTO {
    @NotNull
    @NotEmpty
    private String currency;

    @PositiveOrZero
    @NotNull
    @NotEmpty
    private BigDecimal amount;

    @NotNull
    @NotEmpty
    private String method;

    @NotNull
    @NotEmpty
    private Long to;

    public TransactionCommandDTO() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
