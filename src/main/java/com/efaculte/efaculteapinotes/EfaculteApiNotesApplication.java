package com.efaculte.efaculteapinotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.efaculte.efaculteapinotes.rest")
public class EfaculteApiNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfaculteApiNotesApplication.class, args);
    }

}
