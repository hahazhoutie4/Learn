package com.zhoutong.learn.model;

import org.springframework.stereotype.Repository;

@Repository
public class TbBaiduresou {
    private Integer id;
    private String time;
    private String content;

    public TbBaiduresou() {
    }

    public TbBaiduresou(String time, String content) {
        this.time = time;
        this.content = content;
    }

    @Override
    public String toString() {
        return "TbBaiduresou{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
