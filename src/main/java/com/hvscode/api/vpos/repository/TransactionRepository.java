package com.hvscode.api.vpos.repository;

import com.hvscode.api.vpos.controller.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository  extends CrudRepository<Transaction, Integer> {
}
