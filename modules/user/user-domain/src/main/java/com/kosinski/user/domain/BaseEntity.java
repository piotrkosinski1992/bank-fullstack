package com.kosinski.user.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BaseEntity {

    @EmbeddedId
    private UserId id;
    @Embedded
    private Email email;
    private String password;
    private Role role = Role.USER;

    public BaseEntity() {
        id = UserId.create();
    }

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    void setRole(Role role) {
        if (role != null) {
            this.role = role;
        }
    }
}
