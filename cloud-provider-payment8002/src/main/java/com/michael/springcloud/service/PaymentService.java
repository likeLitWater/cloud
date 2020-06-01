package com.michael.springcloud.service;

import com.michael.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentService
 * @Package com.michael.springcloud.service
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 17:35
 * @Version 1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
