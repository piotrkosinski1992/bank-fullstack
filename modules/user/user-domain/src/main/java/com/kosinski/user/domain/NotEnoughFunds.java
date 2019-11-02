package com.kosinski.user.domain;

class NotEnoughFunds extends RuntimeException {
    NotEnoughFunds() {
        super("You don't have enough funds to perform this action");
    }
}
