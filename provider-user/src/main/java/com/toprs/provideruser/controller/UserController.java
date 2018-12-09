package com.toprs.provideruser.controller;

import com.netflix.discovery.EurekaClient;
import com.toprs.provideruser.entity.User;
import com.toprs.provideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: scp
 * @Date: 2018/12/4 11:35
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EurekaClient eurekaClient;

    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "userId")Long userId){
        System.out.println("ip:1110");
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/postUser",method = RequestMethod.POST)
    public User postUser(User user){
        System.out.println("postUser");
        return user;
    }


}
