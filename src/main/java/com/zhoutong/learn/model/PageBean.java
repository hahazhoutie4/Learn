package com.zhoutong.learn.model;

import java.util.List;



public  class PageBean{
    private Long count;
    private List rows;

    public PageBean(long total, List result) {
        this.count = total;
        this.rows = result;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setList(List list) {
        this.rows = list;
    }

    public List getList() {
        return rows;
    }

//    @Override
//    public String toString() {
//        String s ="";
//        rows.stream().forEach(e->s.concat(e.toString()));
//        return "BaiduResouPageBean{" +
//                "count=" + count +
//                ", list=" + s +
//                '}';
//    }
}
