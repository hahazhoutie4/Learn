package com.zhoutong.learn.model;

import org.springframework.stereotype.Repository;

@Repository
public class TbUserinfo {
    private Integer id;
    private String userinfo;

    public TbUserinfo() {
    }

    @Override
    public String toString() {
        return "Tb_userinfo{" +
                "id=" + id +
                ", userinfo='" + userinfo + '\'' +
                '}';
    }

    public TbUserinfo(Integer id, String userinfo) {
        this.id = id;
        this.userinfo = userinfo;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
