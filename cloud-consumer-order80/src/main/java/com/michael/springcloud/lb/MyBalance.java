package com.michael.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: MyBalance
 * @Package com.michael.springcloud.lb
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 19:38
 * @Version 1.0
 */
@Component
public class MyBalance implements LoadBalance {

    private AtomicInteger index = new AtomicInteger(0);

    private final int incrementAndGet() {
        int current;
        int next;
        do {
            current = this.index.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        } while (!this.index.compareAndSet(current, next));
        return next;
    }

    public ServiceInstance getService(List<ServiceInstance> serviceInstances) {
        int index = incrementAndGet() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
