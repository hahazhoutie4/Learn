package com.zhoutong.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTemplate {

    @Around("execution(* com.zhoutong.learn.service.*.*(..))")
    public Object timecount(ProceedingJoinPoint p) throws Throwable {
        long start = System.currentTimeMillis();
        Object o =  p.proceed();
        long end = System.currentTimeMillis();
        System.out.println(p.getSignature()+"方法耗时："+(end-start)/1000+"s");
        return o;
    }


}
