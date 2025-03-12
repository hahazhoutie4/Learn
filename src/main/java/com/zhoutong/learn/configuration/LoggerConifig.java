package com.zhoutong.learn.configuration;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.Data;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


@Configuration
public class LoggerConifig implements BeanPostProcessor, BeanFactoryPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                //test Logger配置

              //  System.out.println("fjalfsalfldshahg;ashohh312312h3L:"+root);
               // System.out.println("fjalfsalfldshahg;ashohh312312h3L:"+comZhoutong);

                // @DefineLogger注入logger日志对象
                    if(field.getAnnotation(DefineLogger.class)!=null){
                            Logger log = (Logger) LoggerFactory.getLogger(bean.getClass());
                            field.set(bean,log);
                    };
            }
        });
        ReflectionUtils.doWithMethods(bean.getClass(),new ReflectionUtils.MethodCallback(){
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                    if(method.getAnnotation(GetMapping.class)!=null){
                    }
            }
        });
      return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException {
            }
        });


        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
