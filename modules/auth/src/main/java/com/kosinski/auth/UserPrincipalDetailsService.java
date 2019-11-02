package com.kosinski.auth;

import com.kosinski.domain.BaseEntity;
import com.kosinski.usecase.LoadBaseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final LoadBaseEntity loadBaseEntity;

    public UserPrincipalDetailsService(LoadBaseEntity loadBaseEntity) {
        this.loadBaseEntity = loadBaseEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseEntity baseEntity = this.loadBaseEntity.loadByUsername(username);
        return new UserPrincipal(baseEntity);
    }
}
