package com.zhoutong.learn;

import com.good.thing.UtilTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StarterTest {

    @Autowired
    private UtilTest utilTest;

    @Test
    public void test(){
        System.out.println(utilTest.getProperties().getAddress());
    }


}
