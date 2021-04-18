package com.hvscode.api.vpos.controller.entity;

import lombok.*;

import java.util.Date;

@Data
public class Transaction {

    private double amount;
    private int accType;
    private Date datetime;
    private String description;
    private String terminalId;
    private String ipOrigen;
    private String cardAcceptorId;
    private int currency;
    private String qrImage;

}
