package com.michael.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Package com.michael.springcloud.controller
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 9:54
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_PORT = "http://cloud-provider-payment";
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentConsul(){
        return restTemplate.getForObject(PAYMENT_PORT + "/payment/consul", String.class);
    }
}
