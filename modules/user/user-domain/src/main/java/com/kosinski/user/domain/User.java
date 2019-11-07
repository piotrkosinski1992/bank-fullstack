package com.kosinski.user.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

    User() {
    }

    public static UserBuilderInterfaces.RoleBuilderInterface create() {
        return new UserBuilder();
    }
}
