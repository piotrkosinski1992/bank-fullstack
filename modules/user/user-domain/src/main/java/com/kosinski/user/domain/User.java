package com.kosinski.user.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.math.BigInteger;

@Entity
public class User extends BaseEntity {

    @Embedded
    private Email email;

    @Embedded
    private Account account;

    User() {
    }

    public static UserBuilderInterfaces.RoleBuilderInterface create() {
        return new UserBuilder();
    }


    public Email getEmail() {
        return email;
    }

    void setEmail(Email email) {
        this.email = email;
    }

    public BigInteger getAccountBalance() {
        return account.getBalance();
    }

    public void withdraw(BigInteger amount) {
       if(getAccountBalance().compareTo(amount) < 1) {
           throw new NotEnoughFunds();
       }
       account.withdraw(amount);
    }

    public void deposit(BigInteger amount) {
        account.deposit(amount);
    }
}
