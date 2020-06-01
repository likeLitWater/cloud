package com.michael.springcloud.controller;

import com.michael.springcloud.entities.CommonResult;
import com.michael.springcloud.entities.Payment;
import com.michael.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PaymentController
 * @Package com.michael.springcloud.controller
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 18:10
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果[{}], serverPort: [{}]", result, serverPort);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功，serverPort: " + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据失败，serverPort: " + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果[{}], serverPort: [{}]", payment, serverPort);
        if (payment != null) {
            return new CommonResult(200, "查询结果，serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(500, "查询结果，serverPort: " + serverPort, payment);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("********element:  [{}]", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
