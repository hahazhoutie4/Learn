package com.zhoutong.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan   //扫描Filter,如果不注解，Filter过滤器无法生效
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhoutong.learn"})   //组件扫描
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
