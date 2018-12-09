package com.toprs.consumeruserfeigncustomizing;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerUserFeignCustomizingApplication {
	@Bean//配置访问eureka的账号密码
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("admin", "154518499");
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserFeignCustomizingApplication.class, args);
	}
}
