package com.kosinski.user.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class EntityId implements Serializable {

    private static final long serialVersionUID = -7979519230387009253L;
    private UUID value;

    private EntityId() {
    }

    private EntityId(UUID id) {
        this.value = id;
    }

    public static EntityId create() {
        return new EntityId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityId entityId = (EntityId) o;
        return value.equals(entityId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
