package com.genius.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


public interface PaymentService {

    String paymentInfoOK(Integer id);

    String paymentInfoTimeOut(Integer id);

}
