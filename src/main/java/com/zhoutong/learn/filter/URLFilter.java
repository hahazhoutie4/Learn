package com.zhoutong.learn.filter;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class URLFilter implements Filter {

    @DefineLogger
    private Logger logger;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);    //默认init,不用操作
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Filter拦截到请求");
        logger.info("执行Filter拦截前代码");
        filterChain.doFilter(servletRequest,servletResponse);       //放行方法
        logger.info("执行Filter拦截后代码");
    }

    @Override
    public void destroy() {
        logger.info("Filter销毁完成");
        Filter.super.destroy();
    }
}
