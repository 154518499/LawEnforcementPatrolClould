package com.toprs.consumeruserfeigncustomizing.controller;

import com.toprs.consumeruserfeigncustomizing.fegin.UserFeginClient;
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
    private UserFeginClient userFeginClient;

    /**
     * 通过Application name 获取eureka中服务提供者的信息
     * @param serviceName
     * @return
     */
    @RequestMapping(value="/{serviceName}",produces = {"application/json"},method = RequestMethod.GET)
    public String getUser(@PathVariable("serviceName") String serviceName){
        return userFeginClient.getServiceInfoFromEurekaByServiceName(serviceName);
    }

}
