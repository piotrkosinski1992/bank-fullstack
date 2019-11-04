package com.kosinski.transaction.domain.account;

import com.kosinski.transaction.domain.Currency;
import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.exceptions.CurrencyMismatch;
import com.kosinski.transaction.domain.transaction.Transaction;
import com.kosinski.user.domain.UserId;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {

    @EmbeddedId
    private AccountNumber number;
    private Money balance = Money.create(Currency.PLN, BigDecimal.valueOf(1000L));
    private UserId userId;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transaction> transactions = new ArrayList<>();

    private Account() {
    }

    public static Account create() {
        return new Account();
    }

    public Money getBalance() {
        return balance;
    }

    public AccountNumber getNumber() {
        return number;
    }

    void withdraw(Money amount) {
        if (amount.getCurrency() != balance.getCurrency()) {
            throw new CurrencyMismatch(amount.getCurrency(), balance.getCurrency());
        }
        this.balance = balance.subtract(amount);
    }

    void deposit(Money amount) {
        this.balance = balance.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number.equals(account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
