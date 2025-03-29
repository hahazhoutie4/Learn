package com.zhoutong.learn;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.configuration.DefineLogger;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ConfigurationProperties(prefix = "jwt")
@SpringBootTest
public class JWTTest {

    @DefineLogger
    private Logger logger;


    public String getSignedkey() {
        return signedkey;
    }

    public void setSignedkey(String signedkey) {
        this.signedkey = signedkey;
    }

    private String signedkey;
    @Test
    public void test() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","zhoutong");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signedkey)  //加密算法
                .claims(map)                //有效载荷
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .compact(); //1h过期
        logger.info(jwt);
    }

}
