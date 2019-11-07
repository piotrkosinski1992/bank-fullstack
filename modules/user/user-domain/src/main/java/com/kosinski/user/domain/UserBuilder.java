package com.kosinski.user.domain;

public class UserBuilder implements
        UserBuilderInterfaces.RoleBuilderInterface,
        UserBuilderInterfaces.EmailBuilderInterface,
        UserBuilderInterfaces.PasswordBuilderInterface {

    private User user;

    UserBuilder() {
        user = new User();
    }

    @Override
    public UserBuilderInterfaces.EmailBuilderInterface withRole(Role role) {
        user.setRole(role);
        return this;
    }

    @Override
    public UserBuilderInterfaces.PasswordBuilderInterface withEmail(Email email) {
        user.setEmail(email);
        return this;
    }

    @Override
    public User withPassword(String password) {
        user.setPassword(password);
        return user;
    }



}
