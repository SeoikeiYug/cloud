package com.genius.cloud;

import com.genius.rule.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = CustomRule.class)
@EnableEurekaClient
@SpringBootApplication
public class Order9001Main {

    public static void main(String[] args) {
        SpringApplication.run(Order9001Main.class, args);
    }

}
