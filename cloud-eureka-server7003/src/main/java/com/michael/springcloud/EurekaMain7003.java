package com.michael.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: EurekaMain7003
 * @Package com.michael.springcloud
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/22 16:31
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7003.class, args);
    }
}
