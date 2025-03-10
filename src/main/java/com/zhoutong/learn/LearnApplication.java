package com.zhoutong.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        System.out.println(args);
        SpringApplication.run(LearnApplication.class, args);
    }

}
