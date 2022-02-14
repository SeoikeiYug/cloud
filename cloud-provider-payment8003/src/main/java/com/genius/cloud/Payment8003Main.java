package com.genius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class Payment8003Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8003Main.class, args);
    }

}
