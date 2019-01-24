package com.example.gatewayzuulfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: scp
 * @Date: 2019/1/24 15:42
 * @Description: zuul拦截器
 */
public class PreZuulFilter extends ZuulFilter{
    @Override
    public String filterType() {
        System.out.println("filterType");
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        System.out.println("filterOrder");
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("shouldFilter");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println("拦截");
        // 过滤该请求，不对其进行路由
        requestContext.setSendZuulResponse(false);
        //返回错误代码
        requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        return false;
    }
}
