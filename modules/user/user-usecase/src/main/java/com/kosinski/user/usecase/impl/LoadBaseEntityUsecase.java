package com.kosinski.user.usecase.impl;

import com.kosinski.user.domain.BaseEntity;
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
    public BaseEntity loadByUsername(String username) {
        return baseEntityQueryGateway.loadByUsername(username).orElseThrow(() -> new UserNotFound(username));
    }
}
