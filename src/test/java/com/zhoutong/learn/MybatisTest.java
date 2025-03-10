package com.zhoutong.learn;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@SpringBootTest
public class MybatisTest {

    @Test
    public  void testMybatis() throws FileNotFoundException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(new InputStreamReader(new FileInputStream(new File("/mybatis.xml"))));
        try (SqlSessionTemplate template = new SqlSessionTemplate(factory, ExecutorType.REUSE)) {
            System.out.println(template);
        }

    }


}
