package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyRule
 * @Package com.rule
 * @Description: TODO
 * @Author Mr.Z
 * @Date 2020/5/23 17:29
 * @Version 1.0
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
