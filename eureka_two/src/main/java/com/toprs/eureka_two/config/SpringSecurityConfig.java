package com.toprs.eureka_two.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Auther: scp
 * @Date: 2018/12/9 14:22
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password(new BCryptPasswordEncoder().encode("154518499")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,
         * 所以必须是httpBasic,如果是form方式,不能使用url格式登录
         */
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        http.csrf().disable();
    }
}
