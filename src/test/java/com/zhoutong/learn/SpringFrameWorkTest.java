package com.zhoutong.learn;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class SpringFrameWorkTest implements  InvocationHandler {

    @DefineLogger
    private Logger logger;

    @Test
    public void test(){
    }

    @Test
    public void tst()throws InvocationTargetException, IllegalAccessException, InstantiationException {
        logger.info("地址为{}",SpringFrameWorkTest.class.getResource("../../../"));
        Object o = Proxy.newProxyInstance(SpringFrameWorkTest.class.getClassLoader(), SpringFrameWorkTest.class.getInterfaces(),new SpringFrameWorkTest());
        logger.info("对象为：{}",o);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
