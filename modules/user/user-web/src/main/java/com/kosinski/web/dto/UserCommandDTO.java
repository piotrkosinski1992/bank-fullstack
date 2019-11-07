package com.kosinski.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserCommandDTO extends UserDTO {

    @NotNull(message = "email can't be null")
    @NotEmpty(message = "email can't be empty")
    private String email;

    @NotNull(message = "password can't be null")
    @NotEmpty(message = "password can't be empty")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
