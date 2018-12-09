package com.toprs.consumeruserfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//不加此注解FeginClient不能注入
public class ConsumerUserFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserFeignApplication.class, args);
	}
}
