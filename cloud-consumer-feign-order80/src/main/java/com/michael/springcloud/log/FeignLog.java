package com.michael.springcloud.log;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FeignLog
 * @Package com.michael.springcloud.log
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 21:59
 * @Version 1.0
 */
@Configuration
public class FeignLog {
    @Bean
    public Logger.Level getLogger() {
        return Logger.Level.FULL;
    }
}
