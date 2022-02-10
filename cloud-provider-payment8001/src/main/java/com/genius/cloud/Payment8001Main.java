package com.genius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Payment8001Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
    }

}
