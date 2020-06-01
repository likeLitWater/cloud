package com.michael.springcloud.service.impl;

import com.michael.springcloud.dao.PaymentDao;
import com.michael.springcloud.entities.Payment;
import com.michael.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentServiceImpl
 * @Package com.michael.springcloud.service.impl
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 17:49
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
