package com.toprs.consumeruserfeignwithouthystrix.controller;

import com.toprs.common.pojo.User;
import com.toprs.consumeruserfeignwithouthystrix.feign.FeginClient;
import com.toprs.consumeruserfeignwithouthystrix.feign.UserFeginClient;
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
public class UserController {
    @Autowired
    private FeginClient feginClient;
    @Autowired
    private UserFeginClient userFeginClient;

    /**
     * 通过Application name 获取eureka中服务提供者的信息
     * @param serviceName
     * @return
     */
    @RequestMapping(value="/{serviceName}",produces = {"application/json"},method = RequestMethod.GET)
    public String getServiceInfo(@PathVariable("serviceName") String serviceName){
        return feginClient.getServiceInfoFromEurekaByServiceName(serviceName);
        //return feginClient.test(serviceName);
    }


    @RequestMapping(value="/getUser/{userId}",produces = {"application/json"},method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") String userId) throws InterruptedException {
        return userFeginClient.getUser(userId);
    }
}
