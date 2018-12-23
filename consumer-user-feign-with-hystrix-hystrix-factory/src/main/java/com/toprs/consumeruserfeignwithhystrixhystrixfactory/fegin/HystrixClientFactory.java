package com.toprs.consumeruserfeignwithhystrixhystrixfactory.fegin;

import com.toprs.common.pojo.User;
import org.slf4j.Logger;
import feign.hystrix.FallbackFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: scp
 * @Date: 2018/12/23 13:13
 * @Description:
 */
@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);
    @Override
    public UserFeignClient create(Throwable throwable) {
        HystrixClientFactory.LOGGER.error("fallback; reason was: {}", throwable.getMessage());
        return new UserFeignClientWithFactory(){
            @Override
            public User getUser(String userId) {
                System.out.println("Fallback");
                User user=new User();
                user.setUserName("HystrixFactory");
                return user;
            }

        };
        
    }
}
