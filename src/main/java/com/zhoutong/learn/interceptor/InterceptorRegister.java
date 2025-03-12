package com.zhoutong.learn.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

    @Autowired
    private Interceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器过滤地址  addpathPattern /** 为拦截所有地址   excludePathPattern /depart 为不拦截的地址
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/depart");
    }
}
