package com.kosinski.transaction.domain.account;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.kosinski.transaction.domain.Currency;
import com.kosinski.transaction.domain.Money;
import com.kosinski.transaction.domain.exceptions.CurrencyMismatch;
import com.kosinski.transaction.domain.transaction.Transaction;
import com.kosinski.user.domain.NotEnoughFunds;
import com.kosinski.user.domain.UserId;

@Entity
public class Account
{
    @EmbeddedId
    private AccountNumber number;
    private Money balance;
    @Embedded
    private UserId userId;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transaction> transactions = new ArrayList<>();

    private Account(UUID userId)
    {
        this.userId = UserId.create(userId);
        this.balance = Money.create(Currency.PLN, BigDecimal.valueOf(1000L));
        this.number = AccountNumber.create();
    }

    private Account()
    {
    }

    public static Account create(UUID userId)
    {
        return new Account(userId);
    }

    public Money getBalance()
    {
        return balance;
    }

    public AccountNumber getNumber()
    {
        return number;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void withdraw(Money amount)
    {
        if (amount.getCurrency() != balance.getCurrency())
        {
            throw new CurrencyMismatch(amount.getCurrency(), balance.getCurrency());
        }
        this.balance = balance.subtract(amount);
    }

    public void deposit(Money amount)
    {
        this.balance = balance.add(amount);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Account account = (Account) o;
        return number.equals(account.number);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(number);
    }

    public void verifyWithdrawalPossibility(Money amount) {
        if(!amount.getCurrency().equals(balance.getCurrency())) {
            throw new CurrencyMismatch(amount.getCurrency(), balance.getCurrency());
        }
        if(amount.getAmount().compareTo(balance.getAmount()) > 0) {
            throw new NotEnoughFunds(number.getValue());
        }
    }
}
