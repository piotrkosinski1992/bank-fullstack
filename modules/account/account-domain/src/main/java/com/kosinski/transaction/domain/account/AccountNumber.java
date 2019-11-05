package com.kosinski.transaction.domain.account;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Embeddable
public class AccountNumber implements Serializable {

    private static final long MIN_ACC_NUM = 10000000000000L;
    private static final long MAX_ACC_NUM = 99999999999999L;
    private static final long serialVersionUID = -5676983151111094425L;

    private Long value;

    private AccountNumber() {
        this.value = generateId();
    }

    private AccountNumber(Long number) {
        this.value = number;
    }

    private Long generateId() {
        return ThreadLocalRandom.current().nextLong(MIN_ACC_NUM, MAX_ACC_NUM);
    }

    public static AccountNumber create() {
        return new AccountNumber();
    }

    public static AccountNumber create(Long number) {
        return new AccountNumber(number);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNumber accountNumber = (AccountNumber) o;
        return value.equals(accountNumber.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
