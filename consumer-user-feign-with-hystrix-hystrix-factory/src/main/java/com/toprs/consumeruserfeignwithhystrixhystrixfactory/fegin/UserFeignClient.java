package com.toprs.consumeruserfeignwithhystrixhystrixfactory.fegin;

import com.toprs.common.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: scp
 * @Date: 2018/12/9 10:32
 * @Description: feign 整合Hystrix
 */
@FeignClient(name= "provider-user" ,fallbackFactory = HystrixClientFactory.class) //eureka中Application的名称
public interface UserFeignClient {
    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.GET)
    User getUser(@PathVariable(value = "userId") String userId);

}
