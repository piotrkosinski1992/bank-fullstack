package com.kosinski.user.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BaseEntity {

    @EmbeddedId
    private EntityId id;
    private String username;
    private String password;
    private Role role = Role.USER;

    public BaseEntity() {
        id = EntityId.create();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public EntityId getId() {
        return id;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setRole(Role role) {
        if (role != null) {
            this.role = role;
        }
    }
}
