package com.toprs.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: scp
 * @Date: 2018/12/9 13:14
 * @Description: 配置访问eureka的账号密码
 */
@Configuration
public class SecurityConfig {
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        System.out.println("配置账号密码");
//        return new BasicAuthRequestInterceptor("admin", "154518499");
//    }
}
