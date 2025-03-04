package com.zhoutong.learn.model;

import org.springframework.stereotype.Repository;

@Repository
public class Account_ {
    private Integer id;
    private String username;
    private String pwd;
    private String descript;

    public Account_() {
    }

    public Account_(Integer id, String username, String pwd, String descript) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.descript = descript;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
