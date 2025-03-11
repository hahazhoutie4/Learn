package com.zhoutong.learn.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfigure {
    @Bean(name = "log")
    public Logger getLogger(){
        Logger logger = LoggerFactory.getLogger(LoggerConfigure.class);
        logger.info(Level.INFO.toString(),this.getClass());
         return logger;
    }
}
