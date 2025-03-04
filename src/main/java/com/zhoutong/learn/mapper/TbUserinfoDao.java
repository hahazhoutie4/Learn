package com.zhoutong.learn.mapper;

import com.zhoutong.learn.model.TbUserinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbUserinfoDao {

    public int insertUser(TbUserinfo tbUserinfo);

    public List<TbUserinfo> list();

    public List<TbUserinfo> getUserById(int id);
}
