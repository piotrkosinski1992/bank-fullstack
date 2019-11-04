package com.kosinski.web.exceptions;

public class UnsupportedCurrency extends RuntimeException {
    public UnsupportedCurrency(String currency) {
        super(String.format("Unsupported currency: %s", currency));
    }
}
