package com.seckill.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.seckill.zuul.util.CookieUtil;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    public boolean shouldFilter() {
        return true;
    }


    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();

        // 被代理的微服务
        String proxy = (String) context.get("proxy");
        // 请求的地址
        String uri = (String) context.get("requestURI");

        // 由zuul 路由的 url
        String url = proxy + "/" + uri;

        HttpServletRequest request = context.getRequest();
        String loginCookie = CookieUtil.getLoginCookie(request);
        context.addZuulRequestHeader("login_key", loginCookie);

        return null;
    }
}
