package com.zhoutong.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@ConfigurationProperties(prefix = "jwt")
@Data
public class JWTUtil{

    private String expiration;
    public String generateJWTTokens(Map<String,String> map){
        String jwt = Jwts.builder()
                .expiration(new Date(expiration))
                .claims(map)
                .signWith(SignatureAlgorithm.HS256,"test")
                .compact();
        return jwt;
    }

}
