package com.kosinski.user.gateway;

import com.kosinski.user.domain.BaseEntity;
import com.kosinski.user.domain.EntityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseEntityRepository extends JpaRepository<BaseEntity, EntityId> {
    Optional<BaseEntity> findByUsername(String username);
}
