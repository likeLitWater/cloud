package com.michael.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName: LoadBalance
 * @Package com.michael.springcloud.lb
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 19:36
 * @Version 1.0
 */
public interface LoadBalance {
    ServiceInstance getService(List<ServiceInstance> serviceInstances);
}
