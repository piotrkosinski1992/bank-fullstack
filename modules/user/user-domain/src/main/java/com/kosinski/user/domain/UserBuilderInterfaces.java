package com.kosinski.user.domain;

class UserBuilderInterfaces {

    public interface RoleBuilderInterface {
        EmailBuilderInterface withRole(Role role);
    }

    public interface EmailBuilderInterface {
        PasswordBuilderInterface withEmail(Email email);
    }

    public interface PasswordBuilderInterface {
        User withPassword(String password);
    }
}
