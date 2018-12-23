package com.toprs.consumeruserfeignwithouthystrix.fallback;

import com.toprs.common.pojo.User;
import com.toprs.consumeruserfeignwithouthystrix.feign.UserFeginClient;
import org.springframework.stereotype.Component;

/**
 * @Auther: scp
 * @Date: 2018/12/17 17:20
 * @Description:
 */
@Component
public class UserFeginClientFallBack implements UserFeginClient {
    @Override
    public User getUser(String userId) {
        System.out.println("获取user超时");
        User user=new User();
        user.setUserName("没用户");
        return user;
    }
}
