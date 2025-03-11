package com.zhoutong.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisKeyValueTemplate redisKeyValueTemplate;

    @Test
    public void test(){
//        stringRedisTemplate.opsForValue().set("root","google");
//        Map<String,String> map = new HashMap<>();
//        map.put("root","value");
        System.out.println( stringRedisTemplate.opsForValue().get("root"));
        stringRedisTemplate.delete("root"); //删除操作
        System.out.println( stringRedisTemplate.opsForValue().get("root"));
    }

}
