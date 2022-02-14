package com.genius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Order9002Main {

    public static void main(String[] args) {
        SpringApplication.run(Order9002Main.class, args);
    }

}
