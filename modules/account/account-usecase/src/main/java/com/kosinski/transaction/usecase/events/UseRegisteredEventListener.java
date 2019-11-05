package com.kosinski.transaction.usecase.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.kosinski.events.UserRegisteredEvent;
import com.kosinski.transaction.usecase.CreateAccount;

@Component
public class UseRegisteredEventListener
{
    private final CreateAccount createAccount;

    public UseRegisteredEventListener(CreateAccount account)
    {
        createAccount = account;
    }

    @EventListener
    public void execute(UserRegisteredEvent event) {
        createAccount.create(event.getUserId());
    }
}
