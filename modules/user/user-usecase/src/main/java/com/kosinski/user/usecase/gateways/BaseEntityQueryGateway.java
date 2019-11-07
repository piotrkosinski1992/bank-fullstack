package com.kosinski.user.usecase.gateways;


import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.domain.Email;

import java.util.Optional;

public interface BaseEntityQueryGateway {
    Optional<BaseEntity> loadByEmail(Email email);
}
