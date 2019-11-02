package com.kosinski.web.dto;

class RoleNotFound extends RuntimeException {
    RoleNotFound(String role) {
        super(String.format("Unknown role: %s", role));
    }
}
