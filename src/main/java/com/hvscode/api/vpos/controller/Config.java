package com.hvscode.api.vpos.controller;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
@ToString
public class Config {

    private String apiQrUrl;
    private String qrContentBase;

}
