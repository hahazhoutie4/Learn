package com.zhoutong.learn;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;
import com.zhoutong.learn.configuration.MybatisConfigure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
public class MybatisTest {

    @DefineLogger
    private Logger logger;
    @Autowired
    private MybatisConfigure mybatisConfigure;

    @Autowired
    private HttpServletRequest request;

    @Test
    public  void testMybatis(){
        logger.info(mybatisConfigure.getDriverClassName());
        logger.info("request:{}",request);
    }


}
