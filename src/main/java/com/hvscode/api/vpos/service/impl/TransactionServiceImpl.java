package com.hvscode.api.vpos.service.impl;

import com.hvscode.api.vpos.controller.entity.Transaction;
import com.hvscode.api.vpos.controller.impl.TransactionBuilderControllerImpl;
import com.hvscode.api.vpos.service.QrClientService;
import com.hvscode.api.vpos.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private QrClientService qrClientService;

    public TransactionServiceImpl(QrClientService qrClientService){
        this.qrClientService = qrClientService;
    }

    @Override
    public String prepare(Transaction transaction) {


        Optional.ofNullable(qrClientService.buildQr(transaction.hashCode())).ifPresent(qr ->{
            transaction.setQrImage(qr);

        });

        return transaction.getQrImage();
    }
}
