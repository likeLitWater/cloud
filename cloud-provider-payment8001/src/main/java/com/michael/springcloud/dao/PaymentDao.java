package com.michael.springcloud.dao;

import com.michael.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Package com.michael.springcloud.dao
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 17:14
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
