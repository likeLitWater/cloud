package com.michael.springcloud.service;

import com.michael.springcloud.entities.CommonResult;
import com.michael.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @ClassName: PaymentService
 * @Package com.michael.springcloud.service
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 21:09
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
