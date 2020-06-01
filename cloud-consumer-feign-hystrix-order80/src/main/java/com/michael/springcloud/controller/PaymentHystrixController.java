package com.michael.springcloud.controller;

import com.michael.springcloud.servicer.PaymantHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentHystrixController
 * @Package com.michael.springcloud.servicer.controller
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/25 14:00
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymantHystrixService paymantHystrixService;
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymantHystrixService.paymentInfo_OK(id);
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymantHystrixService.paymentInfo_TimeOut(id);
    }
}
