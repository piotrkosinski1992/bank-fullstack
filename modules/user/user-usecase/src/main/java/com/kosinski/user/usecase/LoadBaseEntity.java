package com.kosinski.user.usecase;

import com.kosinski.user.domain.BaseEntity;

public interface LoadBaseEntity {
    BaseEntity loadByUsername(String username);
}
