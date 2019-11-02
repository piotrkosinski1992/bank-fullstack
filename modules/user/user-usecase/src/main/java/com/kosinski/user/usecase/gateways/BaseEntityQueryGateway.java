package com.kosinski.user.usecase.gateways;


import com.kosinski.user.domain.BaseEntity;

import java.util.Optional;

public interface BaseEntityQueryGateway {
    Optional<BaseEntity> loadByUsername(String username);
}
