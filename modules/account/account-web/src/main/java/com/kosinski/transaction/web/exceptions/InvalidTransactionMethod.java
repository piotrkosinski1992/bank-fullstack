package com.kosinski.transaction.web.exceptions;

public class InvalidTransactionMethod extends RuntimeException {
    public InvalidTransactionMethod(String method) {
        super(String.format("Invalid transaction method: %s", method));
    }
}
