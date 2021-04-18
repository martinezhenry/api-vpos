package com.hvscode.api.vpos.controller.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarCode {

    private String codeText;
    private byte[] barCodeRaw;
    private String mediaType;

}
