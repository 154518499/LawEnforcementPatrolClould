package com.toprs.consumeruser;

import com.toprs.consumeruser.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
/**
 * 自定义Ribbon负载均衡配置
 * 将Ribbon配置类放到SpringBoot启动类扫描范围之外.
 * 如果放到启动类扫描范围之内,自定义@ExcludeFromComponentScan注解,
 * 添加到@ComponentScan的excludeFilters中.
 * 标注@ExcludeFromComponentScan注解将排除到SpringBoot启动类的扫描范围内
 */
@RibbonClient(name = "provider-user", configuration = RibbonConfiguration.class)
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class ConsumerUserApplication {

	@Bean
	@LoadBalanced //使restTemplate具有负载均衡的能力,默认的负载均衡策略为轮循方式
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserApplication.class, args);
	}
}
