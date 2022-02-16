package com.genius.cloud.service;

public interface PaymentService {

    String paymentInfoOK(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);

}
