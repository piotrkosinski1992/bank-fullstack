package com.kosinski.user.usecase.impl;

import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.domain.Email;
import com.kosinski.user.usecase.LoadBaseEntity;
import com.kosinski.user.usecase.exceptions.UserNotFound;
import com.kosinski.user.usecase.gateways.BaseEntityQueryGateway;
import org.springframework.stereotype.Service;

@Service
public class LoadBaseEntityUsecase implements LoadBaseEntity {

    private final BaseEntityQueryGateway baseEntityQueryGateway;

    public LoadBaseEntityUsecase(BaseEntityQueryGateway baseEntityQueryGateway) {
        this.baseEntityQueryGateway = baseEntityQueryGateway;
    }

    @Override
    public BaseEntity loadByEmail(Email email) {
        return baseEntityQueryGateway.loadByEmail(email).orElseThrow(() -> new UserNotFound(email.getValue()));
    }
}
