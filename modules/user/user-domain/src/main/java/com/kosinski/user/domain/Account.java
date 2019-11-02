package com.kosinski.user.domain;

import java.math.BigInteger;

class Account {
    private Integer number;
    private BigInteger balance;

    private Account() {
    }

    void setNumber(Integer number) {
        this.number = number;
    }

    public BigInteger getBalance() {
        return balance;
    }

    void withdraw(BigInteger amount) {
        balance.subtract(amount);
    }

    void deposit(BigInteger amount) {
        balance.add(amount);
    }
}
