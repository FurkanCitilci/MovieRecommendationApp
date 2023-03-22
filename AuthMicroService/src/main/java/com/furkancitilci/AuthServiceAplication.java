package com.furkancitilci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthServiceAplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceAplication.class);
    }
}