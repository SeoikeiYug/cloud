package com.genius.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayMain6001 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain6001.class, args);
    }

}
