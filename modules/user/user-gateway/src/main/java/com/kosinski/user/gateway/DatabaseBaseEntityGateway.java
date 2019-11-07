package com.kosinski.user.gateway;

import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.domain.Email;
import com.kosinski.user.usecase.gateways.BaseEntityQueryGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseBaseEntityGateway implements BaseEntityQueryGateway {

    private final BaseEntityRepository baseEntityRepository;

    public DatabaseBaseEntityGateway(BaseEntityRepository baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

    public Optional<BaseEntity> loadByEmail(Email email) {
        return baseEntityRepository.findByEmailValue(email.getValue());
    }
}
