package com.zhoutong.learn.aop;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AspectTemplate {

    @Autowired
    private HttpServletRequest request;

    @DefineLogger
    private Logger logger ;
    /**
     * 基于定义方法名的切点
     * 定义切点，后续可以根据这个方法匹配切点
     */
    @Pointcut("execution(* com.zhoutong.learn.service.*.*(..))")
    public void dataAccess() {
    }
    /**
     * 基于注解的切点
     * 注解@AOP的切点
     */
    @Pointcut("@annotation(com.zhoutong.learn.aop.AOP)")
    public void aop(){
    }

    /**
     * 面向切面execution() 为指定的方法 *匹配返回值 *匹配类 *(..)匹配方法名
     * @param p
     * @return
     * @throws Throwable
     */
    @Around("dataAccess()")
    public Object getdataAccessUser(ProceedingJoinPoint p) throws Throwable {
        String token = request.getHeader("token");   //获取jwt令牌，令牌中可以解析获取用户信息
        logger.info("获取到的令牌{}",token);
        long start = System.currentTimeMillis();
        Object o =  p.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - start;        //获取操作耗时
        logger.info(p.getSignature()+"方法耗时："+costTime/1000+"s,方法参数："+p.getArgs());
        return o;
    }

    @Before("aop()")
    public void  before(JoinPoint joinPoint) throws Throwable {
        logger.info("aop()切点,{} ",joinPoint.getTarget().getClass().getName());
    //    System.out.println("aop切点,before方法执行:{}"+ joinPoint);
    }

}
