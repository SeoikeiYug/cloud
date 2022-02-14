package com.genius.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class CustomRule {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
