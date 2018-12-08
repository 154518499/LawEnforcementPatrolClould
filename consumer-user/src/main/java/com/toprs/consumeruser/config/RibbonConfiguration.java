package com.toprs.consumeruser.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.toprs.consumeruser.ExcludeFromComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义Ribbon的负载均衡
 */
@Configuration
@ExcludeFromComponentScan
public class RibbonConfiguration {
    @Autowired
    IClientConfig config;

  @Bean
  public IRule ribbonRule(IClientConfig config) {
    System.out.println("RandomRule()");
    return new RandomRule();
  }
}
