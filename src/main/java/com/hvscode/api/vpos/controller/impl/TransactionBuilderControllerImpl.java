package com.hvscode.api.vpos.controller.impl;

import com.hvscode.api.vpos.controller.TransactionBuilderController;
import com.hvscode.api.vpos.controller.entity.Transaction;
import com.hvscode.api.vpos.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/${version}/transaction")
@CrossOrigin(origins = {"*"})
public class TransactionBuilderControllerImpl implements TransactionBuilderController {

    private TransactionService transactionService;

    public TransactionBuilderControllerImpl(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/prepare", produces = MediaType.APPLICATION_JSON_VALUE)
    public String prepare(Transaction transaction){

        return transactionService.prepare(transaction);

    }

}

