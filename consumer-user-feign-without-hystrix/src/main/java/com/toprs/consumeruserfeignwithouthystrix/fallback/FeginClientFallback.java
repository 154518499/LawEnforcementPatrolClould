package com.toprs.consumeruserfeignwithouthystrix.fallback;

import com.toprs.consumeruserfeignwithouthystrix.feign.FeginClient;
import org.springframework.stereotype.Component;

/**
 * @Auther: scp
 * @Date: 2018/12/17 17:25
 * @Description:
 */
@Component
public class FeginClientFallback implements FeginClient {
    @Override
    public String getServiceInfoFromEurekaByServiceName(String serviceName) {
        return "连接超时";
    }
}
