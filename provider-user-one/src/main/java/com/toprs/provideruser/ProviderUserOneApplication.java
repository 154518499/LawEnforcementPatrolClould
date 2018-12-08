package com.toprs.provideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUserOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserOneApplication.class, args);
	}
}
