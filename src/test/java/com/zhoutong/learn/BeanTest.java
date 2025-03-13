package com.zhoutong.learn;

import com.zhoutong.learn.aop.AOP;
import com.zhoutong.util.JWTUtil;
import com.zhoutong.util.UtilAutoConfigure;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@SpringBootTest
@Configuration
public class BeanTest {

    @Autowired
    private JWTUtil jWTUtil;

    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void testBean(){
       Map<String ,Object> map = applicationContext.getBeansOfType(Object.class);
       map.forEach((k,v)->{
           System.out.println(k+"-->"+v+"\r\n");
       });

    }

    @Test
    public void testSPI(){
        System.out.println(jWTUtil);
    }

    @Test
    public void testI() {
   //     System.out.println(jWTUtil);
        Object bean = applicationContext.getBean("com.zhoutong.util.JWTUtil");
        System.out.println(bean);
        applicationContext.getBeansOfType(JWTUtil.class).keySet().forEach(k->{
                   System.out.println(k);
        });
    }


}

