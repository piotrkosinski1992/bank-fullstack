package com.kosinski.user.gateway;

import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.usecase.gateways.BaseEntityQueryGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseBaseEntityGateway implements BaseEntityQueryGateway {

    private final BaseEntityRepository baseEntityRepository;

    public DatabaseBaseEntityGateway(BaseEntityRepository baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

    @Override
    public Optional<BaseEntity> loadByUsername(String username) {
        return baseEntityRepository.findByUsername(username);
    }
}
