package com.kosinski.user.domain;

class UserBuilderInterfaces {

    public interface RoleBuilderInterface {
        EmailBuilderInterface withRole(Role role);
    }

    public interface EmailBuilderInterface {
        UsernameBuilderInterface withEmail(Email email);
    }

    public interface UsernameBuilderInterface {
        PasswordBuilderInterface withUsername(String username);
    }

    public interface PasswordBuilderInterface {
        User withPassword(String password);
    }
}
