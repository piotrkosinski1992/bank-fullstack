package com.kosinski.transaction.domain.transaction;

import com.kosinski.transaction.domain.Money;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @EmbeddedId
    private TransactionId id;
    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime timestamp = LocalDateTime.now();

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    private TransactionMethod method;
    @Column(name = "T_FROM")
    private Long from;
    @Column(name = "T_TO")
    private Long to;
    private BigDecimal balance;
    private String username;

    Transaction() {
        this.id = new TransactionId();
    }

    public static TransactionBuilderInterfaces.AmountBuilderInterface create() {
        return new TransactionBuilder();
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

    public Money getAmount() {
        return amount;
    }

    void setAmount(Money amount) {
        this.amount = amount;
    }

    public Long getFrom() {
        return from;
    }

    void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    void setTo(Long to) {
        this.to = to;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TransactionId getId() {
        return id;
    }
}
