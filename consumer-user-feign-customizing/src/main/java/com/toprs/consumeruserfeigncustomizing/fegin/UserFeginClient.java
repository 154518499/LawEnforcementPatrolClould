package com.toprs.consumeruserfeigncustomizing.fegin;

import com.toprs.config.FeginConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: scp
 * @Date: 2018/12/9 10:32
 * @Description:
 */
@FeignClient(name = "fegin-customizing",url="http://localhost:8761/",configuration = FeginConfiguration.class)
public interface UserFeginClient {
    @RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)
    String getServiceInfoFromEurekaByServiceName(@PathVariable(value = "serviceName") String serviceName);

}
