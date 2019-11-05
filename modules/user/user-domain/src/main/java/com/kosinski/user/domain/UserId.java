package com.kosinski.user.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserId implements Serializable
{
    private static final long serialVersionUID = -7979519230387009253L;
    @Column(name = "USER_ID")
    private UUID value;

    private UserId()
    {
    }

    private UserId(UUID id)
    {
        this.value = id;
    }

    public static UserId create()
    {
        return new UserId(UUID.randomUUID());
    }

    public static UserId create(UUID id)
    {
        return new UserId(id);
    }

    public UUID getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserId userId = (UserId) o;
        return value.equals(userId.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(value);
    }

}
