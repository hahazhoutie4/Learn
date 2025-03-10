package com.zhoutong.learn.configuration;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class MybatisConfigure {
    public SqlSessionTemplate getSessionTemplate() throws FileNotFoundException {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(new InputStreamReader(new FileInputStream(new File(""))));
        try (SqlSessionTemplate template = new SqlSessionTemplate(factory, ExecutorType.REUSE)) {
            return template;
        }
    }
}
