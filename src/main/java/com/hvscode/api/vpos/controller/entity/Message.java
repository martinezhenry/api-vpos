package com.hvscode.api.vpos.controller.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message<T> {

    private String txId;
    private T body;
    private String message;
    private String responseCode;

}
