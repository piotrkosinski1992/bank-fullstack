package com.kosinski.events;

import java.util.UUID;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent
{
    private UUID userId;

    public UserRegisteredEvent(Object source, UUID userId)
    {
        super(source);
        this.userId = userId;
    }

    public UUID getUserId()
    {
        return userId;
    }
}
