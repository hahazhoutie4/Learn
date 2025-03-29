package com.zhoutong.learn.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.datasource")
@Component
@Data
public class MybatisConfigure {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public MybatisConfigure() {
    }

    public MybatisConfigure(String driverClassName, String url, String username, String password) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

}
