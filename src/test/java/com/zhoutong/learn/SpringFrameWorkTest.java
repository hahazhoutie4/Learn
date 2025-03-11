package com.zhoutong.learn;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class SpringFrameWorkTest implements  InvocationHandler {


    @Test
    public void test(){
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
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
        System.out.println(SpringFrameWorkTest.class.getResource("../../../"));
        Object o = Proxy.newProxyInstance(SpringFrameWorkTest.class.getClassLoader(), SpringFrameWorkTest.class.getInterfaces(),new SpringFrameWorkTest());
        System.out.println(o);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
