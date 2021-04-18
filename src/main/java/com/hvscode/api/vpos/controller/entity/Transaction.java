package com.hvscode.api.vpos.controller.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue
    private long tranId;
    @Column
    private double amount;
    @Column
    private int accType;
    @Column
    private Date datetime;
    @Column
    private String description;
    @Column
    private String terminalId;
    @Column
    private String ipOrigen;
    @Column
    private String cardAcceptorId;
    @Column
    private int currency;
    @Column(length = 5012)
    private String qrImage;
    @Column
    private String link;
    @Column
    private String requestType;


}
