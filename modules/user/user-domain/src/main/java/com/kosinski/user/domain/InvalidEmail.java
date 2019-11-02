package com.kosinski.user.domain;

class InvalidEmail extends RuntimeException {
     InvalidEmail(String email) {
        super(String.format("Invalid email: %s ", email));
    }
}
