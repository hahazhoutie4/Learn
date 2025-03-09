package com.zhoutong.learn;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class SpringFrameWorkTest implements MethodInterceptor {


    @Test
    public void test(){
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object o = context.getBean("resou");
 //       Arrays.stream(o.getClass().getMethods()).forEach(System.out::println);
//        o.getClass().getMethods()[0].invoke(o);
//        System.out.println(o.getClass().getMethods()[1].invoke(o));
//        System.out.println(o.getClass().getMethods()[0].getName());
//        System.out.println(o.getClass().getClassLoader());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(o.getClass());
        enhancer.setCallback(SpringFrameWorkTest.class.newInstance());
        Object object = enhancer.create();
        Arrays.stream(object.getClass().getMethods()).forEach(System.out::println);
 //       System.out.println(o);
 //       Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //before 方法
        System.out.println("before");
        Object s = methodProxy.invokeSuper(o,objects);
        //after 方法
        System.out.println("after");
        return s;
    }
}
