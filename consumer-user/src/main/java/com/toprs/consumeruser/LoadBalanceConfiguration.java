package com.toprs.consumeruser;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.RandomRule;

/**
 * 配置负载均衡策略
 */
@Configuration
@ExcludeFromComponentScan
public class LoadBalanceConfiguration {
  //  @Autowired
  //  IClientConfig config;

  @Bean
  public IRule ribbonRule() {
    return new RandomRule();
  }
}
