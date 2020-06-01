package com.michael.springcloud.controller;

import com.michael.springcloud.entities.CommonResult;
import com.michael.springcloud.entities.Payment;
import com.michael.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @ClassName: OrderController
 * @Package com.michael.springcloud.controller
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/21 19:27
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable String id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @Resource
    private LoadBalance loadBalance;

    @GetMapping("/consumer/payment/lb/{id}")
    public String getPaumentUrlByRule(@PathVariable String id) {
        ServiceInstance service = loadBalance.getService(discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"));
        URI uri = service.getUri();
        return restTemplate.getForObject(uri + "/payment/get/" + id, String.class);
    }
}
