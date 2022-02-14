package com.genius.cloud.controller;

import com.genius.cloud.beans.Payment;
import com.genius.cloud.common.CommonResult;
import com.genius.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功, serverPort:  " + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录, 查询ID: " + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public List<ServiceInstance> discovery() {
        // 获取eureka中注册的服务有哪些，相当于获取eureka上的服务的key
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("已注册服务: " + service);
        }

        // 通过eureka中注册的服务名称，获取所有的服务实例的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return instances;
    }

    @GetMapping("/payment/feign/timeout")
    public CommonResult<String> feignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return new CommonResult<>(200, serverPort);
    }

}
