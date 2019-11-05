package com.kosinski.transaction.domain.transaction;

import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.account.AccountNumber;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @EmbeddedId
    private TransactionId id;
    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime timestamp = LocalDateTime.now();


    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "AMOUNT_CURRENCY")),
            @AttributeOverride(name = "amount", column = @Column(name = "AMOUNT_AMOUNT")),
    })
    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    private TransactionMethod method;

    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "T_FROM")),
    })
    @Embedded
    private AccountNumber from;

    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "T_TO")),
    })
    @Embedded
    private AccountNumber to;

    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "BALANCE_CURRENCY")),
            @AttributeOverride(name = "amount", column = @Column(name = "BALANCE_AMOUNT")),
    })
    @Embedded
    private Money currentBalance;

    public Transaction() {
        this.id = new TransactionId();
    }

    public static TransactionBuilderInterfaces.AmountBuilderInterface create() {
        return new TransactionBuilder();
    }

    void setId(TransactionId id) {
        this.id = id;
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

    public AccountNumber getFrom() {
        return from;
    }

    public void setFrom(AccountNumber from) {
        if (this.from != null) {
            throw new RuntimeException("You can't override from account number you fool!");
        }
        this.from = from;
    }

    public AccountNumber getTo() {
        return to;
    }

    void setTo(AccountNumber to) {
        this.to = to;
    }

    public Money getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Money currentBalance) {
        this.currentBalance = currentBalance;
    }

    public TransactionId getId() {
        return id;
    }
}
