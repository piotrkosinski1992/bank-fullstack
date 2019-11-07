package com.kosinski.user.usecase;

import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.domain.Email;

public interface LoadBaseEntity {
    BaseEntity loadByEmail(Email email);
}
