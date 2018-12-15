package com.toprs.consumeruserhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.toprs.common.pojo.User;
import com.toprs.consumeruserhystrix.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: scp
 * @Date: 2018/12/8 10:15
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUser/{userId}",produces = {"application/json"},method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getUserFallback")
    public User getUser(@PathVariable("userId") String userId){
        //provider-user 虚拟IP
        System.out.println("getUser");
        return this.restTemplate.getForObject("http://provider-user/user/getUser/" + userId, User.class);
    }

    public User getUserFallback( String userId){
        System.out.println("Fallback");
        User user=new User();
        user.setUserName("Hystrix");
        user.setPhone("110");
        return user;
    }
}
