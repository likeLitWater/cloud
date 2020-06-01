package com.michael.springcloud.controller;

import com.michael.springcloud.entities.CommonResult;
import com.michael.springcloud.entities.Payment;
import com.michael.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Package com.michael.springcloud.controller
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 21:11
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentService.getPaymentById(id);
    }
}
