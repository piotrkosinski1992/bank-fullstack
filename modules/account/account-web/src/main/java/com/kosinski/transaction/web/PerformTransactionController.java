package com.kosinski.transaction.web;

import com.kosinski.transaction.usecase.PerformTransaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "transaction")
public class PerformTransactionController {
    private final TransactionMapper transactionMapper;
    private final PerformTransaction performTransactionUsecase;

    public PerformTransactionController(TransactionMapper transactionMapper, PerformTransaction performTransactionUsecase) {
        this.transactionMapper = transactionMapper;
        this.performTransactionUsecase = performTransactionUsecase;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransactionCommandDTO transactionCommandDTO, Principal principal) {
        performTransactionUsecase.save(transactionMapper.toEntity(transactionCommandDTO), principal.getName());
    }
}
