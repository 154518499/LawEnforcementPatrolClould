package com.toprs.consumeruserfeign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//不加此注解FeginClient不能注入
public class ConsumerUserFeignApplication {
	@Bean//为Fegin配置日志
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserFeignApplication.class, args);
	}
}
