package com.hvscode.api.vpos.service.impl;

import com.hvscode.api.vpos.controller.Config;
import com.hvscode.api.vpos.controller.entity.BarCode;
import com.hvscode.api.vpos.controller.entity.Message;
import com.hvscode.api.vpos.service.QrClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class QrClientServiceImpl implements QrClientService {

    private RestTemplate restTemplate;
    private Config config;

    public QrClientServiceImpl(Config config){
        this.restTemplate = new RestTemplate();
        this.config = config;
    }

    @Override
    public String buildQr(long tranId) {

        String urlTransaction = config.getQrContentBase().concat(String.valueOf(tranId));

        HttpEntity<String> requestBody = new HttpEntity<>(urlTransaction);


        Message<BarCode> message = restTemplate.exchange(config.getApiQrUrl(),
                HttpMethod.POST,
                requestBody,
                new ParameterizedTypeReference<Message<BarCode>>() {}
                ).getBody();


        AtomicReference<String> qrRaw = new AtomicReference<>("");
        Optional.ofNullable(message).ifPresent(msg -> {
            if (msg.getResponseCode().equals("00")) {
                String data = Base64Utils.encodeToString(msg.getBody().getBarCodeRaw());
                qrRaw.set(data);
            }
        });

        return qrRaw.get();
    }
}
