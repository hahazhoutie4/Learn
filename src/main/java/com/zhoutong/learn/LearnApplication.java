package com.zhoutong.learn;

import com.zhoutong.util.UtilAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan   //扫描Filter,如果不注解，Filter过滤器无法生效
@SpringBootApplication
@UtilAutoConfigure          //导入工具包util的bean对象
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }
}
