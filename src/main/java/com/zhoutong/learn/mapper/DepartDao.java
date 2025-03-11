package com.zhoutong.learn.mapper;

import com.zhoutong.learn.model.Depart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface DepartDao {

//    @Select("select * from depart")
    public List<Depart> list();

//    @Select("select * from depart where id=#{id}")
   public List<Depart> getDepartById(int id);

//    @Select("select * from depart where id=${id}")
//    public Depart getDepartById(Integer id);
}