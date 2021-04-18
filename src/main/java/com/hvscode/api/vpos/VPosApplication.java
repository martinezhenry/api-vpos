package com.hvscode.api.vpos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VPosApplication {

    public static void main(String[] args) {
        new SpringApplication(VPosApplication.class).run(args);
    }
}
