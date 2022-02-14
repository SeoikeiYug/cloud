package com.genius.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfoOK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + " paymentInfoOK, id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    public String paymentInfoTimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " paymentInfoTimeOut, id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): 3";
    }

}
