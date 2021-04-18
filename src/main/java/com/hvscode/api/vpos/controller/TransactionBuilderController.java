package com.hvscode.api.vpos.controller;

import com.hvscode.api.vpos.controller.entity.Transaction;

public interface TransactionBuilderController {

    String prepare(Transaction transaction);

}
