package com.kosinski.auth;

import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.domain.Email;
import com.kosinski.user.usecase.LoadBaseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final LoadBaseEntity loadBaseEntity;

    public UserPrincipalDetailsService(LoadBaseEntity loadBaseEntity) {
        this.loadBaseEntity = loadBaseEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        BaseEntity baseEntity = this.loadBaseEntity.loadByEmail(Email.create(username));
        return new UserPrincipal(baseEntity);
    }
}
