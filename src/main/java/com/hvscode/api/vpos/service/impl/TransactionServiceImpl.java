package com.hvscode.api.vpos.service.impl;

import com.hvscode.api.vpos.controller.Config;
import com.hvscode.api.vpos.controller.entity.Transaction;
import com.hvscode.api.vpos.controller.impl.TransactionBuilderControllerImpl;
import com.hvscode.api.vpos.repository.TransactionRepository;
import com.hvscode.api.vpos.service.QrClientService;
import com.hvscode.api.vpos.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private QrClientService qrClientService;
    private TransactionRepository transactionRepository;
    private Config config;

    public TransactionServiceImpl(QrClientService qrClientService, TransactionRepository transactionRepository,
                                  Config config){
        this.qrClientService = qrClientService;
        this.transactionRepository = transactionRepository;
        this.config = config;
    }

    @Override
    public String prepare(Transaction transaction) {
        System.out.println(transaction);
        transactionRepository.save(transaction);
        buildLink(transaction);
        Optional.ofNullable(qrClientService.buildQr(transaction)).ifPresent(qr ->{
            transaction.setQrImage(qr);
        });
        System.out.println(transaction);
        String output = (transaction.getRequestType().equals("qr")) ? transaction.getQrImage() : transaction.getLink();

        return output;
    }


    public void buildLink(Transaction transaction){
        String urlTransaction = config.getQrContentBase().concat(String.valueOf(transaction.getTranId()));
        transaction.setLink(urlTransaction);
    }
}
