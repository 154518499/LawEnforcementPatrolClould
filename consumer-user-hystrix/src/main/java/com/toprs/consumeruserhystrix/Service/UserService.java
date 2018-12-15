package com.toprs.consumeruserhystrix.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.toprs.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: scp
 * @Date: 2018/12/15 12:28
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserFallback")
    public User getUser(String userId) {
        return this.restTemplate.getForObject("http://provider-user/user/getUser/" + userId, User.class);
    }


    public User getUserFallback( String userId){
        System.out.println("hahahhahaha");
        User user=new User();
        user.setUserName("Hystrix");
        user.setPhone("110");
        return user;
    }
}
