package com.toprs.consumeruserfeign.controller;

import com.toprs.common.pojo.User;
import com.toprs.consumeruserfeign.fegin.UserFeginClient;
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
    private UserFeginClient userFeginClient;

    @RequestMapping(value="/getUser/{userId}",produces = {"application/json"},method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") Integer userId){
        return userFeginClient.getUser(userId);
    }

    @RequestMapping(value="/postUser",produces = {"application/json"},method = RequestMethod.GET)
    public User postUser(){
        User user=new User();
        user.setDeptId(1);
        user.setUserName("scp");
        user.setPhone("110");
        return userFeginClient.getUser(user);
    }
}
