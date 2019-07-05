package com.clouds.zh.itsop.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * api 网关过滤器
 */
@Component
public class RoutesFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(RoutesFilter.class);

    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序,数值越小,优先过滤
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            logger.warn("Token is empty");
            //不允许访问
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                //对外写出显示,需设置编码
                HttpServletResponse response = context.getResponse();
                response.setContentType("text/html;charset=utf-8");
                context.getResponse().getWriter().write("Token is empty,权限不足");
            } catch (IOException e) {
            }
        } else {
            logger.info("OK");
        }
        return null;
    }
}