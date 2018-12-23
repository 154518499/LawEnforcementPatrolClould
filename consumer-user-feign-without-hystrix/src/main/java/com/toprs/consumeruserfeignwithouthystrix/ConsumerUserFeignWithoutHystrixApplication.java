package com.toprs.consumeruserfeignwithouthystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerUserFeignWithoutHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserFeignWithoutHystrixApplication.class, args);
	}

}

