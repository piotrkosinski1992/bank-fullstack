package com.kosinski.transaction.domain;

import javax.persistence.Entity;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    private TransactionId id;
    private LocalDateTime timestamp = LocalDateTime.now();
    private Currency currency;
    private BigInteger amount;
    private TransactionType type;
    private TransactionMethod method;
    private Integer from;
    private Integer to;
    private BigInteger balance;
    private String username;

    private Transaction() {
    }

    void setMethod(TransactionMethod method) {
        this.method = method;
    }

    public TransactionMethod getMethod() {
        return method;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Currency getCurrency() {
        return currency;
    }

    void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigInteger getAmount() {
        return amount;
    }

    void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    void setType(TransactionType type) {
        this.type = type;
    }

    public Integer getFrom() {
        return from;
    }

    void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    void setTo(Integer to) {
        this.to = to;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
