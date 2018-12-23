package com.toprs.consumeruserfeignwithouthystrix.feign;

import com.toprs.common.pojo.User;
import com.toprs.config.UserFeginConfiguration;
import com.toprs.consumeruserfeignwithouthystrix.fallback.UserFeginClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: scp
 * @Date: 2018/12/9 10:32
 * @Description: feign 整合Hystrix
 */
@FeignClient(name= "provider-user" ,url = "http://localhost:1110/",fallback = UserFeginClientFallBack.class,configuration = UserFeginConfiguration.class) //eureka中Application的名称
public interface UserFeginClient {
    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.GET)
    User getUser(@PathVariable(value = "userId") String userId);

}
