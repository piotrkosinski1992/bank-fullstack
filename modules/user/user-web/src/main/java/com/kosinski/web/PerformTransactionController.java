package com.kosinski.web;

import com.kosinski.user.usecase.UpdateUserBalance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transaction")
public class PerformTransactionController {

    private final UpdateUserBalance updateUserBalance;
    private final TransactionMapper transactionMapper;

    public PerformTransactionController(UpdateUserBalance updateUserBalance, TransactionMapper transactionMapper) {
        this.updateUserBalance = updateUserBalance;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransactionCommandDTO transactionCommandDTO) {
//        updateUserBalance.transfer(transactionMapper.toEntity(transactionCommandDTO));
    }
}
