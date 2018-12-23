package com.toprs.consumeruserfeignwithouthystrix.feign;

import com.toprs.config.FeginConfiguration;
import com.toprs.consumeruserfeignwithouthystrix.fallback.FeginClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: scp
 * @Date: 2018/12/9 10:32
 * @Description:
 */
@FeignClient(name = "name",url="http://localhost:8763/",configuration = FeginConfiguration.class,fallback = FeginClientFallback.class)
public interface FeginClient {
    @RequestMapping(value = "/eureka/apps/{serviceName}", method = RequestMethod.GET)
    String getServiceInfoFromEurekaByServiceName(@PathVariable(value = "serviceName") String serviceName);
}
