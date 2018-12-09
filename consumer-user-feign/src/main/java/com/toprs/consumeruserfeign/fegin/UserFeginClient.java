package com.toprs.consumeruserfeign.fegin;

import com.toprs.common.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: scp
 * @Date: 2018/12/9 10:32
 * @Description:
 */
@FeignClient("provider-user") //eureka中Application的名称
public interface UserFeginClient {
    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.GET)
    User getUser(@PathVariable(value="userId") Integer userId);

    @RequestMapping(value = "/user/postUser",method = RequestMethod.POST)
    User getUser(User user);
    //只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求.https://blog.csdn.net/u014281502/article/details/72896182
}
