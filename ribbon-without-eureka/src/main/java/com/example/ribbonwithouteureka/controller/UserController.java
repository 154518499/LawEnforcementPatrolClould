package com.example.ribbonwithouteureka.controller;

import com.toprs.common.pojo.User;
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
    RestTemplate restTemplate;
    @RequestMapping(value="/getUser/{userId}",produces = {"application/json"},method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId){
        //provider-user 虚拟IP
        return this.restTemplate.getForObject("http://provider-user/user/getUser/" + userId, User.class);
    }
}
