package com.kosinski.user.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

    @Embedded
    private Email email;

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
}
