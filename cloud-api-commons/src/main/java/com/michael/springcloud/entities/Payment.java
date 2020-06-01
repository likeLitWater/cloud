package com.michael.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Payment
 * @Package com.michael.springcloud.entities
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 16:45
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 6717145083827848147L;
    private Long id;
    private String serial;
}
