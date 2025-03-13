package com.zhoutong.learn;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTest {

    @DefineLogger
    private Logger logger;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisKeyValueTemplate redisKeyValueTemplate;

    @Test
    public void test(){
        logger.info( stringRedisTemplate.opsForValue().get("root"));
        stringRedisTemplate.delete("root"); //删除操作
        logger.info( stringRedisTemplate.opsForValue().get("root"));
    }

}
