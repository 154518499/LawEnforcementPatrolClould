package com.toprs.consumeruserfeignwithhystrixhystrixfactory.fegin;

import com.toprs.common.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: scp
 * @Date: 2018/12/15 15:00
 * @Description:
 */
@Component
public class HystrixClientFallback implements UserFeignClient {
    @Override
    public User getUser(String userId) {
        System.out.println("Fallback");
        User user=new User();
        user.setUserName("Hystrix");
        return user;
    }
}
