package com.zhoutong.learn.model;

import org.springframework.stereotype.Repository;

@Repository
public class Depart {
    private Integer id;
    private String name;

    public Depart() {
    }

    public Depart(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
