package com.toprs.consumeruserhystrixpropagation.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.toprs.common.pojo.User;
import com.toprs.consumeruserhystrixpropagation.fegin.UserFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: scp
 * @Date: 2018/12/8 10:15
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFeginClient userFeginClient;

    /** 信号量隔离,HystrixCommand将会在调用线程上执行，开销相对较小，并发请求受到信号量个数的限制。 默认为线程隔离 */
    @HystrixCommand(fallbackMethod = "getUserFallback" , commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
    @RequestMapping(value="/getUser/{userId}",produces = {"application/json"},method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId){
        return userFeginClient.getUser(userId);
    }


    public User getUserFallback( String userId){
        System.out.println("Fallback");
        User user=new User();
        user.setUserName("Hystrix");
        user.setPhone("110");
        return user;
    }

}
