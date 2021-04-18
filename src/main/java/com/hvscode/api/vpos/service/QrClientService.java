package com.hvscode.api.vpos.service;

import com.hvscode.api.vpos.controller.entity.Transaction;

public interface QrClientService {


    String buildQr(Transaction transaction);

}
