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
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object o = context.getBean("resou");
 //       Arrays.stream(o.getClass().getMethods()).forEach(System.out::println);
//        o.getClass().getMethods()[0].invoke(o);
//        System.out.println(o.getClass().getMethods()[1].invoke(o));
//        System.out.println(o.getClass().getMethods()[0].getName());
//        System.out.println(o.getClass().getClassLoader());
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(o.getClass());
//        enhancer.setCallback(SpringFrameWorkTest.class.newInstance());
//        Object object = enhancer.create();
//        Arrays.stream(object.getClass().getMethods()).forEach(System.out::println);
 //       System.out.println(o);
 //       Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        logger.info("地址为{}",SpringFrameWorkTest.class.getResource("../../../"));
        Object o = Proxy.newProxyInstance(SpringFrameWorkTest.class.getClassLoader(), SpringFrameWorkTest.class.getInterfaces(),new SpringFrameWorkTest());
        logger.info("对象为：{}",o);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
