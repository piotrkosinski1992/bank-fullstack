package com.kosinski.user.domain;

public class NotEnoughFunds extends RuntimeException {
    public NotEnoughFunds(Long accountNumber) {
        super(String.format("You don't have enough funds to perform this action. Account Number: %s", accountNumber));
    }
}
