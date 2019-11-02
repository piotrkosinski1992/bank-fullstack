package com.kosinski.user.usecase;

import com.kosinski.transaction.domain.Transaction;

public interface UpdateUserBalance {
    void pay(Transaction transaction);
}
