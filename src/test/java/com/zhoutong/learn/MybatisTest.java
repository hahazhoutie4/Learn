package com.zhoutong.learn;

import com.zhoutong.learn.configuration.MybatisConfigure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
public class MybatisTest {

    @Autowired
    private MybatisConfigure mybatisConfigure;

    @Autowired
    private HttpServletRequest request;

    @Test
    public  void testMybatis(){
        System.out.println(mybatisConfigure.getDriverClassName());
        System.out.println(request);
    }


}
