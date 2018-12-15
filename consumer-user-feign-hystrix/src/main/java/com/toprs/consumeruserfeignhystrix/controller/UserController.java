package com.toprs.consumeruserfeignhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.toprs.common.pojo.User;
import com.toprs.consumeruserfeignhystrix.fegin.UserFeginClient;
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

    @RequestMapping(value="/getUser/{userId}",produces = {"application/json"},method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId){
        return userFeginClient.getUser(userId);
    }



}
