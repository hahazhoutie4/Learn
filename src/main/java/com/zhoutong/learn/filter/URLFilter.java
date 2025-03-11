package com.zhoutong.learn.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class URLFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);    //默认init
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到请求");
        System.out.println("执行filter");
        filterChain.doFilter(servletRequest,servletResponse);       //放行方法
        System.out.println("放行之后的代码");
    }

    @Override
    public void destroy() {
        System.out.println("Filter销毁完成");
        Filter.super.destroy();
    }
}
